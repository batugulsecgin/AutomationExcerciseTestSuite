package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // "Login to your account" yazısını doğrulamak için bir xpath oluşturduk
    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement txtLoginToYourAccount;

    // 2) E-mail adress bar
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
    public WebElement inputEmail;

    // 3) Password bar
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
    public WebElement inputPassword;

    // 4) Login Button
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    public WebElement btnLogin;
}