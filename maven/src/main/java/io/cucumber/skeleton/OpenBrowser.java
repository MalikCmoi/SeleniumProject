package io.cucumber.skeleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    private static WebDriver driver = null;
    private OpenBrowser(){
    }
    public static WebDriver getBroswser(){
        if(driver == null){
            driver = new ChromeDriver();
            driver.get("https://ztrain-web.vercel.app/home");
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void destroyBrowser(){
        driver.quit();
        driver = null;
    }
}
