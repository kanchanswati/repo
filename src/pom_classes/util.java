package pom_classes;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class util 
{
	public static void moveToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).pause(2000).build().perform();
	}
	public static void movebyoffset(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(200, 0).release().build().perform();
	}
	public static boolean iselementVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}
	public static List<String> getmultipledatafromExcel(int firstrow,int lastrow) throws EncryptedDocumentException, IOException
	
	{
		FileInputStream file=new FileInputStream("C:\\Users\\swati\\Desktop\\Book1.xlsx");
		List<String> datalist=new ArrayList<>();
		org.apache.poi.ss.usermodel.Sheet sheet=WorkbookFactory.create(file).getSheet("Sheet2");
		for(int i=firstrow;i<=lastrow;i++)
		{
			try{
			String Stringdata=sheet.getRow(i).getCell(1).getStringCellValue();
			datalist.add(Stringdata);
		}catch(Exception e)
		{
			long intdata=(long) sheet.getRow(i).getCell(1).getNumericCellValue();
			String string=String.valueOf(intdata);
			datalist.add(string);
		}
		}
		return datalist;
		}
	}
	

