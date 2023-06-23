package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
                //Sag klik yapabilmek icin oncelikle Action class' indan bir obje olusturmaliyiz
        Actions action = new Actions(driver);
        action.contextClick(kutu).perform();      //action objemizle yapacagimiz islemi uygulamasi icin veya sonlandirmasi icin perform() kullaniriz

        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        Alert alertYazi =driver.switchTo().alert();
        Assert.assertEquals("You selected a context menu",alertYazi.getText());
        bekle(2);
        //Assert.assertEquals("You selected a context menu",getTextAlert()); //TestBase deki methodu kullandik farkli bir yol

        //Tamam diyerek alert'i kapatın
        alertYazi.accept();
        //acceptAlert();   //TestBase deki methodu kullandik farkli bir yol
    }
}
