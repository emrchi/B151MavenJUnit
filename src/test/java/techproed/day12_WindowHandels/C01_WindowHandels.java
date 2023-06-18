package techproed.day12_WindowHandels;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandels extends TestBase {

    @Test
    public void test01() {
        // Set ile donen handle degerlerini for loop ile aldik

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  ilk sayfasının Handle degerini alın yazdırın
        String firstWindowHandle = driver.getWindowHandle();
        System.out.println("ilk sayfa handle degeri : " + firstWindowHandle);
        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualtext = driver.findElement(By.xpath("//h3")).getText();
        String expectedtext = "Opening a new window";
        Assert.assertEquals(actualtext, expectedtext);
        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualtext,expectedtext);
        bekle(2);
        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();  //--> Kontrolümüz dışında Yeni bir sekme açıldı
        String secondWindowHandel = driver.getWindowHandle();

        /*
    Bir button'a click yaptigimizda kontrolumuz disinda (yani driver.switchTo().window(secondWindowHandle);methodu ile degilde)
    yeni bir sekme ya da pencere acilirsa ,  yeni acilan pencerenin handle degerini bilmedigim icin normal getWindowHandle
    ile driver'imi yeni pencereye geciremem. Bunu getWindowHandles() methoduyla acilan tum pencereleri bir Set'e assign edip ,
    ilk actigimiz pencere degilse ikinci acilan yeni penceredir mantigiyla bir loop icinde cozebiliriz.
        */

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        Set<String> windows = driver.getWindowHandles(); //Bu method bize set dondurdu. sonra biz onu loop icine alicaz.
        for (String w : windows) {
            System.out.println(w);
            if(!w.equals(firstWindowHandle)){
                driver.switchTo().window(w);    //burada eger  sayfa ve ondan sonraki sayfanin handle degeri esit degil ise bir sonraki sayfaya driveri geciriyor
            }
        }
        String secondWindowHandle = driver.getWindowHandle();
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";
        Assert.assertEquals(actualTitle2,expectedTitle2);
        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(firstWindowHandle);
        String firstWindowActualTitle = driver.getTitle();
        String firstWindowExpectedTitle = "The Internet";
        Assert.assertEquals(firstWindowExpectedTitle,firstWindowActualTitle);
        bekle(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(secondWindowHandle);
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(firstWindowHandle);
        bekle(2);
    }

    @Test
    public void test02() {
        //Set ile donen handle degerlerini ArrayList'e cevirip index ile aldik.

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualtext = driver.findElement(By.xpath("//h3")).getText();
        String expectedtext = "Opening a new window";
        Assert.assertEquals(actualtext, expectedtext);
        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualtext,expectedtext);
        bekle(2);
        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        String secondWindowHandel = driver.getWindowHandle();
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles()); //Metodun dondurdugu Set'i ArrayList'e attik.
        driver.switchTo().window(pencereler.get(1)); //Burada ArrayListe gectigimiz icin index ile alabildik loop'a gerek kalmadi.
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";
        Assert.assertEquals(actualTitle2,expectedTitle2);
        bekle(2);

        /*
            getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
        Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
         driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
         */

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        String firstWindowActualTitle = driver.getTitle();
        String firstWindowExpectedTitle = "The Internet";
        Assert.assertEquals(firstWindowExpectedTitle,firstWindowActualTitle);
        bekle(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));
    }

    @Test
    public void test03() {
        //Set yada ArrayList kullanmadan handle degerlerini aldik.

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualtext = driver.findElement(By.xpath("//h3")).getText();
        String expectedtext = "Opening a new window";
        Assert.assertEquals(actualtext, expectedtext);
        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualtext,expectedtext);
        bekle(2);
        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        String secondWindowHandel = driver.getWindowHandle();
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";
        Assert.assertEquals(actualTitle2,expectedTitle2);
        bekle(2);

        /*
    Set ve ArrayList kullanmadan switchTo() methodu icine arguman olarak driver.getWindowHandles() methodu ile butun acilan
    pencereli bir array olarak alip index belirterek istedigim pencereye gecis yapabilirim
        */

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String firstWindowActualTitle = driver.getTitle();
        String firstWindowExpectedTitle = "The Internet";
        Assert.assertEquals(firstWindowExpectedTitle,firstWindowActualTitle);
        bekle(2);
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }

    @Test
    public void test04() {
        //Burada da TestBase de olusturdugumuz methodlarla yaptik.

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualtext = driver.findElement(By.xpath("//h3")).getText();
        String expectedtext = "Opening a new window";
        Assert.assertEquals(actualtext, expectedtext);
        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualtext,expectedtext);
        bekle(2);
        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        String secondWindowHandel = driver.getWindowHandle();
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        switchToWindow_1(1);
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";
        Assert.assertEquals(actualTitle2,expectedTitle2);
        bekle(2);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        switchToWindow_2(0);
        String firstWindowActualTitle = driver.getTitle();
        String firstWindowExpectedTitle = "The Internet";
        Assert.assertEquals(firstWindowExpectedTitle,firstWindowActualTitle);
        bekle(2);
        //  ikinci sayfaya tekrar geçin.
        switchToWindow_2(1);
        //  ilk sayfaya tekrar dönün.
        switchToWindow_1(0);
    }
}
