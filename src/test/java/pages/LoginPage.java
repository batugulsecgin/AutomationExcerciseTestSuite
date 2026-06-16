package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Login Feature elementleri
    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement txtLoginToYourAccount;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
    public WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
    public WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    public WebElement btnLogin;

    // YENİ EKLENEN: Register Feature için New User Signup elementleri
    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement txtNewUserSignup;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
    public WebElement inputSignupName;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    public WebElement inputSignupEmail;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    public WebElement btnSignup;
}