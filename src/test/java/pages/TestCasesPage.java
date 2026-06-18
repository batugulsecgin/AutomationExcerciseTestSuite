package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestCasesPage {

    public TestCasesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Doğrulama için senin yakaladığın XPath
    @FindBy(xpath = "//*[@id=\"form\"]/div/div[1]/div/h2/b")
    public WebElement txtTestCasesPageSign;
}