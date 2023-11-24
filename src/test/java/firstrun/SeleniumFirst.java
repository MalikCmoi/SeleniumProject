package firstrun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFirst {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
