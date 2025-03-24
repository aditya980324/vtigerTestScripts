package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Myntra_Json {
    public static void main(String[] args) throws FileNotFoundException {
        String json_file_path = "C:\\Users\\satyam goswami\\OneDrive\\Documents\\myntra_credential.json";

        // Parse JSON file
        JsonObject map = JsonParser.parseReader(new FileReader(json_file_path)).getAsJsonObject();

        // Extract values
        String url = map.get("url").getAsString(); // Use .getAsString() instead of String.valueOf()
        String browser = map.get("browser").getAsString();

        WebDriver driver;

//        FileReader fis = new FileReader(json_file_path);
//        JsonParser parser=new JsonParser();
//        Object obj =parser.parseReader(fis);
//        JsonObject map =(JsonObject)obj;
//        String url = map.get("url").toString();
//        String browser = map.get("browser").toString();

        // Browser selection
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Invalid browser name in JSON file");
            return;
        }

        // Launch URL
        driver.get(url);

        // Close browser
        driver.quit();
    }
}
