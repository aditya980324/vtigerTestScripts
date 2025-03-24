package com.vtigertestng.testscripts;

import com.vtiger.webdriver_java_listener_utility.VtigerBaseClass;
import com.vtiger.listenerutility.Vtiger_ListenerImpClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(Vtiger_ListenerImpClass.class)
public class OrganizationTest extends VtigerBaseClass {
    public OrganizationTest() throws IOException {}
     @Test
     public void createOrg () throws IOException {
         // click on the organization major tab
         hp.getOrganizationsMajorTab().click();
         // click on the create new organization btn
         op.getCreateneworgbtn().click();
         // enter the organization name
         String orgname = veu.getVtigerXlData("Sheet1",1,2)+ju.getRandomNum(500);
         cnop.getOrgNameTxtFld().sendKeys(orgname);
         // click on save btn
         cnop.getSaveBtn().click();
     }
    @Test
    public void createOrgWithPhone() throws IOException {
        // click on the organization major tab
        hp.getOrganizationsMajorTab().click();
        // click on the create new organization btn
        op.getCreateneworgbtn().click();
        // enter the organization name
        String orgname = veu.getVtigerXlData("Sheet1",1,2)+ju.getRandomNum(500);
        cnop.getOrgNameTxtFld().sendKeys(orgname);
        // enter a phone number
        String phone = (veu.getVtigerXlData("Sheet1",3,3)+ju.getRandomNum(500)).toString();
        cnop.getPhoneTxtFld().sendKeys(phone);
        // click on save btn
        cnop.getSaveBtn().click();
        //Assert.fail();
    }
    @Test
    public void industryDrpDwn () {
        // click on the organization major tab
        hp.getOrganizationsMajorTab().click();
        // click on the create new organization btn
        op.getCreateneworgbtn().click();
        // verify industry is displayed
        //Assert.assertTrue(cnop.getIndustryDrpdwn().isDisplayed());
        // verify industry is enabled
        //Assert.assertTrue(cnop.getIndustryDrpdwn().isEnabled());
        // verify industry is getting selected
        Assert.assertTrue(cnop.getIndustryDrpdwn().isSelected());
        //Assert.fail();
    }
}
