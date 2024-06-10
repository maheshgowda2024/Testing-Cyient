package cyient_TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cyient_Base.BaseClass;
import cyient_PageObject.HomePage;
import cyient_PageObject.LoginPage;
import cyient_PageObject.RegisterPage;
import cyient_Utils.Utilities;

public class RegisterTest extends BaseClass{

	public RegisterTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
//		if (browserName.equals("chrome")) {
//			driver = new ChromeDriver();
//		}
//		else if(browserName.equals("fireFox")) {
//			driver = new FirefoxDriver();
//		}
//		else if(browserName.equals("edge")) {
//			driver = new EdgeDriver();
//		}
//		else if(browserName.equals("safari")) {
//			driver = new SafariDriver();
//		}
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//		driver.get("http://202.21.38.161/aftermarket/");
//		Thread.sleep(7000);
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnCustomerMasterData();
		Thread.sleep(2000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnRegisterLink();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void verifyTheRegisterPageWithMandatoryField() throws Exception {
		
//	    driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//		driver.get("http://202.21.38.161/aftermarket/");
//		Thread.sleep(7000);
//		driver.findElement(By.xpath("(//a[@class='card education'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
//		driver.findElement(By.id("firstname")).sendKeys("Mahesh");
//		driver.findElement(By.id("lastname")).sendKeys("Gowda");
//		driver.findElement(By.id("username")).sendKeys("demoTesting");
//		driver.findElement(By.id("password")).sendKeys("Login@123");
//		driver.findElement(By.id("confirmpassword")).sendKeys("Login@123");
//		driver.findElement(By.id("email")).sendKeys(Utilities.generateEmailWithTimeStamp());
//		driver.findElement(By.xpath("(//select[@aria-label='Default select example'])[1]")).click();
//		driver.findElement(By.xpath("//select[@class='form-select ng-valid ng-touched ng-dirty']")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Designation']")).sendKeys("Testing");
//		driver.findElement(By.xpath("//select[@class='form-select ng-untouched ng-pristine ng-valid']")).click();
//		driver.findElement(By.xpath("//select[@class='form-select ng-valid ng-dirty ng-touched']")).click();
//		driver.findElement(By.xpath("//button[normalize-space()='Submit Request']")).click();
		
		
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName();
		registerPage.enterLastName();
		registerPage.enterUserName();
		registerPage.enterPassword();
		registerPage.enterConfirmPassword();
		registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		Thread.sleep(2000);
		registerPage.selectProcessFromDropdown();
		Thread.sleep(2000);
		registerPage.enterDesignation();
		Thread.sleep(2000);
		registerPage.selectRoleFromDropdown();
		Thread.sleep(2000);
		registerPage.clickOnSubmitRequestButton();
		Thread.sleep(8000);
		if (driver.getCurrentUrl().equals("http://202.21.38.161/aftermarket/login")) {
			System.out.println("Sign Up successful!");
		} else {
			System.out.println("Signup failed!");
		}
//		@FindBy(xpath = "(//select[@aria-label='Default select example'])[1]")
//		WebElement dd_process;
//		@FindBy(xpath = "(//select[@class='form-select ng-untouched ng-pristine ng-valid']")
//		WebElement dd_role;
//		
//		public Register() {
//			PageFactory.initElements(driver, this);
//		}
//		
//		public void enterRegisterData() {
//			cm.selectDropdownOption(dd_process, "Customer Master Data");
//			cm.selectDropdownOption(dd_role, "EndUser");
		
	}
	
	@Test(priority = 2)
	public void withoutEnteringAnyInformation() throws InterruptedException {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//		driver.get("http://202.21.38.161/aftermarket/");
//		Thread.sleep(7000);
//		driver.findElement(By.xpath("(//a[@class='card education'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
//		driver.findElement(By.xpath("//button[normalize-space()='Submit Request']")).click();
		
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnSubmitRequestButton();
		if (driver.getCurrentUrl().equals("http://202.21.38.161/aftermarket/login")) {
			System.out.println("Sign Up successful!");
		} else {
			System.out.println("Enter all the mandatory field!");
		}
	}
}
