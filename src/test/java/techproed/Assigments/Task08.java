package techproed.Assigments;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;
import java.util.Random;

public class Task08 extends TestBase {
    @Test
    public void test01() {

        extentReport("Chrome","Bonigarcia.dev Testi","Extent Report","Slow Calculator Test");

        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        extentTest.info("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidildi.");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        Random random = new Random();
        int randomNumber1 = (random.nextInt(9))+1;
        driver.findElement(By.xpath("//*[text()='"+randomNumber1+"']")).click();
        int randomNumber2 = random.nextInt(10);
        driver.findElement(By.xpath("//*[text()='"+randomNumber2+"']")).click();
        char[] chars = {'+','-','x','÷'};
        char randomChar = chars[random.nextInt(chars.length)];
        driver.findElement(By.xpath("//*[text()='"+randomChar+"']")).click();
        int randomNumber3 = random.nextInt(10);
        driver.findElement(By.xpath("//*[text()='"+randomNumber3+"']")).click();
        int randomNumber4 = random.nextInt(10);
        driver.findElement(By.xpath("//*[text()='"+randomNumber4+"']")).click();
        driver.findElement(By.xpath("//*[text()='=']")).click();
        extentTest.info("Hesap makinasından 2 basamaklı random iki tane sayı seçtik ve random 4 işlemden birini yaptırdik");

        //Sonucu konsola yazdırıp
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[id='spinner']")));
        float  actualResult = Float.parseFloat(driver.findElement(By.xpath("//*[@class='screen']")).getText());
        System.out.println("Actual Result = " + actualResult);
        extentTest.info("Sonucu konsola yazdırdik.");

        //Sonucun doğrulamasını yapalım
        float number1 = Float.parseFloat(randomNumber1 + "" +randomNumber2);
        float number2 = Float.parseFloat(randomNumber3 + "" +randomNumber4);
        float expectedResult = 0;
        switch (randomChar) {
            case '+':
                expectedResult = number1 + number2;
                break;
            case '-':
                expectedResult = number1 - number2;
                break;
            case 'x':
                expectedResult = number1 * number2;
                break;
            case '÷':
                expectedResult =  number1 /number2;
                break;
        }
        System.out.println("Expected Result = " + expectedResult);

        Assert.assertEquals(expectedResult, actualResult, 0.0);
        extentTest.info("Sonucun doğrulamasi yapildi");
        extentTest.pass("Sayfa kapatildi.");
        extentReports.flush();
    }

}
