package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_WebElementResmi extends TestBase {
    @Test
    public void test01() throws IOException {
        /*
     Bir webelementin resmini almak için önce Webelementi locate edip bir webelemente assing ederiz.
    ve bu webelementi direk getScreenShotAs() methodunu kullanarak resmini belirttimiz dosyaya kaydederiz.
        */

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);

        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //çıkan sonucun resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());           //alinan ss lari ustuste yazmasin diye tarih kullandik
        String dosyaYolu = "src/test/java/techproed/WebElementResmi/WeScreenShot" + tarih + ".png";    // dosya yolunu aldik
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test02() {

        //TestBase class'indan method ile yapalim birde

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        bekle(2);

        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //çıkan sonucun resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        screenshotWebElement(sonucYazisi);

    }
}
