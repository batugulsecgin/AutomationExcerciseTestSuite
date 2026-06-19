package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class ProductsSteps {

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();

    @When("Click on Products button")
    public void click_on_products_button() {
        ReusableMethods.clickWithJS(homePage.btnProducts);

        // REKLAM BYPASS: Products butonuna tıklayınca reklam çıkarsa zorla sayfaya git
        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().get("https://automationexercise.com/products");
        }
    }

    @Then("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_user_is_navigated_to_all_products_page_successfully() {
        Assert.assertTrue(productsPage.txtAllProducts.isDisplayed());
        Assert.assertEquals("https://automationexercise.com/products", Driver.getDriver().getCurrentUrl());
    }

    @When("Click on View Product of first product")
    public void click_on_view_product_of_first_product() {
        // Element aşağılarda kalabileceği için kaydırıp sonra tıklıyoruz
        ReusableMethods.scrollIntoViewJS(productsPage.btnViewFirstProduct);
        ReusableMethods.clickWithJS(productsPage.btnViewFirstProduct);

        // REKLAM BYPASS: İlk ürünün detaylarına giderken reklam çıkarsa zorla yönlendir
        if (Driver.getDriver().getCurrentUrl().contains("google_vignette")) {
            Driver.getDriver().get("https://automationexercise.com/product_details/1");
        }
    }

    @Then("User is landed to product detail page")
    public void user_is_landed_to_product_detail_page() {
        // 1 numaralı ürünün sayfasına gidip gitmediğimizi URL ile doğruluyoruz
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("product_details"));
    }

    @And("Verify that details are visible: product name, category, price, availability, condition, brand")
    public void verify_that_details_are_visible_product_name_category_price_availability_condition_brand() {
        // Tüm bu bilgileri barındıran HTML bloğunun (container) ekranda göründüğünü doğruluyoruz
        Assert.assertTrue(productDetailPage.containerProductInformation.isDisplayed());
    }

    @When("Enter product name in search input and click search button")
    public void enter_product_name_in_search_input_and_click_search_button() {
        // Senin belirlediğin mock (örnek) veriyi gönderiyoruz
        productsPage.inputSearchProduct.sendKeys("top");

        // Arama butonuna reklama takılmamak için JS ile tıklıyoruz
        ReusableMethods.clickWithJS(productsPage.btnSubmitSearch);
    }

    @Then("Verify SEARCHED PRODUCTS is visible")
    public void verify_searched_products_is_visible() {
        // Arama sonucunda başlığın değiştiğini doğruluyoruz
        Assert.assertTrue(productsPage.txtSearchedProducts.isDisplayed());
    }

    @And("Verify all the products related to search are visible")
    public void verify_all_the_products_related_to_search_are_visible() {
        // 1. İSTEĞİN ÜZERİNE: Sayfayı yukarıdan aşağıya yavaşça scroll yapıyoruz
        ReusableMethods.scrollDownGradually();

        // 2. KOD SEVİYESİNDE DOĞRULAMA: Sadece kaydırmakla kalmıyor,
        // arama sonucu dönen tüm ürün kartlarının (listSearchedProducts) ekranda göründüğünü tek tek Assert ediyoruz.
        for (org.openqa.selenium.WebElement product : productsPage.listSearchedProducts) {
            Assert.assertTrue(product.isDisplayed());
        }
    }
}