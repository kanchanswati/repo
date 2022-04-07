package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
	WebDriver driver;
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	private WebElement password;
	

	@FindBy(xpath=("(//button[@type=\"submit\"])[2]"))
	private WebElement submit;
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void enterEmail()
	{
		emailId.sendKeys("swati.sonawale@gmail.com");
	}
	
	public void enterPassword()
	{
		password.sendKeys("swamisamartha");
	}
	public void clickSubmit() throws InterruptedException 
	{
		submit.click();
		Thread.sleep(2000);
	}
}
