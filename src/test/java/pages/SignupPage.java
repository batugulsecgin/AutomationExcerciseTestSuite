package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignupPage {

    public SignupPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"form\"]/div[1]/div/div/div/h2/b")
    public WebElement txtEnterAccountInformation;

    @FindBy(xpath = "//*[@id=\"id_gender1\"]")
    public WebElement radioTitleMr;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement inputPassword;

    // Select sınıfı ile kullanacağımız dropdown elementleri
    @FindBy(xpath = "//*[@id=\"days\"]")
    public WebElement dropdownDays;

    @FindBy(xpath = "//*[@id=\"months\"]")
    public WebElement dropdownMonths;

    @FindBy(xpath = "//*[@id=\"years\"]")
    public WebElement dropdownYears;

    @FindBy(xpath = "//*[@id=\"newsletter\"]")
    public WebElement checkboxNewsletter;

    @FindBy(xpath = "//*[@id=\"optin\"]")
    public WebElement checkboxOptin;

    @FindBy(xpath = "//*[@id=\"first_name\"]")
    public WebElement inputFirstName;

    @FindBy(xpath = "//*[@id=\"last_name\"]")
    public WebElement inputLastName;

    @FindBy(xpath = "//*[@id=\"company\"]")
    public WebElement inputCompany;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    public WebElement inputAddress;

    @FindBy(xpath = "//*[@id=\"country\"]")
    public WebElement dropdownCountry;

    @FindBy(xpath = "//*[@id=\"state\"]")
    public WebElement inputState;

    @FindBy(xpath = "//*[@id=\"city\"]")
    public WebElement inputCity;

    @FindBy(xpath = "//*[@id=\"zipcode\"]")
    public WebElement inputZipcode;

    @FindBy(xpath = "//*[@id=\"mobile_number\"]")
    public WebElement inputMobileNumber;

    @FindBy(xpath = "//*[@id=\"form\"]/div[1]/div/div/div/form/button")
    public WebElement btnCreateAccount;
}