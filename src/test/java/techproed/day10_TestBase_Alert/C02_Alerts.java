package techproed.day10_TestBase_Alert;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Alerts extends TestBase {
        /*
            Eğer bir sayfadaki bir buttona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye sağ klik
         yapıp locate alamıyorsak, bu bir js Alert'tür.
            js Alert'ü handle edebilmek için driver'ımızı o pencere geçirmemiz gerekir. Bunun için;
         driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alert'e geçiş yapmış oluruz
         accept() yada dismiss() methodlarıyla js Alert'ü onaylar yada iptal ederek kapatırız.
         */

        //Bir metod olusturun: acceptAlert
    @Test
    public void acceptAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(3);
        driver.switchTo().//geçmek için kullanılan method
                alert().//alert'e geçiş yapar
                accept();//çıkan alert'te ok yada tamam butonuna tıklar
        bekle(2);
        WebElement resultMesaj = driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi = "You successfully clicked an alert";
        Assert.assertEquals(istenenYazi, resultMesaj.getText());
    }
    //Bir metod olusturun: dismissAlert
    @Test
    public void dissmissAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(3);
        driver.switchTo().alert().dismiss();    //çıkan alert'te cancel butonuna tıklar
        bekle(2);
        WebElement resultMesaj = driver.findElement(By.xpath("(//p)[2]"));
        Assert.assertFalse(resultMesaj.getText().contains("successfuly"));
    }
    //Bir metod olusturun: sendKeysAlert
    @Test
    public void sendKeysAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(3);
        driver.switchTo().alert().sendKeys("Emre");
        bekle(2);
        driver.switchTo().alert().accept();
        bekle(2);
        WebElement resultMesaj = driver.findElement(By.xpath("(//p)[2]"));
        Assert.assertTrue(resultMesaj.getText().contains("Emre"));
    }
}
