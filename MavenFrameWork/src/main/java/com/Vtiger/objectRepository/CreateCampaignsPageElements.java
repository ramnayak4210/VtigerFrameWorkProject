package com.Vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCampaignsPageElements {

	@FindBy(name="campaignname")
	private WebElement CampaignNameTb;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement SaveBtn;
	
	public WebElement getCampaignNameTb()
	{
		return CampaignNameTb;
		
	}
	public WebElement getSaveBtn()
	{
		return SaveBtn;
		
	}
}
