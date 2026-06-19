package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductsPage {

    public ProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
    public WebElement txtAllProducts;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
    public WebElement btnViewFirstProduct;

    // YENİ EKLENENLER: Search Product Senaryosu
    @FindBy(xpath = "//*[@id=\"search_product\"]")
    public WebElement inputSearchProduct;

    @FindBy(xpath = "//*[@id=\"submit_search\"]/i")
    public WebElement btnSubmitSearch;

    // (Senin listende yoktu) 7. adım için metin bazlı dinamik XPath
    @FindBy(xpath = "//h2[text()='Searched Products']")
    public WebElement txtSearchedProducts;

    // (Senin listende yoktu) 8. adım için sayfada çıkan "tüm" ürün kartlarını yakalayan Liste
    @FindBy(xpath = "//div[contains(@class, 'productinfo')]")
    public java.util.List<WebElement> listSearchedProducts;

    // YENİ EKLENENLER: Sepete Ekleme Senaryosu Elementleri

    // Hover (üzerine gelme) yapılacak olan ilk ve ikinci ürün resimleri
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/img")
    public WebElement imgFirstProduct;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/img")
    public WebElement imgSecondProduct;

    // Ürünlerin altındaki "Add to cart" butonları (Senin verdiğin XPath'ler)
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")
    public WebElement btnAddToCartFirst;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a")
    public WebElement btnAddToCartSecond;

    // Çıkan pop-up (Modal) içindeki butonlar
    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
    public WebElement btnContinueShopping;

    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
    public WebElement btnViewCartModal;
}