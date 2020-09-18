package com.Vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignsInfoPageElements {

	@FindBy(className="dvHeaderText")
	private WebElement SuccessMsg;
	
	public WebElement getSuccessMsg()
	{
		return SuccessMsg;
		
	}
}
