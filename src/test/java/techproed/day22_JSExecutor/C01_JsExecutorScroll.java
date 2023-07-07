package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_JsExecutorScroll extends TestBase {
    @Test
    public void test01() {

        /*
        Actions class'ındaki gibi js executor ile de sayfada scroll işlemi yapabiliriz. Bir webelementi locate edip
        o webelement görünür olana kadar scroll yapabiliriz
        "arguments[0].scrollIntoView(true);",Webelement --> Bu script kodu ile belirtmiş olduğumuz webelemente scroll
        yaparız
         */

        //Techpro education ana sayfasına git
        driver.get("https://www.techproeducation.com");
        bekle(2);
        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();  //Cikan reklami kapattik
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        bekle(1);
        screenshotFullPage();

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
        bekle(1);
        screenshotFullPage();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        js.executeScript("arguments[0].scrollIntoView(true);",whyUs);
        bekle(1);
        screenshotFullPage();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
        bekle(1);
        screenshotFullPage();

        //Sayfayı en alta scroll yapalım
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bekle(1);

        //Sayfayi en üste scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    @Test
    public void test02() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,1500)");     //--> x=0 y=1500 pixel olarak girdigimiz deger kadar scroll yapti.
    }

    @Test
    public void test03() {

        //TestBase deki methodlar ile scroll yapalim:

        //Techpro education ana sayfasına git
        driver.get("https://www.techproeducation.com");
        bekle(2);
        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();  //Cikan reklami kapattik
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));
        jsScrollWe(weOffer);
        bekle(1);
        screenshotFullPage();

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));
        jsScrollWe(enrollFree);
        bekle(1);
        screenshotFullPage();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        jsScrollWe(whyUs);
        bekle(1);
        screenshotFullPage();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        jsScrollWe(enrollFree);
        bekle(1);
        screenshotFullPage();

        //Sayfayı en alta scroll yapalım
        scrollEnd();
        bekle(1);

        //Sayfayi en üste scroll yapalım
        scrollHome();

    }
}
