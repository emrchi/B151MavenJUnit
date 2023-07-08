package techproed.day20_WebTable_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C01_webTables extends TestBase {

     /*
    WEBTABLE;
        <table> tagi ile baslar
            <thead> basliklar icin bu tag ile devam eder
                <th> table head
                    <td> basliktaki veriler
                        <tbody> basliklar altindaki verileri temsil eder
                            <tr> table row(satir)
                                <td> table data(tablodaki veri)

     */

    @Test
    public void test01() {
        extentReport("Chrome","WebTable","Web Table","Test Raporu");

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("https://the-internet.herokuapp.com/tables sayfasına gidildi.");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());
        extentTest.info("Tablo 1 yazdirildi.");

        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatirVeri = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("3. Satir Verileri : ");
        System.out.println(ucuncuSatirVeri.getText());
        extentTest.info("3. Satir Verileri yazdirildi.");

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatirVeri = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));        //last() --> istenilene gore son satir yada  sutun bilgilerini verir.
        System.out.println("Son Satir Verileri : ");
        System.out.println(sonSatirVeri.getText());
        extentTest.info("Son Satir Verileri yazdirildi.");

        //    Task 4 : 5. Sütun verilerini yazdırın
        WebElement besincibaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        List<WebElement> besincisutunVeri = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        System.out.println("5. Sutun Verileri : ");
        System.out.println(besincibaslik.getText());
        besincisutunVeri.forEach(w-> System.out.println(w.getText()));
        extentTest.info("5. Sutun Verileri yazdirildi.");

        //    Task 5 : 3. satirdaki 1. ve 2. sutun bilgilerini yazdiriniz
        List<WebElement> ucuncuSatir = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        System.out.println("3. Satir 1. ve 2. Sutun Verileri : ");
        ucuncuSatir.forEach(w-> System.out.println(w.getText()));
        extentTest.info("3. Satir 1. ve 2. Sutun Verileri yazdirildi.");

        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

        printData(1,2,3);
        extentTest.info("2. Satir 3. Sutun bilgileri yazdirildi.");

        //3. Satir 2. sutun bilgisinin Jack olup olmadigini dogrulayin
        printData(1,3,2);
        String actualData = actualData(1,2,3);
        String expectedData = "Jack";
        Assert.assertNotEquals(expectedData, actualData);
        extentTest.fail("3. Satir 2. Sutun bilgisinin 'Jason' oldugu goruldu.");

        extentTest.pass("Sayfa Kapatıldı");
        extentReports.flush();
    }

    public void printData(int table, int satir, int sutun){
        WebElement data = driver.findElement(By.xpath("(//table)["+table+"]//tr["+ satir +"]//td["+sutun+"]"));
        System.out.println(table + ".ci tablo " + satir + ".ci satir " + sutun + ".ci sutun datasi : ");
        System.out.println(data.getText());
    }
    public String actualData(int table, int satir, int sutun){
        WebElement data = driver.findElement(By.xpath("(//table)["+table+"]//tr["+ satir +"]//td["+sutun+"]"));
        return data.getText();
    }
}
