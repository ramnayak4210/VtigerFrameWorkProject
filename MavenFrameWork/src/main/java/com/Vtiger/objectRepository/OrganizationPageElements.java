package com.Vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationPageElements {

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrganization;
	
	public WebElement getCreateOrganization()
	{
		return CreateOrganization;
	}
}
