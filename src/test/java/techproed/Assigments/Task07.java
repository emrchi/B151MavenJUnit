package techproed.Assigments;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class Task07 extends TestBase {

        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        //-Sarı olduğunu test edelim


    @Test
    public void test01() {
        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);

        WebElement button2 = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        Point button2Yeri = button2.getLocation();
        System.out.println(button2Yeri);

        WebElement button1 = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
        Point button1Yeri = button1.getLocation();
        System.out.println(button1Yeri);

        WebElement colorPicker = driver.findElement(By.xpath("//*[@class='ui-widget-content']"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(button2,-178,0).perform();
        screenshotWebElement(colorPicker);
        bekle(3);
        actions.dragAndDropBy(button2,314,0).perform();

        //-Sarı olduğunu test edelim
        screenshotWebElement(colorPicker);
        button2Yeri = button2.getLocation();
        Assert.assertEquals(button2Yeri.x, button1Yeri.x);

        //-Sarı olduğunu test edelim

//        WebElement kutu=driver.findElement(By.cssSelector("div#swatch"));
//        String sari=kutu.getAttribute("style");
//        String atributeName="background-color: rgb(255, 255, 0);";
//        Assert.assertEquals(sari,atributeName);


    }
}
