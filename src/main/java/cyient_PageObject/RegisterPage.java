package cyient_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cyient_Utils.Utilities;

public class RegisterPage {
	public Utilities UT = new Utilities();
	WebDriver driver;
	
	@FindBy(id = "firstname")
	private WebElement txt_FirstName;
	
	@FindBy(id = "lastname")
	private WebElement txt_LastName;
	
	@FindBy(id = "username")
	private WebElement txt_UserName;
	
	@FindBy(id = "password")
	private WebElement txt_Password;
	
	@FindBy(id = "confirmpassword")
	private WebElement txt_ConfirmPassword;
	
	@FindBy(id = "email")
	private WebElement txt_Email;
	
	@FindBy(xpath = "(//select[@aria-label='Default select example'])[1]")
	private WebElement dd_Process;
	
	@FindBy(xpath = "//input[@placeholder='Designation']")
	private WebElement txt_Designation;
	
	@FindBy(xpath = "//select[@class='form-select ng-untouched ng-pristine ng-valid']")
	private WebElement dd_Role;
	
	@FindBy(xpath = "//button[normalize-space()='Submit Request']")
	private WebElement btn_SubmitRequest;
	
	public RegisterPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName() {
		txt_FirstName.sendKeys("Mahesh");
	}
	
	public void enterLastName() {
		txt_LastName.sendKeys("Gowda");
	}
	
	public void enterUserName() {
		txt_UserName.sendKeys("TestingTeam");
	}
	
	public void enterPassword() {
		txt_Password.sendKeys("Login@123");
	}
	
	public void enterConfirmPassword() {
		txt_ConfirmPassword.sendKeys("Login@123");
	}
	
	public void enterEmail(String emailText) {
		txt_Email.sendKeys(emailText);
	}
	
	public void selectProcessFromDropdown() throws Exception {
		UT.selectDropdownOption(dd_Process, "Customer Master Data");
	}
		
	public void enterDesignation() {
		txt_Designation.sendKeys("Testing");
	}
	
	public void selectRoleFromDropdown() throws Exception {
		UT.selectDropdownOption(dd_Role, "EndUser");
	}
	
	public void clickOnSubmitRequestButton() {
		btn_SubmitRequest.click();
	}
	
}
