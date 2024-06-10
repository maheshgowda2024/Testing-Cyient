package cyient_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(id = "username")
	private WebElement txt_Username;
	
	@FindBy(id = "pass")
	private WebElement txt_Password;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	private WebElement btn_Submit;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement link_Register;
	
	public LoginPage (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername() {
		txt_Username.sendKeys("superadmin");
	}
	
	public void enterPassword() {
		txt_Password.sendKeys("Superadmin");
	}
	
	public void clickOnSubmitButton() {
		btn_Submit.click();
	}
	
	public void enterInvaliedUsername() {
		txt_Username.sendKeys("supeddddradmin");
	}
	
	public void enterInvaliedPassword() {
		txt_Password.sendKeys("gfjhjgj");
	}
	
	public void clickOnRegisterLink() {
		link_Register.click();
	}
	
	
//	public void enterLoginPageData() {
//		txt_Username.sendKeys("superadmin");
//		txt_Password.sendKeys("Superadmin");
//	}
}
