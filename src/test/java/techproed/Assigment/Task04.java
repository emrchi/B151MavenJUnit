package techproed.Assigment;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class Task04 extends TestBase {

//-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
//-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
//-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
//-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
//-Çıkan alert'te iptal butonuna basınız
//-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
//-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
//-Çıkan mesajı konsola yazdırınız
//-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız


    @Test
    public void Test01() {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
        bekle(2);

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
        bekle(2);

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        bekle(2);

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        bekle(2);

        //-Çıkan alert'te iptal butonuna basınız
        alert.dismiss();
        bekle(2);

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
        bekle(2);

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        alert.sendKeys("Emre");
        bekle(2);
        alert.accept();

        //-Çıkan mesajı konsola yazdırınız
        String actualresult = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        System.out.println(actualresult);

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        String expectedresult = "Hello Emre How are you today";
        Assert.assertEquals(actualresult, expectedresult);
        bekle(2);
    }
}
