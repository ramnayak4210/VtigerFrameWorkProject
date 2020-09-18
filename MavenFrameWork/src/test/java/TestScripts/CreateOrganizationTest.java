package TestScripts;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Vtiger.GenericLib.BaseClass;
import com.Vtiger.objectRepository.CreateOrganizationPageElements;
import com.Vtiger.objectRepository.HomePageElements;
import com.Vtiger.objectRepository.OrganizationInfoPageElements;
import com.Vtiger.objectRepository.OrganizationPageElements;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException 
	{
		HomePageElements hp = PageFactory.initElements(driver, HomePageElements.class);
		OrganizationPageElements op = PageFactory.initElements(driver, OrganizationPageElements.class);
		CreateOrganizationPageElements cop = PageFactory.initElements(driver, CreateOrganizationPageElements.class);
		OrganizationInfoPageElements oip = PageFactory.initElements(driver, OrganizationInfoPageElements.class);
		
		hp.getOrganizations().click();
		op.getCreateOrganization().click();
		String orgName = data.getDataFromExcel("CreateOrganization", 2, 1);
		Random r = new Random();
		int num = r.nextInt(9999);
		orgName = orgName+num;
		cop.getOrganizationNameTb().sendKeys(orgName);
		cop.getSaveBtn().click();
		
		String actOrgMsg = oip.getSuccessMsg().getText();
		Assert.assertTrue(actOrgMsg.contains(data.getDataFromExcel("CreateOrganization", 2, 2)));
		
	}
}
