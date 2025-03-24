package com.vtiger.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "user_name")
    private WebElement usernametxtfld;

    @FindBy(name = "user_password")
    private WebElement passwordtxtfld;

    @FindBy(id = "submitButton")
    private WebElement loginbtn;

    @FindBy(linkText = "vtiger")
    private WebElement loginpagelogo;

    public WebElement getUsernametxtfld() {
        return usernametxtfld;
    }

    public WebElement getPasswordtxtfld() {
        return passwordtxtfld;
    }

    public WebElement getLoginbtn() {
        return loginbtn;
    }

    public String getLoginpagelogo() {
        return loginpagelogo.getText();
    }

    public void loginAction (String username , String password) {
        usernametxtfld.sendKeys(username);
        passwordtxtfld.sendKeys(password);
        loginbtn.click();
    }
}
