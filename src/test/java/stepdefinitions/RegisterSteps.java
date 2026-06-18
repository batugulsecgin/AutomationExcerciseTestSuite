package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AccountStatusPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class RegisterSteps {

    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();
    AccountStatusPage statusPage = new AccountStatusPage();
    HomePage homePage = new HomePage();

    @Then("Verify New User Signup! is visible")
    public void verify_new_user_signup_is_visible() {
        Assert.assertTrue(loginPage.txtNewUserSignup.isDisplayed());
    }

    @When("Enter name and email address")
    public void enter_name_and_email_address() {
        String dynamicEmail = "test" + System.currentTimeMillis() + "@testing4242.com";
        loginPage.inputSignupName.sendKeys("test user");
        loginPage.inputSignupEmail.sendKeys(dynamicEmail);
    }

    @And("Click Signup button")
    public void click_signup_button() {
        loginPage.btnSignup.click();
    }

    @Then("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verify_that_enter_account_information_is_visible() {
        Assert.assertTrue(signupPage.txtEnterAccountInformation.isDisplayed());
    }

    @When("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {
        signupPage.radioTitleMr.click();
        signupPage.inputPassword.sendKeys("helloWorld");

        new Select(signupPage.dropdownDays).selectByVisibleText("6");
        new Select(signupPage.dropdownMonths).selectByVisibleText("April");
        new Select(signupPage.dropdownYears).selectByVisibleText("2000");
    }

    @And("Select checkbox Sign up for our newsletter!")
    public void select_checkbox_sign_up_for_our_newsletter() {
        ReusableMethods.clickWithJS(signupPage.checkboxNewsletter);
    }

    @And("Select checkbox Receive special offers from our partners!")
    public void select_checkbox_receive_special_offers_from_our_partners() {
        ReusableMethods.clickWithJS(signupPage.checkboxOptin);
    }

    @And("Fill details: First name, Last name, Company, Address, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_country_state_city_zipcode_mobile_number() {
        signupPage.inputFirstName.sendKeys("James");
        signupPage.inputLastName.sendKeys("Hetfield");
        signupPage.inputCompany.sendKeys("Damage Inc");
        signupPage.inputAddress.sendKeys("Baker Street No:6");

        new Select(signupPage.dropdownCountry).selectByVisibleText("India");

        signupPage.inputState.sendKeys("delhi");
        signupPage.inputCity.sendKeys("new delhi");
        signupPage.inputZipcode.sendKeys("34349");
        signupPage.inputMobileNumber.sendKeys("12345678909");
    }

    @And("Click Create Account button")
    public void click_create_account_button() {
        ReusableMethods.clickWithJS(signupPage.btnCreateAccount);
    }

    @Then("Verify that ACCOUNT CREATED! is visible")
    public void verify_that_account_created_is_visible() {
        Assert.assertEquals("ACCOUNT CREATED!", statusPage.txtStatusMessage.getText());
    }

    @When("Click Continue button")
    public void click_continue_button() {
        ReusableMethods.clickWithJS(statusPage.btnContinue);

        // REKLAM BYPASS: Eğer tıklamadan sonra reklam çıkarsa anasayfaya zorla yönlendir
        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().get("https://automationexercise.com/");
        }
    }

    @When("Click Delete Account button")
    public void click_delete_account_button() {
        ReusableMethods.clickWithJS(homePage.btnDeleteAccount);

        // REKLAM BYPASS: Eğer tıklamadan sonra reklam çıkarsa hesap silme sayfasına zorla yönlendir
        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().get("https://automationexercise.com/delete_account");
        }
    }

    @Then("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verify_that_account_deleted_is_visible_and_click_continue_button() {
        Assert.assertEquals("ACCOUNT DELETED!", statusPage.txtStatusMessage.getText());
        ReusableMethods.clickWithJS(statusPage.btnContinue);

        // Testin en sonunda çıkabilecek reklamlara karşı önlem
        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().get("https://automationexercise.com/");
        }
    }

    // "Existing Username/Email" durumu için gereken adımlar
    @When("Enter name and already registered email address")
    public void enter_name_and_already_registered_email_address() {
        // Bu senaryoda dinamik değil, sistemde var olan statik mock e-postayı kullanıyoruz
        loginPage.inputSignupName.sendKeys("test user");
        loginPage.inputSignupEmail.sendKeys("test@test0908067.com");
    }

    @Then("Verify error Email Address already exist! is visible")
    public void verify_error_email_address_already_exist_is_visible() {
        // Hata mesajının ekranda belirdiğini doğruluyoruz
        Assert.assertTrue(loginPage.txtEmailAlreadyExistError.isDisplayed());
    }

}