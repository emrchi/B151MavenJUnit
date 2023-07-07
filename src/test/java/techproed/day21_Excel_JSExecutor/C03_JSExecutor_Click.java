package techproed.day21_Excel_JSExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {

     /*
        Bir web sayfasinda bazi webelementler olusturulurken JAVASCRIPT kodlariyla olusturulmus olabilir.
    Bu webelementleri handle edebilmek icin JavaScriptExecutor arayuzunu kullanmamiz gerekir.
    Bir webelement JavaScript kodlari ile yazilmamis olsa da javaScriptExecutor ile o webelementi handle edebiliriz
    Normal bildigimiz methodlardan daha yavas calisacagi icin bildigimiz methodlar isimizi goruyorsa onlari kullaniriz
    <script> tagi ile olusturdugumuz webelementleri de js executor ile handle edebiliriz.
     */

    @Test
    public void test01() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        screenshotWebElement(sellLinki);

        //Sell linkine tıklayınız
        sellLinki.click();

           /*
           BU testte hata aldik cunku locate ettigimiz webelement'in onune uyari yazisi cikti.
        JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yapar çünkü kodlara direk ulaşıyor
        Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
        hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
           */

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        screenshotFullPage();
    }
    @Test
    public void test02()  {
        //js ile cozum

        //Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com");

        bekle(2);
        //Sell linkinin resmini alalim
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        screenshotWebElement(sellLinki);

        //Sell linkine js executor kullanarak tiklayiniz.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);    //[0] --> verilen index webelementin indexi

        //Başlığın sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        screenshotFullPage();
    }
    @Test
    public void test03() {
        //TestBase de yaptigimiz click() methodu ile

        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        bekle(2);
        screenshotWebElement(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        click(sellLinki);                      //-->Click methodu ile normal click yapmayı denedi fakat olmadı js excutor ile click yaptı

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        screenshotFullPage();
    }
}

