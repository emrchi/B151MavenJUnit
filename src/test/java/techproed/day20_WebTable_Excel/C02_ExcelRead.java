package techproed.day20_WebTable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead {
    /*
    EXCEL dosyasından veri okuyabilmemiz için öncelikle pom.xml dosyamıza poi ve poi.ooxml dependency'lerini
yüklememiz gerekir.
    Sonra üzerinde çalışacağımız excel dosyasını projemizde src>test>java>techpoed>resources package'i içine
kayarız.
     */

    @Test
    public void test01() throws IOException {
        //1 - Dosya yolunu aliriz
        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";

        //2 - Dosya'yi okuyabilmemiz icin Java'da akisa almamiz gerekir (stream)
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3 - java ortamin'da bir excel dosyasi olusturabilmek icin
        Workbook workbook = WorkbookFactory.create(fis);             //-->Akisa aldigimiz dasyayi okuyoruz.

        //4 - Olusturdugumuz ecxel'den sayfa(sheet) secmemiz gerekir.
        Sheet sheet = workbook.getSheet("Sheet1");

        //5 - Belirttigimiz sayfada ki satir(row) bilgisini secmemiz gerekir.
        Row row = sheet.getRow(0);                                 //-->Satir da index 0 dan basladigi icin 1. satiri getirir.

        //6 - Belirttigimiz satir daki hucre(cell) bilgisini secmemiz gerekir.
        Cell cell = row.getCell(0);

        //7 - Son olarak cell bilgisini sout ile yazdirip excell'deki 1.satir 1.hucrede ki veriyi gorebiliriz.
        System.out.println(cell);
    }

    @Test
    public void test02() throws IOException {
        //Pratik Cozum
        //1. satir ve 1. sutun daki bilgileri yazdiriniz
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String satir1sutun1 = workbook.getSheet("sheet1").getRow(0).getCell(0).toString();
        System.out.println("1. satir 1. sutun Bilgisi : " + satir1sutun1);

    }

    @Test
    public void test03() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("sheet1").getRow(0).getCell(1));

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3Sutun1 = workbook.getSheet("sheet1").getRow(2).getCell(0).toString();
        System.out.println("3. satir 1. sutun Bilgisi : " + satir3Sutun1);
        Assert.assertEquals("France",satir3Sutun1);

        //Kullanılan satır sayısın bulun
        System.out.println("Kullanilan Satir Sayisi : " + workbook.getSheet("sheet1").getPhysicalNumberOfRows());
        //NOT:getPhysicalNumberOfRows() methodu kullanilan yani ici dolu olan satirlarin sayisini verir.Index 1 den baslar

        //sayfa'daki satir sayisini bulun yazdirin.
        System.out.println("Sayfa'daki Satir Sayisi : " + workbook.getSheet("sheet1").getLastRowNum());
        //NOT:getLastRowNum() methodu sayfadaki satır sayısını verir ve index 0(sıfır) dan başlar

        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("sheet1").getRow(i).getCell(j)+"\t");
            }
            System.out.println();
        }
    }
}
