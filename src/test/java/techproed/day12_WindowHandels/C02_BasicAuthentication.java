package techproed.day12_WindowHandels;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

import java.util.List;

public class C02_BasicAuthentication extends TestBase {

    //Basic authentication' larda kullanici adi ve sifrenin bize mutlaka verilmesi gerekir.
    //https://Kullanici Adi:Sifre@internetsitesi seklinde bir kullanimla handle edebiliriz
    @Test
    public void test01() {
        /*
    Aşağıdaki bilgileri kullanarak authentication yapınız:
    Url: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin
    Başarılı girişi doğrulayın.
        */
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);
        WebElement text = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(text.getText().contains("Congratulations!"));

        //Elemental Selenium yazısına tıklayalım
        driver.findElement(By.xpath("(//a)[2]")).click();
        //Başlığın Elemental Selenium olmadigini doğrulayın
        switchToWindow_1(1);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Elemental Selenium";
        Assert.assertNotEquals(expectedTitle,actualTitle);
        bekle(2);
        //DDM' den Java secelim
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");

        //yada TestBase'den method ile:
        //selectVisibleText(ddm, "Java");


    }
}
