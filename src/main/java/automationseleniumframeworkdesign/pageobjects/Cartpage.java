package automationseleniumframeworkdesign.pageobjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationseleniumframeworkdesign.abstractcomponents.abstractComponent;

public class Cartpage extends abstractComponent {

	WebDriver driver;

	public Cartpage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.cartSection h3")
	List<WebElement> cartboxitem;

	@FindBy(css = "[class*='subtotal'] ul li button")
	WebElement checkoutfromcart;

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement countryfield;

	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement countryname;

	@FindBy(css = ".action__submit")
	WebElement placeOrderButton;

	@FindBy(css = ".hero-primary")
	WebElement thankyoumessage;

	By countrynamepopup = By.xpath("//button[contains(@class,'ta-item')][2]");

	public boolean cartItemVerification(String productname) {

		Boolean match = cartboxitem.stream().anyMatch(item -> item.getText().equals(productname));

		return match;
	}

	public Checkoutpage checkOut() {
		checkoutfromcart.click();

		Checkoutpage checkoutpage = new Checkoutpage(driver);
		return checkoutpage;
	}

}
