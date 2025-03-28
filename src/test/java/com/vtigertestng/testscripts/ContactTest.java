package com.vtigertestng.testscripts;


import com.vtiger.webdriver_java_listener_utility.VtigerBaseClass;
import com.vtiger.listenerutility.Vtiger_ListenerImpClass;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(com.vtiger.listenerutility.Vtiger_ListenerImpClass.class)
public class ContactTest extends VtigerBaseClass {
    public ContactTest() throws IOException {}

    @Test(groups = "smoke")
    public void createContact () {
        //test.log(Status.INFO,"");
        // click on contact major tab
        hp.getContactsMajorTab().click();
        // click on create new contact
        cp.getCreatenewcontactbtn().click();
        // enter a lastname
        String lastname = veu.getVtigerXlData("Sheet1",3,2)+ju.getRandomNum(555);
        cncp.getLastnametxtfld().sendKeys(lastname);
        // click on save btn
        cncp.getSaveBtn().click();
    }
    @Test(groups = "regression")
    public void createContactWithOrg () {
        // click on contact major tab
        hp.getContactsMajorTab().click();
        // click on create new contact
        cp.getCreatenewcontactbtn().click();
        // enter a lastname
        String lastname = veu.getVtigerXlData("Sheet1",3,2)+ju.getRandomNum(555);
        cncp.getLastnametxtfld().sendKeys(lastname);
        // save the parent window handle
        String parentHandle = driver.getWindowHandle();
        // click on plus btn next to industry txtfld
        cncp.getOrgPlusBtn().click();
        // switch to child window
        wdu.switchToChildWindow();
        // enter an org name in the search fld
        String porgname = veu.getVtigerXlData("Sheet1",3,2).toString();
        cncp.getOrgSrchTxtFld().sendKeys(porgname);
        // click on srch btn
        cncp.getSrchBtn().click();
        // Click on the previous orgname
        driver.findElement(By.linkText(porgname)).click();
        // switch to parent window
        wdu.switchToOriginalWindow(parentHandle);
        // click on save btn
        cncp.getSaveBtn().click();
        //Assert.fail();
    }
    @Test(groups = "smoke")
    public void createContactWithDate () {
        // click on contact major tab
        hp.getContactsMajorTab().click();
        // click on create new contact
        cp.getCreatenewcontactbtn().click();
        // enter a lastname
        String lastname = veu.getVtigerXlData("Sheet1",3,2)+ju.getRandomNum(555);
        cncp.getLastnametxtfld().sendKeys(lastname);
        // enter the start date
        cncp.getStartDateTxtFld().clear();
        cncp.getStartDateTxtFld().sendKeys(ju.getStartDate());
        // enter the end date
        cncp.getEndDateTxtFld().clear();
        cncp.getEndDateTxtFld().sendKeys(ju.getEndDate(36));
        //Assert.fail();
    }
}
