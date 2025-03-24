package com.vtiger.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgPage {
    WebDriver driver;

    public CreateNewOrgPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//span[text()='Creating New Organization']")
    private WebElement createNewOrgLogo;

    @FindBy (xpath = "//input[@name='accountname']")
    private WebElement orgNameTxtFld;

    @FindBy (xpath = "//input[@accesskey='S']")
    private  WebElement saveBtn;

    @FindBy (name = "phone")
    private  WebElement phoneTxtFld;

    @FindBy (name = "industry")
    private  WebElement industryDrpdwn;

    public WebElement getIndustryDrpdwn() {
        return industryDrpdwn;
    }

    public WebElement getOrgNameTxtFld() {
        return orgNameTxtFld;
    }

    public WebElement getSaveBtn() {
        return saveBtn;
    }

    public String getCreateNewOrgLogo() {
        return createNewOrgLogo.getText();
    }

    public WebElement getPhoneTxtFld() {
        return phoneTxtFld;
    }
}
