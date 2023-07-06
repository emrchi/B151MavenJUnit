package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02_ExtentReport extends TestBase {

    @Test
    public void test01() {
        extentReport("Chrome","Amazon Testi","Extent Report","Test Raporu");

        //amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");

        //sayfanın resmini alınız
        screenshotFullPage();
        extentTest.info("Sayfanin resmi alindi.");

        //arama kutusunda iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi.");
        extentTest.pass("Sayfa kapatildi.");
        extentReports.flush();

    }
}
