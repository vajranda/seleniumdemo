package automationseleniumframeworkdesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationseleniumframeworkdesign.abstractcomponents.abstractComponent;

public class Productcatalogue extends abstractComponent {
	WebDriver driver;

	public Productcatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div.col-lg-4")
	List<WebElement> productlist;

	@FindBy(css = ".ng-animating")
	WebElement DisappearElement;

	By productbylocator = By.cssSelector("div.col-lg-4");
	By cartproductlist = By.cssSelector("b");
	By cartproduct = By.cssSelector(".card-body button:last-of-type");
	By toastmessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productbylocator);

		return productlist;

	}

	public WebElement getProductByName(String productname) {

		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(cartproductlist).getText().equals(productname)).findFirst()
				.orElse(null);
		return prod;

	}

	public void addToCart(String productname) {
		WebElement prod = getProductByName(productname);
		prod.findElement(cartproduct).click();
		waitForElementToAppear(toastmessage);
		waitForElementToDisappear(DisappearElement);

	}

}
