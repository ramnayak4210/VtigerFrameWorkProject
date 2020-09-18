package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.GenericLib.BaseClass;
import com.Vtiger.objectRepository.CampaignsInfoPageElements;
import com.Vtiger.objectRepository.CampaignsPageElements;
import com.Vtiger.objectRepository.CreateCampaignsPageElements;
import com.Vtiger.objectRepository.HomePageElements;

public class CreateCampaignTest extends BaseClass {

	@Test
	public void CreateCampaign() throws EncryptedDocumentException, IOException 
	{
		HomePageElements hp = PageFactory.initElements(driver, HomePageElements.class);
		CampaignsPageElements cp = PageFactory.initElements(driver, CampaignsPageElements.class);
		CreateCampaignsPageElements ccp = PageFactory.initElements(driver, CreateCampaignsPageElements.class);
		CampaignsInfoPageElements cip = PageFactory.initElements(driver, CampaignsInfoPageElements.class);
		
	    hp.getMore();
	    hp.getCampaigns().click();
	    cp.getCreateCampaigns().click();
	    ccp.getCampaignNameTb().sendKeys(data.getDataFromExcel("Campaign", 2, 1));
	    ccp.getSaveBtn().click();
	    
	    String actCampMsg = cip.getSuccessMsg().getText();
	    Assert.assertTrue(actCampMsg.contains(data.getDataFromExcel("Campaign", 2, 2)));
		
	}
}
