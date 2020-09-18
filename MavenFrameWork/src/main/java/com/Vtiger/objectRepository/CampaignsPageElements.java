package com.Vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignsPageElements {

	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement CreateCampaigns;
	
	public WebElement getCreateCampaigns()
	{
		return CreateCampaigns;
		
	}
}
