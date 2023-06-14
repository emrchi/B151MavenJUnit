package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*
        Bir HTML dokumaninin icine yerlestirilmis baska bir HTML dokumanina inline frame yani Iframe denir.
    Bir sayfada Iframe varsa Iframe icindeki WebElementi handle edebilmek icin switcTo() metodu ile
    Iframe'e gecis yapmamiz gerekir. Eger gecis yapmaz isek NoSuchElement exception aliriz.
        Alert'den farki allert ciktiginda hicbir WebElementi locate edemeyiz,
        Iframe olsada locate ederiz fakat handle edemeyiz.

     */

    @Test
    public void iframe() {
        //➢ https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //➢ Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
        String metin = driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        Assert.assertTrue(metin.contains("black border"));
        //➢Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        //String yazi = driver.findElement(By.xpath("//h1")).getText();
        //Assert.assertEquals("Applications lists",yazi);  iframe oldugu icin bu sekilde WebElemente erisemedik switchTo() ile iframe'e gecis yapmaliyiz.
        driver.switchTo().frame(0);
        String yazi = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(yazi);
        Assert.assertEquals("Applications lists",yazi);
        //➢Son olarak ana sayfadaki footer daki 'Povered By' yazisini varligini test edilip
        driver.switchTo().defaultContent();
        //driver.navigate().refresh(); bu sekilde sayfayi yenilesek ve
        //driver.get(driver.getCurrentUrl());  bu sekilde sayfayi yenilesek de iframe'in disina cikardik.
        String footerYazi = driver.findElement(By.xpath("//*[text()='Povered By']")).getText();
        System.out.println(footerYazi);
        Assert.assertTrue(footerYazi.contains("Povered By"));
    }
}

          /*
            Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
<body>
    <iframe id="outerIframe" src="https://www.w3schools.com">        icice iframe  --> driver.switchTo().frame("outerIframe")
        <iframe id="innerIframe" src="https://www.google.com"></iframe>            --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
    </iframe>
</body>

          İstersek WebElement frame = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.
         */

