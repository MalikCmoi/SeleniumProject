package firstrun;

import dev.failsafe.Execution;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SeleniumFirst {
    public static void main(String[] args){
        System.out.println("Hello, World!");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ztrain-web.vercel.app/home");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        connect(driver);
        getCategory(driver);
        goAccountPage(driver);
    }

    private static Boolean connect(WebDriver driver){
        String login = "azerty123@azerty123.fr";
        String mdp = "12345678";
        Boolean isConnected = false;
        WebElement btnConnect = driver.findElement(By.id("style_avatar_wrapper__pEGIQ"));

        try{
            btnConnect.findElements(By.cssSelector("p")).get(0);
            isConnected = true;
            System.out.println("un compte est déja connecter");
            return isConnected;
        }catch (Exception e){
        }

        try {
            btnConnect.click();
            Thread.sleep(2000);
        }catch (ElementNotInteractableException e){
            System.out.println("Element non cliquable");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement inputLogin = driver.findElement(By.id("email_login"));
            WebElement inputPassWord = driver.findElement(By.id("password_login"));
            inputLogin.sendKeys(login);
            inputPassWord.sendKeys(mdp);
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Imposible d'écrire ses identifient.");
        }

        WebElement btnLogin = driver.findElement(By.id("btn_login"));
        btnLogin.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try{
            btnConnect.findElements(By.cssSelector("p")).get(0);
            isConnected = true;
            System.out.println("Compte connecté avec succée");
        }catch (Exception e){
        }
        System.out.println(verifyAccount(driver, login));
        return isConnected;
    }

    private static boolean verifyAccount(WebDriver driver, String email){

        try{
            return driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).findElements(By.cssSelector("p")).get(0).getText().equals(email);
        }catch (Exception e){
            System.out.println("Impossible d'accédée au compte vous n'êtes pas connecter!");
            return false;
        }

    }

    private static String getCategory(WebDriver driver){
        List<WebElement> categorys = driver.findElement(By.id("style_select_cat__vyiIE")).findElements(By.cssSelector("option"));
        String res = "";
        for (WebElement category: categorys) {
            res = res + " : " + category.getText();
            System.out.println(category.getText());
        }
        return res;
    }

    private  static void goAccountPage(WebDriver driver){
        driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
        driver.findElement(By.cssSelector(".MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiPopover-paper.css-1dmzujt")).findElements(By.cssSelector("li")).get(2).click();
    }
}
