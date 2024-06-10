package cyient_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	//Objects
	@FindBy(xpath = "(//a[@class='card education'])[1]")
	private WebElement btn_CustomerMasterData;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickOnCustomerMasterData() {
		btn_CustomerMasterData.click();
	}
}
