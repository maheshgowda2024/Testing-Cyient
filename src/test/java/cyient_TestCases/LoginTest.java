package cyient_TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cyient_Base.BaseClass;
import cyient_PageObject.HomePage;
import cyient_PageObject.LoginPage;

public class LoginTest extends BaseClass{
	
	public LoginTest() {
		super();
	}

	public WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		    driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
			HomePage homePage = new HomePage(driver);
			homePage.clickOnCustomerMasterData();
			Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() throws InterruptedException {
//	    driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//		driver.get("http://202.21.38.161/aftermarket/");
//		Thread.sleep(7000);
//		driver.findElement(By.xpath("(//a[@class='card education'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id("username")).sendKeys("superadmin");
//		Thread.sleep(2000);
//		driver.findElement(By.id("pass")).sendKeys("Superadmin");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
//		Thread.sleep(10000);
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername();
		loginPage.enterPassword();
//		loginPage.enterLoginPageData();
		loginPage.clickOnSubmitButton();
		Thread.sleep(8000);
		if (driver.getCurrentUrl().equals("http://202.21.38.161/aftermarket/admin/dashboard")) {
			System.out.println("login successful!");
		} else {
			System.out.println("login failed!");
		}
		
//		@DataProvider(name = "validCredentialsSupplier")
//		public Object [][] supplytestdata(){
			
//			Object[][] data = getTestDataFromExcel("Login");
//			return data;
//		}
//		Thread.sleep(5000);
//		driver.quit();
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//		driver.get("http://202.21.38.161/aftermarket/");
//		Thread.sleep(7000);
//		driver.findElement(By.xpath("(//a[@class='card education'])[1]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id("username")).sendKeys("supeddddradmin");
//		Thread.sleep(2000);
//		driver.findElement(By.id("pass")).sendKeys("Superfdfadmin");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
//		Thread.sleep(10000);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterInvaliedUsername();
		loginPage.enterInvaliedPassword();
		loginPage.clickOnSubmitButton();
		Thread.sleep(8000);
		if (driver.getCurrentUrl().equals("http://202.21.38.161/aftermarket/admin/dashboard")) {
			System.out.println("login successful!");
		} else {
			System.out.println("Username or password is incorrect");
		}
//		Thread.sleep(5000);
//		driver.quit();
	}
	
	@Test(priority = 3)
	public void verifyLoginWithNoCredentials() throws InterruptedException {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//		driver.get("http://202.21.38.161/aftermarket/");
//		Thread.sleep(7000);
//		driver.findElement(By.xpath("(//a[@class='card education'])[1]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnSubmitButton();
		Thread.sleep(8000);
		if (driver.getCurrentUrl().equals("http://202.21.38.161/aftermarket/admin/dashboard")) {
			System.out.println("login successful!");
		} else {
			System.out.println("Username or password is incorrect");
		}
//		Thread.sleep(5000);
//		driver.quit();
	}
}
