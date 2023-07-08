package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_GetAttribute extends TestBase {
    @Test
    public void test01() {
        //  https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        //  Tarih kısmını JS ile locate ediniz.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement tarih = (WebElement) js.executeScript("return document.getElementById('checkin_date')");
        //WebElement tarih = (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");
        bekle(2);
        /*
            Java Script kodlariyla webelementleri bizim bildigimiz findElement() methoduyla locate edemeyebiliriz.
            js executer kullanarak ister HTML ister Java script yazilmis olsun bir webelementin locate'ini js executer ile
            alabiliriz. Yukaridaki ornekte sayfadaki tarih webelementini js executer ile locate ettik
        */
        tarih.clear();
        tarih.sendKeys("05/25/2023");

        //  Tarih WebElementinin attribute degerlerini yazdiralim
        String  idAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').id").toString();
        String  typeAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').type").toString();
        String  nameAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').name").toString();
        String  valueAttributeDegeri = js.executeScript("return document.getElementById('checkin_date').value").toString();
        System.out.println("idAttributeDegeri = " + idAttributeDegeri);
        System.out.println("typeAttributeDegeri = " + typeAttributeDegeri);
        System.out.println("nameAttributeDegeri = " + nameAttributeDegeri);
        System.out.println("valueAttributeDegeri = " + valueAttributeDegeri);

        /*
        Js executor ile attribute değerlerini yazdırabilmek için js ile locate ettiğimiz webelementin sonuna
        yukarıdaki örnekteki gibi hangi attributun değeri yazdırmak istersek sonuna attribute adını yazarız.
         */

    }

    @Test
    public void test02() {
        //https://www.priceline.com/ adresine gidiniz
        driver.get("https://www.priceline.com");

        //Find your hotel butonunun rengini Kirmizi yazınız
        WebElement button = driver.findElement(By.xpath("//*[text()='Find Your Hotel']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.color='red';",button);
    }
}
