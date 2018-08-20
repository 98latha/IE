package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class VerificationPage 
{
	WebDriver driver;
	Actions a=new Actions(driver);
	public void verifyTitle(String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.titleContains(title));
			Reporter.log("title is matching",true);
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching",true);
			Assert.fail();
		}
	}
	public void mousehover(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
			a.moveToElement(ele).perform();
			Reporter.log("MouseHover action is performed",true);
		}
		catch(Exception e)
		{
			Reporter.log("MouseHoverAction is not performed",true);
		}
	}
	public void visibility(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
			Reporter.log("Element is present",true);
		}
	catch(Exception e)
	{
		Reporter.log("Element is not Present",true);
		Assert.fail();
	}
		
	}
	public VerificationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
}
