package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import utilities.ReusableMethods;

public class SubscriptionSteps {

    HomePage homePage = new HomePage();

    @When("Scroll down to footer")
    public void scroll_down_to_footer() {
        // Doğrudan "SUBSCRIPTION" yazısının olduğu footer alanına kaydırıyoruz
        ReusableMethods.scrollIntoViewJS(homePage.txtSubscription);
    }

    @Then("Verify text SUBSCRIPTION")
    public void verify_text_subscription() {
        // Kaydırma sonrası elementin görünürlüğünü doğruluyoruz
        Assert.assertTrue(homePage.txtSubscription.isDisplayed());
    }

    @When("Enter email address in input and click arrow button")
    public void enter_email_address_in_input_and_click_arrow_button() {
        // Senin belirlediğin mock e-posta adresini gönderiyoruz
        homePage.inputSubscribeEmail.sendKeys("testing@tesmail.com");

        // Olası tıklama engellerine (sayfa altı reklamları vb.) karşı JS ile tıklıyoruz
        ReusableMethods.clickWithJS(homePage.btnSubscribe);
    }

    @Then("Verify success message You have been successfully subscribed! is visible")
    public void verify_success_message_you_have_been_successfully_subscribed_is_visible() {
        // Başarı mesajının ekrana geldiğini doğruluyoruz
        Assert.assertTrue(homePage.txtSuccessSubscribe.isDisplayed());
    }
}