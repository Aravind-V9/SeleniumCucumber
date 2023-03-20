package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	Properties prop;
	
	@Before
	public void launchBrowser() throws IOException, InterruptedException
	{
		
		prop =new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//Resources//global.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("browser1");
			ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(option);
	     driver.manage().window().maximize();
		}
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}

}
