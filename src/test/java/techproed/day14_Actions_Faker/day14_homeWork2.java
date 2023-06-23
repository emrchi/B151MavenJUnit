package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class day14_homeWork2 extends TestBase {

    @Test
    public void test01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazisi = driver.findElement(By.xpath("//*[@title='Watch on YouTube']"));
        Assert.assertTrue(youtubeYazisi.isDisplayed());


    }
}
