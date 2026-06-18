package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;

public class LoginSteps {

    // İlgili sayfalardan nesnelerimizi üretiyoruz
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("Launch browser and navigate to url {string}")
    public void launch_browser_and_navigate_to_url(String url) {
        Driver.getDriver().get(url);
    }

    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        // Ana sayfanın URL'ini kontrol ederek doğru sayfada olduğumuzu "Verify" ediyoruz.
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/", actualUrl);
    }

    @When("Click on Signup_Login button")
    public void click_on_signup_login_button() {
        homePage.btnSignupLogin.click();
    }

    @Then("Verify Login to your account is visible")
    public void verify_login_to_your_account_is_visible() {
        // İlgili yazının ekranda görünüp görünmediğini "Verify" ediyoruz.
        Assert.assertTrue(loginPage.txtLoginToYourAccount.isDisplayed());
    }

    @When("Enter correct email address and password")
    public void enter_correct_email_address_and_password() {
        // Senin verdiğin mock verileri gönderiyoruz
        loginPage.inputEmail.sendKeys("test@test0908067.com");
        loginPage.inputPassword.sendKeys("password123");
    }

    @And("Click login button")
    public void click_login_button() {
        loginPage.btnLogin.click();
    }

    @Then("Verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        // Kullanıcı adının header kısmında göründüğünü "Verify" ediyoruz.
        Assert.assertTrue(homePage.txtLoggedInUsername.isDisplayed());
    }

    //"Negative Login" için gerekli olan adımlar
    @When("Enter incorrect email address and password")
    public void enter_incorrect_email_address_and_password() {
        // Belirlediğimiz mock (yanlış) şifreyi gönderiyoruz
        loginPage.inputEmail.sendKeys("test@test0908067.com");
        loginPage.inputPassword.sendKeys("wrongWord");
    }

    @Then("Verify error Your email or password is incorrect! is visible")
    public void verify_error_your_email_or_password_is_incorrect_is_visible() {
        // Hata mesajının ekranda göründüğünü Assert ile doğruluyoruz
        Assert.assertTrue(loginPage.txtErrorMessage.isDisplayed());
    }

    // "Logout" için gerekli olan adımlar
    @When("Click Logout button")
    public void click_logout_button() {
        // Olası reklam engellerini aşmak için JS Executor ile tıklıyoruz
        utilities.ReusableMethods.clickWithJS(homePage.btnLogout);
    }

    @Then("Verify that user is navigated to login page")
    public void verify_that_user_is_navigated_to_login_page() {
        // Çıkış yapıldığında bizi tekrar Login formuna atıp atmadığını,
        // daha önce elimizde olan txtLoginToYourAccount elementi üzerinden doğruluyoruz.
        Assert.assertTrue(loginPage.txtLoginToYourAccount.isDisplayed());

        // Ekstra bir güvenlik doğrulaması olarak URL'i de kontrol edebiliriz
        String expectedUrl = "https://automationexercise.com/login";
        Assert.assertEquals(expectedUrl, utilities.Driver.getDriver().getCurrentUrl());
    }
}