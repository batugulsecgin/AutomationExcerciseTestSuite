package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactUsPage {

    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[3]/div[1]/div/h2")
    public WebElement txtGetInTouch;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[1]/input")
    public WebElement inputName;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[2]/input")
    public WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[3]/input")
    public WebElement inputSubject;

    @FindBy(xpath = "//*[@id=\"message\"]")
    public WebElement inputMessage;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[6]/input")
    public WebElement btnSubmit;

    // Senin güncellediğin tam isabetli Success Message XPath'i
    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[3]/div[1]/div/div[2]")
    public WebElement txtSuccessMessage;

    // Senin güncellediğin tam isabetli Home Button XPath'i
    @FindBy(xpath = "//*[@id=\"form-section\"]/a/span")
    public WebElement btnHome;
}