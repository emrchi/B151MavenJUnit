package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {

        /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gittikten sonra
        tekrar ilk actiginiz sayfaya dnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degiskene handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
         */

    @Test
    public void WindowHandle1() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String sayfa1 = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle, actualTitle);

        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String sayfa2 = driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String sayfa3 = driver.getWindowHandle();
        bekle(2);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(sayfa1);
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(sayfa2);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(sayfa3);
        bekle(2);
    }

    @Test
    public void WindowHandle2() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String sayfa1 = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle, actualTitle);

        //yeni Tab'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String sayfa2 = driver.getWindowHandle();

        //Yeni Tab'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String sayfa3 = driver.getWindowHandle();
        bekle(2);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(sayfa1);
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(sayfa2);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(sayfa3);
        bekle(2);
    }
}
