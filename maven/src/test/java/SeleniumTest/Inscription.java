package SeleniumTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.skeleton.OpenBrowser;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Inscription {
    @Given("etre sur la page Ztrain et ne pas être connécté")
    public void InscriptionStepOne(){
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

    @When("User clique sur le bouton de connection sur le header")
    public void userCliqueSurLeBoutonDeConnectionSurLeHeader() throws InterruptedException {
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("style_avatar_wrapper__pEGIQ"));
        elem.click();
        Thread.sleep(300);
    }

    @And("User mets un bon mail")
    public void userMetsUnBonMail() {
        WebDriver driver = OpenBrowser.getBroswser();
        driver.findElements(By.className("MuiButtonBase-root")).get(1).click();
        WebElement elem = driver.findElement(By.id("email_register"));
        elem.sendKeys("test123456789@test.com");
    }

    @And("User mets un bon mots de passe de plus 8 caractère")
    public void userMetsUnBonMotsDePasseDePlus8Caractere() {
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("password_register"));
        elem.sendKeys("12345678");
    }

    @And("User mots un mots de passe de confirmation différent")
    public void userMotsUnMotsDePasseDeConfirmationDifferent() {
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("confirm_password_register"));
        elem.sendKeys("123456789");
    }

    @And("user click sur le boutton Inscription")
    public void userClickSurLeBouttonInscription() {
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = OpenBrowser.getBroswser();
        driver.findElement(By.id("btn_register")).click();
    }

    @And("User mets un mots de passe de confirmation identique au mdp")
    public void userMotsUnMotsDePasseDeConfirmationIdentiqueAuMdp() {
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("confirm_password_register"));
        elem.sendKeys("1234567");
    }

    @And("User mets un mots de passe de moins 8 caractère")
    public void userMetsUnBonMotsDePasseDeMoinsCaractere() {
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("password_register"));
        elem.sendKeys("1234567");
    }

    @Then("User est n'est pas inscrit mauvais mdp")
    public void userEstNEstPasInscrit() {
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = OpenBrowser.getBroswser();
        String error = driver.findElement(By.className("style_messageError__mbzDa")).getText();
        Assert.assertEquals(error,"Les deux mots de passe ne sont pas identiques");
        OpenBrowser.destroyBrowser();
    }


    @Then("User est n'est pas inscrit mdp petit")
    public void userEstNEstPasInscritMdpPetit() {
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = OpenBrowser.getBroswser();
        String error = driver.findElement(By.className("style_messageError__mbzDa")).getText();
        Assert.assertEquals(error,"Le mot de passe doit avoir au moins 8 caractères");
        OpenBrowser.destroyBrowser();
    }

    @And("User mets un bon mots de passe")
    public void userMetsUnBonMotsDePasse() {
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("password_register"));
        elem.sendKeys("12345678");
    }

    @And("User mets un mots de passe de confirmation identique au mdp 1")
    public void userMetsUnMotsDePasseDeConfirmationIdentiqueAuMdp() {
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("confirm_password_register"));
        elem.sendKeys("12345678");
    }

    @And("User mets un mauvais mail")
    public void userMetsUnMauvaisMail() {
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = OpenBrowser.getBroswser();
        WebElement elem = driver.findElement(By.id("email_register"));
        elem.sendKeys("test.com");
    }

    @Then("User est n'est pas inscrit mail")
    public void userEstNEstPasInscritMail() {
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebDriver driver = OpenBrowser.getBroswser();
        String error = driver.findElement(By.className("style_messageError__mbzDa")).getText();
        Assert.assertEquals(error,"Le format de l'email est invalid");
        OpenBrowser.destroyBrowser();
    }

    @Then("User est inscrit mail et connécté")
    public void userEstInscritMailEtConnecte() {
        WebDriver driver = OpenBrowser.getBroswser();
        if(driver.findElement(By.className("style_messageError__mbzDa")).getText().equals("Cet utilisateur existe déjà")){
            Allure.description("User Existe Déja");
        }
        try {
            Thread.sleep(300);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement elem = driver.findElement(By.id("style_avatar_wrapper__pEGIQ"));
        elem.click();

        assertEquals(driver.findElement(By.cssSelector(".ant-menu-item")).getText(), "test123456789@test.com");

        driver.findElement(By.id("simple-popover")).click();
    }
}
