package com.Vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadInFoPageElements {

	@FindBy(xpath="//span[contains(text(),'Lead Information')]")
	private WebElement successMsg;
	
	public WebElement getSuccessMsg()
	{
		return successMsg;
		
	}
	
}
