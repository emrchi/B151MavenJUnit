package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        bekle(2);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)

        //drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();
            /*
        Eğer bir hareketli webelementi tutup başka bir webelementin üzerine bırakmak istersek
        sürüklemek istediğimiz webelementin locate'ini alıp üzerine bırakacağımız webelementin
        lcoate'ini de alarak dragAndDrop(kaynak, hedef) methodu ile işlemi gerçekleştirebiliriz.
            */
    }

    @Test
    public void test02() {
        //ayni soruyu clickandhold ile yapalim:

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        bekle(2);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)

        //drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
        driver.switchTo().frame(0);

        WebElement DragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement DropHere = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(DragMe).moveToElement(DropHere).release().perform();
    }

    @Test
    public void test03() {
        //x ve y koordinatlari ile istedigimiz yere goturup birakalim

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        bekle(2);

        //drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
        driver.switchTo().frame(0);

        WebElement DragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(DragMe).moveByOffset(130,80).release().perform();

    }
}
