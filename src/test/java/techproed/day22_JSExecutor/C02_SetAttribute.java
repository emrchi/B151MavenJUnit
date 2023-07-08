package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_SetAttribute extends TestBase {
    @Test
    public void test01() {
        //Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();  //Cikan reklami kapattik

        //Arama kutusuna QA yaz
         /*
    <input> tag'ina sahip webelementlere deger gonderirken sendKeys() methodu kullaniriz
    sendKeys() methodu ile deger gonderemedigimiz durumlarda js executor ile rahatlikla deger gonderebiliriz
    <input> taglarinda value attributu degeri arama kutusu icindeki veriyi temsil eder
        */
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'",aramaKutusu);    //Burada value attribut degerine QA atamasi yap dedik.
    }

    @Test
    public void test02() {
        //TestBase deki method ile yapalim
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@type='search']"));
        SendKeys("Java",aramaKutusu);
    }

    @Test
    public void test03() {

        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        /*
        JS executor ile bir attribute değer atayabiliriz.Aşağıdaki örnekteki gibi
        Sayfadaki arama kutusunu locate edip arama kutusunun value attributune 'QA' değerini atarız
         */
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);

    }

    @Test
    public void test04() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','emre')",aramaKutusu);    //burada id ye emre atadik
        driver.findElement(By.id("emre")).sendKeys("QA", Keys.ENTER);
    }

    @Test
    public void test05() {

        //TestBase de olusturdugumuz method ile cozelim
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        jsSetAttribute("value","QA",aramaKutusu);     //--> Method ile attribute degerini set ettik

    }
}
