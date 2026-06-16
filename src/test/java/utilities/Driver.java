package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();

                    // CHROME OPTİMİZASYON AYARLARI
                    ChromeOptions options = new ChromeOptions();

                    // 1. Sayfa yüklenme stratejisini değiştir (Resim ve reklamları beklemeden teste devam et)
                    options.setPageLoadStrategy(PageLoadStrategy.EAGER);

                    // 2. Chrome'un adres/şifre kaydetme pop-up'larını kapat
                    options.addArguments("--disable-autofill-keyboard-accessory-view");
                    options.addArguments("--disable-save-password-bubble");
                    options.addArguments("--disable-notifications");

                    // 3. Tarayıcıyı gizli sekmede (Incognito) aç (Geçmiş çerezlerin testi etkilememesi için)
                    options.addArguments("--incognito");

                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}