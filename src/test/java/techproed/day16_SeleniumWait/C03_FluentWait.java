package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {

    // c01 clas'daki ornegi birde FluentWait metodu ile cozelim
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        //Hello World! Yazısinın sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20)).                 //-->FluentWait max. 20 sn bekleyecek
                pollingEvery(Duration.ofMillis(200)).             //-->200 milisn araliklarla webelementin etkilesime girdigini kontrol eder
                withMessage("Webelementi kontrol et");            //hata alma durumunda bu mesaji verir --> zorunlu degil
        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assert.assertEquals("Hello World!", helloWorld.getText());
    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[text()='Start']")).click();

        //Hello World! Yazısinın sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).                 //-->FluentWait max. 20 sn bekleyecek
                                 pollingEvery(Duration.ofMillis(200)).               //-->200 milisn araliklarla webelementin etkilesime girdigini kontrol eder
                                 until(ExpectedConditions.visibilityOf(helloWorld));

        Assert.assertEquals("Hello World!", helloWorld.getText());
    }
    @Test
    public void test03() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("(//h4)[2]"));
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofMillis(200));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assert.assertEquals("Hello World!", helloWorld.getText());
    }
    //Ayni soruyu FluentWait methodu ile cozelim TestBase'den

    @Test
    public void test04() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorld = driver.findElement(By.xpath("(//h4)[2]"));
        visibleFluentWait(helloWorld,20,200);

        Assert.assertEquals("Hello World!", helloWorld.getText());
    }
}
