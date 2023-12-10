package SeleniumTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.skeleton.OpenBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectionTest {
    private WebDriver driver;
    @Given("Ouvrir un page web et se rendre sur le site Ztrain")
    public void ouvrirPage(){
        /*driver.get("https://ztrain-web.vercel.app/");
        driver.manage().window().maximize();*/
        driver = OpenBrowser.getBroswser();
    }

    @When("user click sur button de connection")
    public void btnHomeClick(){
        driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
    }

    @And("User entre un bon login")
    public void enterGoodLogin(){
        driver.findElement(By.id("email_login")).sendKeys("azerty123@azerty123.fr");
    }

    @And("User entre un bon mots de passe")
    public void enterGoodPassword(){
        driver.findElement(By.id("password_login")).sendKeys("12345678");
    }

    @And("User entre un mauvais login")
    public void enterBadLogin(){
        driver.findElement(By.id("email_login")).sendKeys("azerty1234@azerty123.fr");
    }

    @And("User entre un mauvais mots de passe")
    public void enterBadPassword(){
        driver.findElement(By.id("password_login")).sendKeys("123456789");
    }

    @And("Appuis sur le boutton se connecté")
    public void btnConnectionClick(){
        driver.findElement(By.id("btn_login")).click();
    }

    @Then("User est connectée")
    public void isConnected(){
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement elem = driver.findElement(By.id("style_avatar_wrapper__pEGIQ"));
        elem.click();

        assertEquals(driver.findElement(By.cssSelector(".ant-menu-item")).getText(), "azerty123@azerty123.fr");

        driver.findElement(By.id("simple-popover")).click();
    }
    @Then("User n'est pas connectée")
    public void notConnected(){
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(driver.findElement(By.id("style_content_form__i3W8L")).findElement(By.cssSelector("p")).getText(),"Email ou mot de passe incorrect");
        OpenBrowser.destroyBrowser();
    }

}
