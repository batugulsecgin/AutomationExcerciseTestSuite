package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ContactUsPage;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class ContactUsSteps {

    HomePage homePage = new HomePage();
    ContactUsPage contactUsPage = new ContactUsPage();

    @When("Click on Contact Us button")
    public void click_on_contact_us_button() {
        // 1. İstenen butona tıklama adımını gerçekleştiriyoruz
        utilities.ReusableMethods.clickWithJS(homePage.btnContactUs);

        // 2. KESİN ÇÖZÜM: Reklamın araya girmesine fırsat bile vermeden,
        // doğrudan gitmemiz gereken sayfayı tarayıcıya zorla yüklüyoruz.
        utilities.Driver.getDriver().get("https://automationexercise.com/contact_us");
    }

    @Then("Verify GET IN TOUCH is visible")
    public void verify_get_in_touch_is_visible() {
        Assert.assertTrue(contactUsPage.txtGetInTouch.isDisplayed());
    }

    @When("Enter name, email, subject and message")
    public void enter_name_email_subject_and_message() {
        contactUsPage.inputName.sendKeys("John Doe");
        contactUsPage.inputEmail.sendKeys("test@test9987.com");
        contactUsPage.inputSubject.sendKeys("Test message.");
        contactUsPage.inputMessage.sendKeys("Test message.");
    }

    @And("Click Submit button")
    public void click_submit_button() {
        // 1. ADIM: Butonu reklamın altında kalmaktan kurtarmak için önce ekranda kaydırarak görünür yapıyoruz.
        ReusableMethods.scrollIntoViewJS(contactUsPage.btnSubmit);

        // 2. ADIM: Kaydırma işleminden sonra JS ile tıklıyoruz.
        ReusableMethods.clickWithJS(contactUsPage.btnSubmit);
    }

    @And("Click OK button on the alert")
    public void click_ok_button_on_the_alert() {
        // Sayfadaki reklamların ve formun işlenmesi saniyelik gecikmelere yol açabilir.
        // Bu yüzden Alert ekrana gelene kadar (maksimum 5 saniye) Explicit Wait ile bekletiyoruz.
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(utilities.Driver.getDriver(), java.time.Duration.ofSeconds(5));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent());

        // Alert'in çıktığından emin olduktan sonra geçiş yapıp Tamam (OK) butonuna basıyoruz.
        utilities.Driver.getDriver().switchTo().alert().accept();
    }

    @Then("Verify success message Success! Your details have been submitted successfully. is visible")
    public void verify_success_message_success_your_details_have_been_submitted_successfully_is_visible() {
        Assert.assertTrue(contactUsPage.txtSuccessMessage.isDisplayed());
    }

    @When("Click Home button and verify that landed to home page successfully")
    public void click_home_button_and_verify_that_landed_to_home_page_successfully() {
        // 1. İstenen butona tıklama adımını gerçekleştiriyoruz
        utilities.ReusableMethods.clickWithJS(contactUsPage.btnHome);

        // 2. KESİN ÇÖZÜM: Testin sonunda çıkabilecek reklamlara karşı zorla anasayfaya gidiyoruz.
        utilities.Driver.getDriver().get("https://automationexercise.com/");

        // 3. Anasayfaya dönüldüğünü doğruluyoruz
        Assert.assertEquals("https://automationexercise.com/", utilities.Driver.getDriver().getCurrentUrl());
    }
}