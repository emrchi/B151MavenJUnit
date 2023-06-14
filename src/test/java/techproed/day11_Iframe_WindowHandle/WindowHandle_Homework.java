package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class WindowHandle_Homework extends TestBase {
        //    Yeni bir class olusturun: WindowHandle
        //    Amazon anasayfa adresine gidin.
        //    Sayfa’nin window handle degerini String bir degiskene atayin
        //    Sayfa title’nin “Amazon” icerdigini test edin
        //    Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        //    Sayfa title’nin “Techpro Education” icerdigini test edin
        //    Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        //    Sayfa title’nin “Walmart” icerdigini test edin
        //    Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin


    @Test
    public void test01() {
        //    Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com/");

        //    Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle = driver.getWindowHandle();

        //    Sayfa title’nin “Amazon” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //    Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");

        //    Sayfa title’nin “Techpro Education” icerdigini test edin
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        //    Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        //    Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        //    Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
