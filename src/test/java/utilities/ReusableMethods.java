package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ReusableMethods {

    // Selenium'un normal click() metodunun reklamlara takıldığı yerlerde bu metodu kullanacağız.
    // Bu metod UI katmanını ezip geçerek doğrudan HTML üzerinden tıklama yapar.
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    // İleride lazım olursa diye: Elementi ekranın ortasına kaydırma metodu
    public static void scrollIntoViewJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}