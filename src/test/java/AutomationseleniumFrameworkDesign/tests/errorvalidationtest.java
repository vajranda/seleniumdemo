package AutomationseleniumFrameworkDesign.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationseleniumFrameworkDesign.testcomponent.Basetest;
import AutomationseleniumFrameworkDesign.testcomponent.Retry;
import automationseleniumframeworkdesign.pageobjects.Cartpage;
import automationseleniumframeworkdesign.pageobjects.Productcatalogue;

public class errorvalidationtest extends Basetest {

	@Test(groups = {"errortest"}, retryAnalyzer = Retry.class)
	public void loginTest() throws IOException {


		Productcatalogue productcatalogue = lan.loginAction("ninja121@gmail.com", "jju@123");
		Assert.assertEquals("Incorrect email or password.", lan.loginErrorMessage());

	}

	@Test
	public void cartItemCheck() {

		String productname = "IPHONE 13 PRO";

		Productcatalogue productcatalogue = lan.loginAction("oprahul@gmail.com", "Vajju@123");

		// inside Login page

		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addToCart(productname);
		Cartpage cartpage = productcatalogue.cartBox();

		boolean match = cartpage.cartItemVerification("samsung");
		Assert.assertFalse(match);
	}

}
