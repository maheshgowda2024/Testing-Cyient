package cyient_Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {
	
	WebDriver driver;
	public Properties prop;
	
	public BaseClass() {
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\cyient_Config\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}
	public WebDriver initializeBrowserAndOpenApplication(String browserName) throws InterruptedException {
		
		if (browserName.equals("chrome")) { //case sensitive "equals" properly need to add
			driver = new ChromeDriver();
		}
		else if(browserName.equals("fireFox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) { //case sensitive "ignore case" not applicable
			driver = new SafariDriver();
		}
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		Thread.sleep(2000);
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		
		return driver;
	}

}
