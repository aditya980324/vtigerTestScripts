package com.vtiger.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//a[contains(text(),'Home' )]")
    private WebElement homeLogo;

    @FindBy (linkText = "Organizations")
    private WebElement organizationsMajorTab;

    @FindBy (linkText = "Contacts")
    private WebElement contactsMajorTab;

    @FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
    private WebElement profileIcon;

    @FindBy (linkText = "Sign Out")
    private WebElement signOutBtn;

    public WebElement getOrganizationsMajorTab() {
        return organizationsMajorTab;
    }

    public WebElement getContactsMajorTab() {
        return contactsMajorTab;
    }

    public WebElement getProfileIcon() {
        return profileIcon;
    }

    public WebElement getSignOutBtn() {
        return signOutBtn;
    }

    public String getHomeLogo() {
        return homeLogo.getText();
    }
}
