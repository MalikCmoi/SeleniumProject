package SeleniumTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.skeleton.OpenBrowser;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Deconnexion {
    @Given("etre sur la page Ztrain, et être connécter a un compte")
    @Description("User est connécté à son compte")
    public void UserIsConnected(){
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("style_avatar_wrapper__pEGIQ"));
        elem.click();

        assertEquals(driver.findElement(By.cssSelector(".ant-menu-item")).getText(), "azerty123@azerty123.fr");
        driver.findElement(By.id("simple-popover")).click();
    }
    @When("User clique sur le bonton mail sur le header")
    public void ClickMailButton(){
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("style_avatar_wrapper__pEGIQ"));
        elem.click();
    }

    @And("User clque sur le bonton Se déconnectée")
    public void ClickDeconnexionButton(){
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("logout"));
        elem.click();
    }

    @Then("User est déconnécté")
    public void UserIsNotConnected(){
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("style_avatar_wrapper__pEGIQ"));
        elem.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("button.ant-modal-close")).click();
    }

}
