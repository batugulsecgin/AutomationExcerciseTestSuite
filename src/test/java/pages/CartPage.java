package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Sepetteki tüm ürün satırlarını bir Liste (List) olarak alıyoruz
    @FindBy(xpath = "//tr[contains(@id, 'product-')]")
    public List<WebElement> listCartProducts;

    // Fiyat, miktar ve toplam fiyat sütunları
    @FindBy(xpath = "//td[@class='cart_price']/p")
    public List<WebElement> listCartPrices;

    @FindBy(xpath = "//td[@class='cart_quantity']/button")
    public List<WebElement> listCartQuantities;

    @FindBy(xpath = "//td[@class='cart_total']/p")
    public List<WebElement> listCartTotals;
}