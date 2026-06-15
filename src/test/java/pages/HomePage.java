package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage() {
        // PageFactory, bu sınıftaki @FindBy notasyonlarını Driver ile ilişkilendirir
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // UI Elementleri (Locator'lar) buraya eklenecek
}