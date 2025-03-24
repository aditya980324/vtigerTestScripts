package com.vtiger.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
    WebDriver driver;

    public OrganizationsPage (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy (xpath = "//a[text()='Organizations' and @class='hdrLink']")
    private WebElement organizationlogo;

    @FindBy (xpath = "//img[@title='Create Organization...']")
    private WebElement createneworgbtn;

    public WebElement getCreateneworgbtn() {
        return createneworgbtn;
    }

    public String getOrganizationlogo() {
        return organizationlogo.getText();
    }
}
