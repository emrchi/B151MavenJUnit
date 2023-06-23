package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_FileUploadTest extends TestBase {

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");


        //chooseFile butonuna basalim
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        //chooseFile.click(); --> click yapmadi hata aldik.
        /*
            Eger dosyaSec butonuna basmamiz istenirse ve otomasyon ile bu butona click yapmak istedigimizde exception aliyorsak
            direk upload yapmak istedigimiz dosya yolunu alip sendKeys() methodu ile dosyayi sayfaya upload yapabiliriz
            Eger upload ya da dosyaSec butonuna tikladiginizda windows penceresi aciliyorsa , o webelemente sendKeys() methodu
            ile dosya gonderemeyebilirsiniz. Boyle bir durumla karsilasirsaniz Romot class'indan obje ile methodlar kullanarak
            bunu asabilirsiniz
         */
        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\emres\\Downloads\\C01_Odev.java";
        chooseFile.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isDisplayed());
    }
}
