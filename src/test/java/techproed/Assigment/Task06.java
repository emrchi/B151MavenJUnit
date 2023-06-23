package techproed.Assigment;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class Task06 extends TestBase {

        //http://szimek.github.io/signature_pad/ sayfasına gidiniz
        //Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        //Çizimden sonra clear butonuna basınız
        //Sayfayi kapatiniz
    @Test
    public void test01() {
        //http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        //Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement tahta = driver.findElement(By.xpath("//*[@id='signature-pad']"));
        driver.findElement(By.xpath("//*[text()='Change color']")).click();
        Actions actions =new Actions(driver);
        actions.moveToElement(tahta);
        actions.clickAndHold(tahta)
                .moveByOffset(70, 30)
                .moveByOffset(70, -30)
                .moveByOffset(-70, 30)
                .moveByOffset(-70, -30)
                .moveByOffset(70, 30)
                .moveByOffset(70, -30)
                .moveByOffset(-70, 30)
                .moveByOffset(50, 50)
                .moveByOffset(50, 50)
                .moveByOffset(50, 50)
                .moveByOffset(50, 50)
                .release()
                .perform();
        bekle(3);
        //Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//*[text()='Clear']")).click();
        //Sayfayi kapatiniz
    }
}
