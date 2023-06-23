package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {
    /*
    SCREENSHOT
           Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
       driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
       getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
       oranın yolunu belirtiriz.
     */
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        /*
        -İlk olarak SS aldığımızda nereye kaydetmek istiyorsak oranın yolunu belirtelim
        -İkinci olarak TakesScreenShot arayüzünden obje oluştururuz
        -Üçüncü olarak FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
        dosya yolunu belirteceğiz
         */
        String dosyaYolu = "src/test/java/techproed/tumSayfaResmi/screenShot.png";
        TakesScreenshot tss = (TakesScreenshot) driver;
        FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }
    @Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        TakesScreenshot tss = (TakesScreenshot) driver;
        FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE),new File("ScreenShot/screenShot.png"));
    }

    @Test
    public void test03() throws IOException {
                /*
        Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
        String bir değişkene tarih formatı atayabiliriz.
                */
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        /*
        SimpleDateFormat'ı kullanarak yeni bir tarih formatı oluşturup bir String'e assing ederiz.
        Ve bunu dosya isminden önce belirtiriz.
         */
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());      //alinan ss lari ustuste yazmasin diye tarih kullandik
        String dosyaYolu = "src/test/java/techproed/tumSayfaResmi/screenShot" + tarih + ".jpeg";  // dosya yolunu aldik
        TakesScreenshot tss = (TakesScreenshot) driver;                                           //tss objemizi driver'imiza esitledik
        FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));             //FileUtils Clasimizdan driverimizin oldugu tss objemizden screenshot
                                                                                                  //alarak yeni dosya yolu ile gittigimiz file a copyaladik.
    }

    @Test
    public void test04() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot tss = (TakesScreenshot) driver;
        FileUtils.copyFile(tss.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
}
