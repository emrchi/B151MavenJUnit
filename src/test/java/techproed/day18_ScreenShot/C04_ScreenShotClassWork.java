package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C04_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        String techProHandle = driver.getWindowHandle();
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //sayfanın resmini alalım
        screenshotFullPage();

        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//*[@class='elementor-search-form__input']")).sendKeys("Java", Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisiJava = driver.findElement(By.xpath("//h1"));
        screenshotWebElement(sonucYazisiJava);
        bekle(2);

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //sayfanın resmini alalım
        screenshotFullPage();
        bekle(2);

        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisiIphone = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        screenshotWebElement(sonucYazisiIphone);
        bekle(2);

        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        driver.switchTo().window(techProHandle);

    }
}
