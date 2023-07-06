package techproed.Assigments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Exersice01 {

    // ...Exercise1...
// Create a new class under Q1 create main method
// Set Path
// Create chrome driver
// Maximize the window
// Open google home page https://www.google.com/.
// On the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
// Navigate forward to amazon
// Refresh the page
// Close/Quit the browser
// And last step : print "all ok" on console
    /*Exercise1... Q1 altında yeni bir sınıf oluştur ana yöntemi oluştur
    Yolu Ayarla Krom sürücüsü oluştur Pencereyi büyüt Google ana sayfasını aç
     https:www.google.com. Aynı sınıfta, Amazon ana sayfasına gidin
     https:www.amazon.com Google'a geri gidin Amazon'a ilerleyin Sayfayı yenileyin
     Kapat Tarayıcıdan çıkın Ve son adım: konsolda "tamam" yazdırın
    */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() {
        driver.get("https://www.google.com/");
        bekle(1);
        driver.navigate().to("https://www.amazon.com/");
        bekle(1);
        driver.navigate().back();
        bekle(1);
        driver.navigate().forward();
        bekle(1);
        driver.navigate().refresh();
        bekle(1);
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
        System.out.println("All Ok");
    }
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
