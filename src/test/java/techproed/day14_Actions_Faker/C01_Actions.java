package techproed.day14_Actions_Faker;

import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https:www.techproeducation.com");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        bekle(2);

        //sayfanin altina dogru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        bekle(2);

        //sayfanin ustune dogru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();

    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);
        bekle(2);

        //sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).build().perform();
        //build() -->methodu action'lari birlestirmek icin kullanilan methoddur.Birden fazla olusturdugumuz action
        //objesini birbirine baglar
        //release() methodu mouse'u birakir
    }

    @Test
    public void test03() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();
        bekle(2);

          /*
        scrollByAmount(0,1500) kartezyen koordinat sistemi olan yatay ve düsey yönleri x ve y olarak adlandirdigimiz sistemde x=0 ile y=+1500 arasinda
        gidecektir. pozitif(+) yön kuzey secilmistir
         */

        //sayfanın üstüne doğru gidelim
        actions.scrollByAmount(0,-1500).perform();
    }
}
