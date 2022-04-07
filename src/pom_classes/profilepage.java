package pom_classes;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pom_classes.util;

public class profilepage extends util {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[2]/div[2]/div[1]/div[2]/a[2]/div")
	private WebElement manageaddress;
	
	@FindBy(xpath="//div[text()='ADD A NEW ADDRESS']")
	private WebElement addnewaddresstext;
	
	public profilepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
public void manageAddress()
{
	iselementVisible(driver,manageaddress);
	manageaddress.click();
}
public void clickonnnewaddress()

{
	iselementVisible(driver,addnewaddresstext);
	addnewaddresstext.click();
}

public void getDataForAddress(List<String> datalist) {
	// TODO Auto-generated method stubList<String> list=getmultipledatafromExcel(0,3);
	for(int i=1;i<=4;i++)
	{
		WebElement element=driver.findElement(By.xpath("((//form)[2]//input)["+i+"]"));
		element.sendKeys(datalist.get(i-1));
	}

	
}

	


}
