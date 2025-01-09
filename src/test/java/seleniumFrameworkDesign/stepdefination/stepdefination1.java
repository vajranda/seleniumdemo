package seleniumFrameworkDesign.stepdefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AutomationseleniumFrameworkDesign.testcomponent.Basetest;
import automationseleniumframeworkdesign.pageobjects.Cartpage;
import automationseleniumframeworkdesign.pageobjects.Checkoutpage;
import automationseleniumframeworkdesign.pageobjects.Landingpage;
import automationseleniumframeworkdesign.pageobjects.Orderconfimation;
import automationseleniumframeworkdesign.pageobjects.Productcatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefination1 extends Basetest {

	public Landingpage lan;
	public Productcatalogue productcatalogue;
	public  Cartpage cartpage;
	public Orderconfimation orderconfirmation;

	
	@Given("I want to land on login page")
	public void I_want_to_land_on_login_page() throws IOException {
		
	 lan =	launchApplication();	
		
	}
	
  @Given("^I want to login with (.+) and (.+)$")
  public void login_to_website(String username, String password) {
	  
	   productcatalogue    =  lan.loginAction(username,password);
	    
  }
  

  @When("^add the (.+) to cart$")
  public void add_the_product_to_cart(String product)
  {
	  List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addToCart(product);
		
  }
	@When("^check out (.+)$")
    public void check_out_product(String product) {
		
		 cartpage = productcatalogue.cartBox();

		boolean match = cartpage.cartItemVerification(product);
		Assert.assertTrue(match);
		Checkoutpage checkoutpage = cartpage.checkOut();
		checkoutpage.selectCountry("Ind");

		 orderconfirmation = checkoutpage.placeTheOrder();
			
			
		}
	  
	
	@Then("{string} check this message after order placed succefully")
	public void check_this_message_after_order_placed_succefully(String msg) {
		
		
		String message = orderconfirmation.orderConfirmationmessage();
		Assert.assertTrue(message.equalsIgnoreCase(msg));
		
		driver.close();	
  
  }
	
	

	@Then("check the error message {string}")
	public void check_the_error_message(String string) {
		
		Assert.assertEquals(string, lan.loginErrorMessage());
		driver.close();
		
	}
	
}
	
	

