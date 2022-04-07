package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_class {
	
	public static WebDriver getWebDriver(String s)
	{
		if(s.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","F:\\\\11th dec batchA\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		return driver;
	}
		else
		{
	
		System.setProperty("webdriver.gecko.driver","F:\\11th dec batchA\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		return driver;
	}
	//hello
	}

	
}
