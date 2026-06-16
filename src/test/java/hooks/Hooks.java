package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    /*
     * @Before notasyonu her Scenario'dan önce otomatik çalışır.
     * Dikkat: io.cucumber.java kütüphanesinden import edilmelidir!
     */
    @Before
    public void setUp() {
        // Şu an için test öncesi ekstra bir ayara ihtiyacımız yok.
        // İleride API token alma veya DB bağlantısı kurma gibi işlemler burada yapılabilir.
    }

    /*
     * @After notasyonu her Scenario'dan sonra otomatik çalışır.
     * Dikkat: io.cucumber.java kütüphanesinden import edilmelidir!
     */
    @After
    public void tearDown(Scenario scenario) {

        // Eğer senaryo BAŞARISIZ (Fail) olursa ekran görüntüsü al ve rapora ekle
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Hata_Ekrani");
        }

        // Testin sonucu ne olursa olsun (Pass/Fail) en sonunda tarayıcıyı kapat
        Driver.closeDriver();
    }
}