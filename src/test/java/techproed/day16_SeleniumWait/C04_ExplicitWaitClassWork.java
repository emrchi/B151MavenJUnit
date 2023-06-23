package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C04_ExplicitWaitClassWork extends TestBase {
    @Test
    public void test01() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Click me to open an Alert buttonuna basalım
        WebElement buton = driver.findElement(By.xpath("(//button)[3]"));
        buton.click();
        // visibleWait(buton,10); yada:
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()); yada:
        alertWait(10);


        //Çıkan Alert'ü kapatalım
        acceptAlert();

    }

    @Test
    public void test02() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Chance text to selenium webDriver buttonuna basalım
        WebElement button = driver.findElement(By.id("populate-text"));
        button.click();
        //Selenium Webdriver yazisinin gorundugunu test edelim
        WebElement text = driver.findElement(By.xpath("//*[text()='Selenium Webdriver']"));
        Assert.assertEquals("Selenium Webdriver",text.getText());

    }

    @Test
    public void test03() {

        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        ////Display buttonuna basalim
        WebElement button = driver.findElement(By.id("display-other-button"));
        button.click();
        //Enable butonunun gorundugunu test edelim
        WebElement text = driver.findElement(By.xpath("(//*[text()='Enabled'])[1]"));
        //visibleWait(text,15);
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertTrue(text.isDisplayed());
    }

    @Test
    public void test04() {

        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Enable button after 10 second buttonuna basalim
        WebElement enableButton = driver.findElement(By.id("enable-button"));
        enableButton.click();
        //Button butonununa basalim
        WebElement button = driver.findElement(By.xpath("//*[@id='disable']"));
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
        //Button butonunun kullaniliroldugunu test edelim
        Assert.assertTrue(button.isEnabled());
    }

    @Test
    public void test05() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //Check Checkbox after 10 seconds basalim
        WebElement button = driver.findElement(By.xpath("//*[text()='Check Checkbox after 10 seconds']"));
        button.click();

        //Checkbox butonununun check oldugunu test edelim
        WebElement checkBox = driver.findElement(By.xpath("//*[@type='checkbox']"));
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeSelected(checkBox));
        Assert.assertTrue(checkBox.isSelected());
    }
}
