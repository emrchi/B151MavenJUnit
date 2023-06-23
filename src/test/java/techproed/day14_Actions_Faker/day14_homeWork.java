package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class day14_homeWork extends TestBase {

    /*
    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    2- Hover over  Me First" kutusunun ustune gelin
    3- Link 1" e tiklayin
    4- Popup mesajini yazdirin
    5- Popup'i tamam diyerek kapatin
    6- “Click and hold" kutusuna basili tutun
    7-“Click and hold" kutusunda cikan yaziyi yazdirin
    8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
     */

    @Test
    public void test01() {

//        1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

//        2- Hover over  Me First" kutusunun ustune gelin
        WebElement kutu1 = driver.findElement(By.xpath("(//button)[2] "));
        Actions actions =new Actions(driver);
        actions.moveToElement(kutu1).perform();
        bekle(2);

//        3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='dropdown-content'])[1]")).click();

//        4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

//        5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

//        6- “Click and hold" kutusuna basili tutun
        WebElement kutu2 = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(kutu2).perform();

//        7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(kutu2.getText());

//        8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement kutu3 = driver.findElement(By.xpath("//*[@class='div-double-click']"));
        actions.doubleClick(kutu3).perform();
        WebElement kutu4 = driver.findElement(By.xpath("//*[@class='div-double-click double']"));
        Assert.assertNotSame(kutu3,kutu4);

    }
}
