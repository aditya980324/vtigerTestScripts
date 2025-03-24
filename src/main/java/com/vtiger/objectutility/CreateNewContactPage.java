package com.vtiger.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
    WebDriver driver;
    public CreateNewContactPage (WebDriver driver)  {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//span[text()='Creating New Contact' ]")
    private WebElement createnewcontactlogo;

    @FindBy (name = "lastname")
    private WebElement lastnametxtfld;

    @FindBy (xpath = "//input[@accesskey='S']")
    private  WebElement saveBtn;

    @FindBy (xpath = "//span[contains(text(),'Contact Information')]")
    private WebElement createdcontactlogo;

    @FindBy (xpath = "//img[@title='Select']")
    private WebElement orgPlusBtn;

    @FindBy (xpath = "//input[@name='search_text']")
    private WebElement orgSrchTxtFld;

    @FindBy (name = "search")
    private WebElement srchBtn;

    @FindBy (name = "support_start_date")
    private WebElement startDateTxtFld;

    @FindBy (name = "support_end_date")
    private WebElement endDateTxtFld;

    public WebElement getEndDateTxtFld() {
        return endDateTxtFld;
    }

    public WebElement getStartDateTxtFld() {
        return startDateTxtFld;
    }

    public WebElement getSrchBtn() {
        return srchBtn;
    }

    public WebElement getOrgSrchTxtFld() {
        return orgSrchTxtFld;
    }

    public String getCreatenewcontactlogo() {
        return createnewcontactlogo.getText();
    }

    public WebElement getLastnametxtfld() {
        return lastnametxtfld;
    }

    public WebElement getSaveBtn() {
        return saveBtn;
    }

    public String getCreatedcontactlogo() {
        return createdcontactlogo.getText();
    }

    public WebElement getOrgPlusBtn() {
        return orgPlusBtn;
    }

}
