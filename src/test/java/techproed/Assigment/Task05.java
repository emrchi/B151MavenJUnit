package techproed.Assigment;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class Task05 extends TestBase {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        // ikinci emojiye tıklayın
        // İkinci emoji öğelerini yazdırınız
        // Parent iframe e geri donun
        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        // Apply button a basiniz


    @Test
    public void test01() {

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        driver.switchTo().frame("emoojis");
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // İkinci emoji öğelerini yazdırınız
        WebElement emojies = driver.findElement(By.xpath("//*[@class='mdl-tabs__panel is-active']"));
        System.out.println(emojies.getText());

        // Parent iframe e geri donun
        driver.switchTo().defaultContent();

        // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        WebElement textBox = driver.findElement(By.xpath("//*[@id='text']"));
        textBox.sendKeys("Emre Yilmaz", Keys.TAB,"Gulucuk",
                Keys.TAB,"Ayicik", Keys.TAB,"Hamburger", Keys.TAB,"Top", Keys.TAB,"Araba",
                Keys.TAB,"Akp", Keys.TAB,"Kalp", Keys.TAB,"Bayrak", Keys.TAB,"Gizle", Keys.TAB,"Bos",Keys.TAB,Keys.ENTER);
        // Apply button a basiniz
    }
}
