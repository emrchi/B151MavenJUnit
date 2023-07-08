package techproed.day20_WebTable_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class day20_homeWork extends TestBase {
    @Test
    public void name() {

        //ÖDEV
        extentReport("Chrome","Raporun Raporu","Rapor Sayfasi Testi","Yapilan Test'in Testi");

        //C01_WebTables class'ı için aldığımız rapora gidelim
        driver.get("C:\\Users\\emres\\IdeaProjects\\B151MavenJUnit\\testOutput\\extentReports\\extentReport_06_45_32_06072023.html");
        extentTest.info("Rapora gidildi...");

        //Başlığın Extent Report olduğunu test edelim
        Assert.assertEquals("Extent Report", driver.getTitle());
        extentTest.info("Başlığın Extent Report olduğu test edildi");

        //Rapor temasını dark yapalım
        driver.findElement(By.id("theme-selector")).click();
        extentTest.info("Rapor temasi dark yapildi");

        //Dashboard bölümüne gidip tabloyu yazdırınız
        driver.findElement(By.xpath("//*[@class='waves-effect']")).click();
        WebElement table = driver.findElement(By.xpath("(//table)[3]"));
        System.out.println(table.getText());
        extentTest.info("dashboard bolumundeki tablo yazdirildi.");

        //Tester'ın "Emre" olduğunu doğrulayalım
        String actualData = driver.findElement(By.xpath("(//table)[3]//tr[3]//td[2]")).getText();
        String expectedData = "Emre";
        Assert.assertEquals(expectedData,actualData);
        extentTest.info("Tester'ın Emre olduğu doğrulandi.");

        //Sayfayı kapatalım
        extentTest.pass("Sayfa kapatildi");
        extentReports.flush();

    }
}
