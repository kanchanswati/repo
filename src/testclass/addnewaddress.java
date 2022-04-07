package testclass;

import static org.testng.Assert.fail;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import baseclass.Base_class;
import graphql.Assert;
import pom_classes.Homepage;
import pom_classes.Loginpage;
import pom_classes.profilepage;


public class addnewaddress {
	WebDriver driver;
	Loginpage lp;
	Homepage hp;
	profilepage pp;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeclass(String a)
	{
		driver=Base_class.getWebDriver(a);
	}
	@BeforeMethod
	public void beforemethod()
	{
		lp=new Loginpage(driver);
		hp=new Homepage(driver);
		pp=new profilepage(driver);
	}
	@Test
  public void verifyusercanlogin() throws InterruptedException
	{
		lp.enterEmail();
		lp.enterPassword();
		lp.clickSubmit();
		hp.hoverToMyprofilename();
		String txt=hp.getlogouttext();
		if(txt.equals("logout"))
		{
			System.out.println("test passeed");
		}
		else
		{
			System.out.println("test failed");
		}
	}
	@DataProvider(name="dataset")
	public String[][]dataToTest()
	{
		String[][]data= {{"ganesh","9321456789","411041","nanded city"},{"Atul","9766840506","411028","kv school"}};
		return data;
	}
	@Test(priority=1,dataProvider="dataset")
	public void verifyusercanaddnewaddress(String name, String mobnumber, String pincode, String locality) throws InterruptedException
	{
		hp.hoverToMyprofilename();
		hp.clickonmyprofiletext();
		pp.clickonnnewaddress();
		pp.clickonnnewaddress();
		List<String>datalist=new ArrayList<>();
		datalist.add(name);
		datalist.add(mobnumber);
		datalist.add(pincode);
		datalist.add(locality);
		pp.getDataForAddress(datalist);
	}
	@AfterMethod
	public void afterMethod() {
		
	}
	@AfterClass
	public void afterClass()
	{
		
	}

}
