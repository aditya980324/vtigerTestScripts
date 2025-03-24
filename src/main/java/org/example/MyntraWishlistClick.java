package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MyntraWishlistClick {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.myntra.com/apparel?f=Brand%3ANEXT%2CNautica%2CU.S.%20Polo%20Assn.%2CU.S.%20Polo%20Assn.%20Denim%20Co.%2CboohooMAN%3A%3ACategories%3AJeans%2CShirts%2CShorts%2CTrousers%2CTshirts%3A%3AGender%3Amen%2Cmen%20wome&rf=Discount%20Range%3A40.0_100.0_40.0%20TO%20100.0&sort=new");
        driver.manage().window().maximize();
        Actions act = new Actions(driver);
        WebElement ele= driver.findElement(By.xpath("//h1[.='Apparel']/../../following-sibling::div/div/div/div/following-sibling::div/section/ul/li/a/following-sibling::div/following-sibling::div[1]/span"));
        act.scrollToElement(ele);
        act.moveToElement(ele);
        driver.manage().timeouts();    
    }

}
