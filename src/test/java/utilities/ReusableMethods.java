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

    // YENİ EKLENEN: Sayfayı yukarıdan aşağıya doğru yavaşça (insan gibi) kaydırma metodu
    public static void scrollDownGradually() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // Sayfanın toplam yüksekliğini alıyoruz
        long scrollHeight = (long) js.executeScript("return document.body.scrollHeight");

        // 300 piksellik adımlarla sayfanın en altına kadar yavaşça kaydırıyoruz
        for (int i = 0; i < scrollHeight; i += 300) {
            js.executeScript("window.scrollTo(0, " + i + ")");
            try {
                Thread.sleep(100); // Gözle görülebilir bir kaydırma efekti için 100 milisaniye bekleme
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}