package AutomationseleniumFrameworkDesign.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AutomationseleniumFrameworkDesign.testcomponent.Basetest;
import automationseleniumframeworkdesign.pageobjects.Cartpage;
import automationseleniumframeworkdesign.pageobjects.Checkoutpage;
import automationseleniumframeworkdesign.pageobjects.Orderconfimation;
import automationseleniumframeworkdesign.pageobjects.Orderpage;
import automationseleniumframeworkdesign.pageobjects.Productcatalogue;

public class StandardAloneTest extends Basetest {
	public String productname = "IPHONE 13 PRO";

	@Test(dataProvider = "getData", groups = { "purchase" })
	public void submitOrderTest(HashMap<String, String> input) throws IOException {

		Productcatalogue productcatalogue = lan.loginAction(input.get("email"), input.get("password"));

		// inside Login page

		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addToCart(input.get("product"));
		
		Cartpage cartpage = productcatalogue.cartBox();

		boolean match = cartpage.cartItemVerification(input.get("product"));
		Assert.assertTrue(match);
		Checkoutpage checkoutpage = cartpage.checkOut();
		checkoutpage.selectCountry("Ind");

		Orderconfimation orderconfirmation = checkoutpage.placeTheOrder();
		String message = orderconfirmation.orderConfirmationmessage();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));

	}

	@Test(dependsOnMethods = { "submitOrderTest" })
	public void orderPageTest() {
		Productcatalogue productcatalogue = lan.loginAction("KK@GMAIL.COM", "Vajju@123");
		Orderpage orderpage = lan.goToOrders();
		orderpage.getNameFromOrderList(productname);
		Assert.assertTrue(orderpage.getNameFromOrderList(productname));

	}

	

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJasonData(System.getProperty("user.dir")
				+ "\\src\\test\\java\\AutomationseleniumFrameworkDesign\\data\\test.Json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

	/*
	 * @DataProvider public Object[][] getData() {
	 * 
	 * HashMap<String,String> map = new HashMap<String,String>() ; map.put("email",
	 * "oprahul@gmail.com"); map.put("password", "Vajju@123"); map.put("product",
	 * "IPHONE 13 PRO");
	 * 
	 * 
	 * HashMap<String,String> map1 = new HashMap<String,String>() ;
	 * map1.put("email", "KK@GMAIL.COM"); map1.put("password", "Vajju@123");
	 * map1.put("product", "QWERTY");
	 * 
	 * 
	 * return new Object[][] {{map},{map1}} ;
	 * 
	 * }
	 */

}
