package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountStatusPage {

    public AccountStatusPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Account Created ve Account Deleted yazılarının xpath'leri birebir aynıdır
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement txtStatusMessage;

    // Her iki sayfada da çıkan Continue butonu
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    public WebElement btnContinue;
}