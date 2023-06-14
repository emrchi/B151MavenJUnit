package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Iframe extends TestBase {

    @Test
    public void iFrame() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String kalinYazi = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(kalinYazi.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        bekle(2);
        //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(2);

        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elementalSelenium = driver.findElement(By.xpath("(//*[@target='_blank'])[2]"));
        Assert.assertTrue(elementalSelenium.isDisplayed());

    }
}
