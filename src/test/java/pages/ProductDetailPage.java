package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductDetailPage {

    public ProductDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Ürün detaylarının (isim, kategori, fiyat vb.) tamamını barındıran ana kutuyu (container) temsil eder
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div")
    public WebElement containerProductInformation;
}