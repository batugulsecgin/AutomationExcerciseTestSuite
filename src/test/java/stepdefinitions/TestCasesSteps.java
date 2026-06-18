package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.TestCasesPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestCasesSteps {

    HomePage homePage = new HomePage();
    TestCasesPage testCasesPage = new TestCasesPage();

    @When("Click on Test Cases button")
    public void click_on_test_cases_button() {
        // Reklam katmanına takılmamak için JS ile tıklıyoruz
        ReusableMethods.clickWithJS(homePage.btnTestCases);

        // REKLAM BYPASS: Tıklama sonrası tam sayfa reklam çıkarsa, hedef sayfaya zorla yönlendir
        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().get("https://automationexercise.com/test_cases");
        }
    }

    @Then("Verify user is navigated to test cases page successfully")
    public void verify_user_is_navigated_to_test_cases_page_successfully() {
        // Elementin görünürlüğünü doğruluyoruz
        Assert.assertTrue(testCasesPage.txtTestCasesPageSign.isDisplayed());

        // Ekstra güvenlik: URL'in gerçekten test_cases sayfası olduğunu doğruluyoruz
        Assert.assertEquals("https://automationexercise.com/test_cases", Driver.getDriver().getCurrentUrl());
    }
}