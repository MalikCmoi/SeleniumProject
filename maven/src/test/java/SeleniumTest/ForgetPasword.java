package SeleniumTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.skeleton.OpenBrowser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForgetPasword {

    WebDriver driver = OpenBrowser.getBroswser();

    @Given("etre sur la page Ztrain et ne pas être connécté forget password")
    public void InscriptionStepOne(){
        WebElement elem = driver.findElement(By.id("style_avatar_wrapper__pEGIQ"));
        elem.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("button.ant-modal-close")).click();
    }
    @And("User Click sur le lien Mot de passe oublié")
    public void userClickSurLeLienMotDePasseOublie() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.className("style_forgotpass__JmLID")).click();
        Thread.sleep(2000);
    }


    @And("User mets un mail invalide dans la page mots de passe oublié")
    public void userMetsUnMauvaisMotsDePasseDansLaPageMotsDePasseOublie() {
        driver.findElement(By.id("email_reset_pass")).sendKeys("mailinvalide");
    }

    @And("User mets un mots de passe valide dans la page mots de passe oublié")
    public void userMetsUnMotsDePasseValideDansLaPageMotsDePasseOublie() {
        driver.findElement(By.id("reset_password")).sendKeys("12345678");
    }

    @And("User click sur le boutton Réinitialiser")
    public void userClickSurLeBouttonReinitialiser() {
        driver.findElement(By.id("btn_reset_password")).click();
    }

    @And("User mets un mail non enregister dans la page mots de passe oublié")
    public void userMetsUnMailNonEnregisterDansLaPageMotsDePasseOublie() {
        driver.findElement(By.id("email_reset_pass")).sendKeys("qpfojufopa@azpfkapzf.fr");
    }
    @Then("le mots de pass n'est pas modifié message d'erreur: {string}")
    public void leMotsDePassNEstPasModifieMessageDErreurLeFormatDeLEmailEstInvalid(String messageError) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("style_messageError__LxTAG")).getText(),messageError);
        driver.get("https://ztrain-web.vercel.app/home");
    }

    @And("User mets un mail enregister dans la page mots de passe oublié")
    public void userMetsUnMailEnregisterDansLaPageMotsDePasseOublie() {
        driver.findElement(By.id("email_reset_pass")).sendKeys("azerty123@azerty123.fr");

    }

    @And("User mets un mots de passe non valide dans la page mots de passe oublié")
    public void userMetsUnMotsDePasseNonValideDansLaPageMotsDePasseOublie() {
        driver.findElement(By.id("reset_password")).sendKeys("123456");
    }

    @Then("le mots de passe est modifié et on peux se connéctée")
    public void leMotsDePasseEstModifieEtOnPeuxSeConnectee() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("style_container__P9Oh0"));
        driver.get("https://ztrain-web.vercel.app/home");
        WebElement elem = driver.findElement(By.id("style_avatar_wrapper__pEGIQ"));
        elem.click();
        Thread.sleep(300);
        driver.findElement(By.id("email_login")).sendKeys("azerty123@azerty123.fr");
        driver.findElement(By.id("password_login")).sendKeys("12345678");
        driver.findElement(By.id("btn_login")).click();

        Thread.sleep(2000);

        elem = driver.findElement(By.id("style_avatar_wrapper__pEGIQ"));
        elem.click();

        assertEquals(driver.findElement(By.cssSelector(".ant-menu-item")).getText(), "azerty123@azerty123.fr");

        driver.findElement(By.id("simple-popover")).click();
    }
}