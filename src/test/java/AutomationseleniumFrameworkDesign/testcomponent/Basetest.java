package AutomationseleniumFrameworkDesign.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import automationseleniumframeworkdesign.pageobjects.Landingpage;

public class Basetest {
	public WebDriver driver;
	public Landingpage lan;

	public WebDriver initializeDriver() throws IOException {

		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//automationseleniumframeworkdesign//resources//Globaldata.properties");

		properties.load(fis);

		String browsername = System.getProperty("browser") != null ? System.getProperty("browser")
				: properties.getProperty("browser");

		// String browsername = properties.getProperty("browser");

		System.out.println(browsername);

		if (browsername.contains("chrome")) {

			ChromeOptions options = new ChromeOptions();

			if (browsername.contains("headless")) {
				options.addArguments("headless");
			
			}

			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}

		else if (browsername.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

		} else if (browsername.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();

		} else {
			throw new RuntimeException("Browser not supported: " + browsername);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		System.out.println("Browser from properties: " + browsername);
		return driver;

	}

	@BeforeMethod(alwaysRun = true)
	public Landingpage launchApplication() throws IOException {
		driver = initializeDriver();
		lan = new Landingpage(driver);
		lan.goTo();

		return lan;

	}

	@AfterMethod(alwaysRun = true)
	public void Closebrowser() {

		driver.close();
	}

	public List<HashMap<String, String>> getJasonData(String filepath) throws IOException {

		// jason convert to string
		String jsondata = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);

		// string to hashmap using jackson databind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsondata,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	public String getScreenshot(String testcase, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		File file = new File(System.getProperty("user.dir") + "//reports//" + testcase + ".png");

		FileUtils.copyFile(src, file);

		return System.getProperty("user.dir") + "//reports//" + testcase + ".png";

	}
	


}
