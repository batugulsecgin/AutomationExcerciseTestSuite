package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Login Feature elementleri
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    public WebElement btnSignupLogin;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")
    public WebElement txtLoggedInUsername;

    // YENİ EKLENEN: Register Feature için Delete Account butonu
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    public WebElement btnDeleteAccount;

    // YENİ EKLENEN: Logout butonu
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    public WebElement btnLogout;

    // YENİ EKLENEN: Contact Us butonu
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")
    public WebElement btnContactUs;
}