package automationseleniumframeworkdesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationseleniumframeworkdesign.abstractcomponents.abstractComponent;

public class Orderconfimation extends abstractComponent {

	WebDriver driver;

	public Orderconfimation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	WebElement thankyoumessage;

	public String orderConfirmationmessage() {

		return  thankyoumessage.getText();
		

	}

}
