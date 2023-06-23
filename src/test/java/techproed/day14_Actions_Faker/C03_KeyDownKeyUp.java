package techproed.day14_Actions_Faker;

import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("http://www.google.com");

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).  //--> Arama kutusunda shift tusuna basılı tuttuk
                sendKeys("selenium-").             //-->SELENIUM metnini buyuk harfle yazacak
                keyUp(aramaKutusu, Keys.SHIFT).    //--> Arama kutusunda shift tusunu serbest biraktik
                sendKeys("java", Keys.ENTER).      //-->java metnini kucuk harfle yazacak
                perform();
    }

    @Test
    public void test02() {
        //Actions Class'i kullanmadan yapalim

        //Google anasayfasına gidelim
        driver.get("http://www.google.com");

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
    }

            /*
        Mouse islemleri icin actions class' ini kullanmamiz gerekir. Fakat bir metin kutusundaki klavye islemleri icin
        actions class' ini kullanmadan sendKeys() methodu ile de istedigimiz bir metni buyuk yazdirabilir,
        hatta birden fazla klavye tuslarina bastirabiliriz.Yukaridaki ornekte sendKeys() methodu ile Keys.SHIFT diyerek
        sonrasinda yazdirmak istedigimiz metni kucuk harfle yazmamiza ragmen buyuk harflerle yazdirdi, tekrar Keys.SHIFT
        kullanarak shift tusunu serbest birakmis olduk.
             */

    @Test
    public void test03() {

        //google sayfasına gidelim
        driver.get("http://www.google.com");
        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium",Keys.ENTER);

        // Sayfayı bekleyin
        bekle(2);

        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim

        //1.yol Action ile:
        aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(aramaKutusu).keyDown(aramaKutusu,Keys.CONTROL).sendKeys("x").perform();
        bekle(2);
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().back();
        bekle(2);
        aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        actions.doubleClick(aramaKutusu).keyDown(aramaKutusu,Keys.CONTROL).sendKeys("v",Keys.ENTER).perform();
        bekle(2);

        //2.yol Actions kullanmadan
        aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.CONTROL,"a");    //--> Metni kesebilmemiz icin once ctrl+a ile secmemiz gerekir
        aramaKutusu.sendKeys(Keys.CONTROL,"x");
        bekle(2);
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().back();
        bekle(2);
        aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.CONTROL,"v",Keys.ENTER);
        bekle(2);
    }
}
