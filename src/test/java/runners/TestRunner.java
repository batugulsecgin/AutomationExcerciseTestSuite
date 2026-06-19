package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},

        //Kullanılabilir tag'ler:
        // @smoke, @register, @negative_login, @logout, @existing_email, @contact,
        // @testcases, @products, @search_product, @subscription, @cart_subscription
        // @add_to_cart
        tags = "@add_to_cart",
        dryRun = false
)
public class TestRunner {
    // Bu sınıfın içi boş kalmalıdır.
    // Sadece yukarıdaki anatosyanlar (ayarlar) sayesinde testleri tetikler.
}