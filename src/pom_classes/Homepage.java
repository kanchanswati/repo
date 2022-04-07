package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends util {
	WebDriver driver;
	@FindBy(xpath="(//div[@class=\"_28p97w\"])[1]")
	private WebElement profilename;
	
	@FindBy(xpath="(//div[@class=\"_3vhnxf\"])[1]")
	private WebElement myprofileText ;
	

	@FindBy(xpath=("//div[text()='Logout']"))
	private WebElement logouttext;
	
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
		this.driver=driver;
	}

	public void hoverToMyprofilename()
	{
		iselementVisible(driver,profilename);
		moveToElement(driver,profilename);
	}
	public void clickonmyprofiletext()
	{
		iselementVisible(driver,myprofileText);
		myprofileText.click();
	}
	public String getlogouttext()
	{
		return logouttext.getText();
	}
	public void movepointer() throws InterruptedException
	{
		movebyoffset(driver);
		Thread.sleep(2000);
	}
}
