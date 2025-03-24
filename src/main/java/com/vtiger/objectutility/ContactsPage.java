package com.vtiger.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
    WebDriver driver;

    public ContactsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//a[text()='Contacts' and @class='hdrLink']")
    private WebElement contactlogo;

    @FindBy (xpath = "//img[@title='Create Contact...']")
    private WebElement createnewcontactbtn;

    public String getContactlogo() {
        return contactlogo.getText();
    }

    public WebElement getCreatenewcontactbtn() {
        return createnewcontactbtn;
    }

}
