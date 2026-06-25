package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactUsPage {

    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // "GET IN TOUCH" yazısını kaçıncı div'de olursa olsun içindeki metinden bulur (Büyük/küçük harf duyarlılığına karşı iki durumu da ekledik)
    @FindBy(xpath = "//h2[contains(text(), 'GET IN TOUCH') or contains(text(), 'Get In Touch')]")
    public WebElement txtGetInTouch;

    // Site geliştiricilerinin otomasyon için koyduğu "data-qa" etiketlerini kullanıyoruz (Asla kırılmaz)
    @FindBy(xpath = "//*[@data-qa='name']")
    public WebElement inputName;

    @FindBy(xpath = "//*[@data-qa='email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//*[@data-qa='subject']")
    public WebElement inputSubject;

    @FindBy(xpath = "//*[@data-qa='message']")
    public WebElement inputMessage;

    @FindBy(xpath = "//*[@data-qa='submit-button']")
    public WebElement btnSubmit;

    // Başarı mesajını class isminden yakalıyoruz
    @FindBy(xpath = "//*[@class='status alert alert-success']")
    public WebElement txtSuccessMessage;

    // Home butonunu doğrudan Home kelimesinden yakalıyoruz
    @FindBy(xpath = "//span[contains(text(), 'Home')]/parent::a")
    public WebElement btnHome;
}