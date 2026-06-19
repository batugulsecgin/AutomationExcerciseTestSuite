package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.ProductsPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class CartSteps {

    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();

    @Then("Hover over first product and click Add to cart")
    public void hover_over_first_product_and_click_add_to_cart() {
        // Ekranın navigasyon barı altında kalmaması için önce ilk ürüne doğru kaydırıyoruz
        ReusableMethods.scrollIntoViewJS(productsPage.imgFirstProduct);

        // Fareyi ürün resminin üzerine getiriyoruz (Hover)
        ReusableMethods.hover(productsPage.imgFirstProduct);

        // Sepete Ekle butonuna JS ile tıklıyoruz (Hover efekti çok hassas olduğu için JS en garantisidir)
        ReusableMethods.clickWithJS(productsPage.btnAddToCartFirst);
    }

    @And("Click Continue Shopping button")
    public void click_continue_shopping_button() {
        // Modal animasyonunun tamamlanıp butonun tıklanabilir olmasını maks. 5 saniye bekliyoruz
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.btnContinueShopping));

        productsPage.btnContinueShopping.click();
    }

    @Then("Hover over second product and click Add to cart")
    public void hover_over_second_product_and_click_add_to_cart() {
        ReusableMethods.scrollIntoViewJS(productsPage.imgSecondProduct);
        ReusableMethods.hover(productsPage.imgSecondProduct);
        ReusableMethods.clickWithJS(productsPage.btnAddToCartSecond);
    }

    @And("Click View Cart button")
    public void click_view_cart_button() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.btnViewCartModal));

        productsPage.btnViewCartModal.click();
    }

    @Then("Verify both products are added to Cart")
    public void verify_both_products_are_added_to_cart() {
        // Sepetteki satır sayısının 2 olduğunu doğruluyoruz
        Assert.assertEquals(2, cartPage.listCartProducts.size());
    }

    @And("Verify their prices, quantity and total price")
    public void verify_their_prices_quantity_and_total_price() {
        // Sepetteki tüm ürünler için (listCartProducts.size() = 2) döngü kurup her bir bilginin göründüğünü doğruluyoruz
        for (int i = 0; i < cartPage.listCartProducts.size(); i++) {
            Assert.assertTrue(cartPage.listCartPrices.get(i).isDisplayed());
            Assert.assertTrue(cartPage.listCartQuantities.get(i).isDisplayed());
            Assert.assertTrue(cartPage.listCartTotals.get(i).isDisplayed());
        }
    }
}