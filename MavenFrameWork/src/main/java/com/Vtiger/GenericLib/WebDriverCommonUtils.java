package com.Vtiger.GenericLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebDriverCommonUtils {
 
	String mainBrowserSessionId;
	public void waitForElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void selectItemFromList(WebElement element, String itemToBeSelect)
	{
	  Select s = new Select(element);
	  s.selectByVisibleText(itemToBeSelect);
	}
	
	public boolean checkMultipleList(WebElement element)
	{
	   Select s = new Select(element);
	return s.isMultiple();
	}
	
	public void keepMouseOnElement(WebElement element)
	{
	    Actions act = new Actions(BaseClass.driver);
	    act.moveToElement(element).perform();
	}
	
	public void moveObjectAtRequiredPlace(WebElement source, WebElement target)
	{
	    Actions act = new Actions(BaseClass.driver);
	    act.dragAndDrop(source, target).perform();
	}
	
	public void acceptAlert()
	{
	   Alert alt = BaseClass.driver.switchTo().alert();	
	   alt.accept();
	}
	
	public void validateAlertMag(String expectedAlertText)
	{
	   Alert alt = BaseClass.driver.switchTo().alert();	
	   String actualAlertText = alt.getText();
	   
	   Assert.assertEquals(actualAlertText, expectedAlertText);
	   System.out.println("Alert Validation Pass....");
	}
	
	public void rejectAlert()
	{
	   Alert alt = BaseClass.driver.switchTo().alert();
	   alt.dismiss();
	}
	
	public void switchToNewWindow()
	{
		mainBrowserSessionId = BaseClass.driver.getWindowHandle();	
	   Set<String> allID = BaseClass.driver.getWindowHandles();
	   
	   for(String ID : allID)
	   {
		   if(!ID.equals(mainBrowserSessionId))
		   {
			   BaseClass.driver.switchTo().window(ID);
		   }
	   }
	}
	
	public void switchToMainId()
	{	
	  BaseClass.driver.switchTo().window(mainBrowserSessionId);
	}
	
	public void switchToRequiredFrame(WebElement element)
	{
	   BaseClass.driver.switchTo().frame(element);	
	}
	
	public void switchToDefaultScreen()
	{
	  BaseClass.driver.switchTo().defaultContent();	
	}
	
	public void fielUploadToApplication(String filePath) throws AWTException
	{
	  StringSelection path = new StringSelection(filePath);
	  Toolkit tool = Toolkit.getDefaultToolkit();
	  Clipboard clp = tool.getSystemClipboard();
	  clp.setContents(path, null);
	  Robot r = new Robot();
//	  Paste the path
	  r.keyPress(KeyEvent.VK_CONTROL);
	  r.keyPress(KeyEvent.VK_V);
	  
	  r.keyRelease(KeyEvent.VK_CONTROL);
	  r.keyRelease(KeyEvent.VK_V);
//	  click on enter
	  r.keyPress(KeyEvent.VK_ENTER);
	  r.keyRelease(KeyEvent.VK_ENTER);
			  
	}
}
