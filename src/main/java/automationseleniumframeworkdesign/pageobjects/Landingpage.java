package automationseleniumframeworkdesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationseleniumframeworkdesign.abstractcomponents.abstractComponent;

public class Landingpage extends abstractComponent {
	WebDriver driver;

	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement useremail;

	@FindBy(id = "userPassword")
	WebElement userpassword;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(css = "div[role='alert']")
	WebElement errormessage;
	
	
	
	public Productcatalogue loginAction(String email, String password) {

		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		submit.click();
		Productcatalogue productcatalogue = new Productcatalogue(driver);
		return productcatalogue;
	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client/");
	}

	public String loginErrorMessage() {
		
		waitForWebElementToAppear(errormessage);
		return errormessage.getText();
		
	}
	
}
