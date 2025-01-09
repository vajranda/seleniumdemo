package automationseleniumframeworkdesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationseleniumframeworkdesign.abstractcomponents.abstractComponent;

public class Checkoutpage extends abstractComponent {

	WebDriver driver;

	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement countryfield;

	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement countryname;

	@FindBy(css = ".action__submit")
	WebElement placeOrderButton;

	By countrynamepopup = By.xpath("//button[contains(@class,'ta-item')][2]");

	public void selectCountry(String country) {

		Actions a = new Actions(driver);
		a.sendKeys(countryfield, country).build().perform();
		waitForElementToAppear(countrynamepopup);
		countryname.click();

	}

	public Orderconfimation placeTheOrder() {

		Actions a = new Actions(driver);
		a.moveToElement(placeOrderButton).click().build().perform();

		Orderconfimation orderconfirmation = new Orderconfimation(driver);
		return orderconfirmation;
		
	
		

	}
	
	public Orderconfimation placeonTheOrder() {

		Actions a = new Actions(driver);
		a.moveToElement(placeOrderButton).click().build().perform();

		Orderconfimation orderconfirmation = new Orderconfimation(driver);
		return orderconfirmation;
		
	
		

	}

}
