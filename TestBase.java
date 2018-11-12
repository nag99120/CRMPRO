package basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.fb.qa.utils.TestUtil;
import com.fb.qa.utils.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	 public static WebEventListener eventListner;
	 
	 
		  public TestBase() throws Exception {
			  try {
				  prop = new Properties();
				  FileInputStream ip = new FileInputStream("G:\\New folder\\pom\\src\\main\\java\\com\\"
				  		+ "fb\\qa\\config\\config.properties");
				  prop.load(ip);
			  }catch(FileNotFoundException e) {
			  e.printStackTrace();
			  
		  }catch(IOException e) {
			  e.printStackTrace();
		  }
		  }
	 public static void intialisation() throws Exception {
				  String browserName = prop.getProperty("browser");
				  if(browserName.equals("chrome")) {
					  System.setProperty("webdriver.chrome.driver","G:\\Drivers\\chromedriver.exe");
					  driver = new ChromeDriver();
				  }
				  else if(browserName.equals("FF")) {
					  System.setProperty("webdriver.gecko.driver","G:\\Drivers\\geckodriver.exe");
					  driver = new FirefoxDriver();
					  
				  }
				  e_driver= new EventFiringWebDriver(driver);
			 //Now create a object of eventlistner Handler to register it with EventFiringWebDriver
				  eventListner = new WebEventListener();
				  e_driver.register(eventListner);
				  driver = e_driver;
				  
				  
				  driver.manage().window().maximize();
				  driver.manage().deleteAllCookies();
				  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
				  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS); 
				  driver.get(prop.getProperty("url"));
				  
				  
			  }
			
			}
			  
		  


