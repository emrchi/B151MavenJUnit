package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_TumSayfaResmi extends TestBase {
    @Test
    public void test01() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım

        String tarih = new SimpleDateFormat("_hh.mm.ss.dd.MM.yyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot tss = (TakesScreenshot) driver;
        //FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));   --> birde Files class'i ile yapalim
        Files.write(Paths.get(dosyaYolu),tss.getScreenshotAs(OutputType.BYTES));
    }

    @Test
    public void test02() {

        //Birde TestBase class daki screenshotFullpage() methodu ile screenshot alalim

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım
        screenshotFullPage();
    }
}
