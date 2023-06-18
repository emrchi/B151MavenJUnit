package techproed.Assigment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Exercise02 {

    //  ...Exercise2...
//  1-driver olusturalim
//  2-java class'imiza chromedriver.exe'yi tanitalim
//  3-driver'in tum ekrani kaplamasini saglayalim
//  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
//    söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
//  5-"sahibinden.com" adresine gidelim
//  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
//  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
//  8-Ardindan "gittigidiyor.com" adresine gidelim
//  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini
//    kontrol edelim
//  10-Bi onceki web sayfamiza geri donelim
//  11-sayfayi yenileyelim
//  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
//  13-En son adim olarak butun sayfalarimizi kapatmis olalim

    //  1-driver olusturalim
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        //  2-java class'imiza chromedriver.exe'yi tanitalim
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //  3-driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();
        //  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
        //  söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test01() {
        //  5-"sahibinden.com" adresine gidelim
        driver.get("https://www.sahibinden.com");
        driver.findElement(By.xpath("//*[@id='onetrust-close-btn-container']")).click();
        WebElement iframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@class='intermediate-element']")).click();

        //  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String title = driver.getTitle();
        System.out.println(title);
        String URL = driver.getCurrentUrl();
        System.out.println(URL);

        //  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(title.contains("Oto"));
        Assert.assertFalse(URL.contains("Oto"));


        //  8-Ardindan "gittigidiyor.com" adresine gidelim
        driver.get("https://www.hepsiburada.com");

        //  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini
        //    kontrol edelim
        Assert.assertTrue(driver.getTitle().contains("Sitesi"));

        //  10-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        //  11-sayfayi yenileyelim
        driver.navigate().refresh();

        //  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();
        driver.close();
    }

    @After
    public void tearDown() throws Exception {
        //  13-En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}
