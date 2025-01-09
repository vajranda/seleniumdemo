package automationseleniumframeworkdesign.abstractcomponents;





import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationseleniumframeworkdesign.pageobjects.Cartpage;
import automationseleniumframeworkdesign.pageobjects.Orderpage;


public class abstractComponent {
	WebDriver driver;

	public abstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartboxbutton;
	
	@FindBy(css ="button[routerlink*='myorders']" )
	WebElement ordersbutton;

	public void waitForElementToAppear(By findBy)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));

	}
	
	public void waitForWebElementToAppear(WebElement findBy)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}

	public void waitForElementToDisappear(WebElement name) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));
		wait.until(ExpectedConditions.invisibilityOf(name));

	}

	public Cartpage cartBox() {

		cartboxbutton.click();

		Cartpage cartpage = new Cartpage(driver);
		return cartpage;
	}

	public Orderpage  goToOrders()  {

	 Actions a = new Actions(driver);
	 a.click(ordersbutton).build().perform();

		
		Orderpage orderpage = new Orderpage(driver);
		return orderpage;
		
	}
	
	
}
