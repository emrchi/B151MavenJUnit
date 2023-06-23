package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {

    @Test
    public void test01() {

        // c01 clas'daki ornegi birde TestBase deki visibileWait metodu ile cozelim

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        //Hello World! Yazısinın sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        visibleWait(helloWorld,20);
        Assert.assertEquals("Hello World!", helloWorld.getText());
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        //Hello World! Yazısinın sitede oldugunu test et
        visibleWait(By.xpath("//*[text()='Hello World!']"),20);
        Assert.assertEquals("Hello World!",driver.findElement(By.xpath("//*[text()='Hello World!']")).getText());
    }
}
