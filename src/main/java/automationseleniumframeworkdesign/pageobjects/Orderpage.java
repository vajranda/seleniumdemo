package automationseleniumframeworkdesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationseleniumframeworkdesign.abstractcomponents.abstractComponent;

public class Orderpage extends abstractComponent {
	 public WebDriver driver;

	public Orderpage(WebDriver driver) {
	     super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//tr/td[2]")
	List<WebElement> orderlistitem;
	
	
	public boolean getNameFromOrderList(String productname) {
		
	boolean Match=	orderlistitem.stream().anyMatch(item->item.getText().contains(productname));
	return Match;
		
		
	}
	
	
	
	
	
	
	
	
	
}
