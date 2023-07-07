package techproed.day21_Excel_JSExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel {
    @Test
    public void readEcxel() throws IOException {
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));
        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("3. Satir 1. Sütun bilgisi = " + satir3Sutun1);
        Assert.assertEquals("France", satir3Sutun1);

        //Kullanılan satır sayısın bulun
        System.out.println("Kullanılan Satir Sayisi : " + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //NOT:getPhysicalNumberOfRows() methodu kullanılan yani içi dolu olan satırların sayısını verir.Index 1 den başlar

        //Sayfadaki satır sayısını yazdırınız
        System.out.println("Sayfadaki Satir Sayisi : " + workbook.getSheet("Sheet1").getLastRowNum());
        //NOT:getLastRowNum() methodu sayfadaki son satırın sıra numarasını verir ve index 0(sıfır) dan başlar


        //Ülke-Başkent şeklinde verileri yazdırın yol 1
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j) + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test02() throws IOException {
        //Ülke-Başkent şeklinde verileri yazdırın yol 2
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Map<String,String> ulkeBaskent =new LinkedHashMap<>();
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; i++) {
            String ulke = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String sehir = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,sehir+"\n");
        }
        System.out.println(ulkeBaskent);
    }

    @Test
    public void test03() throws IOException {
        //Ülke-Başkent şeklinde verileri yazdırın yol 3
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Map<String,String> ulkeBaskent =new LinkedHashMap<>();
        for (int i = 0; i <= workbook.getSheet("Sheet1").getLastRowNum() ; i++) {
            if (workbook.getSheet("Sheet1").getRow(i) != null) {     //-->Satirlar bos degilse.
                String ulke = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
                String sehir = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
                ulkeBaskent.put(ulke, sehir + "\n");
            }
        }
        System.out.println(ulkeBaskent);

        /*
        Dongude bos olan hucreye geldigi icin nullPointerException hatasi aliyoruz
        If blogu icinde bos olmayan satirlari al diyerek (workbook.getSheet("Sheet1").getRow(i) != null)
        bu sorunu cozmus oluyoruz.
         */
    }
}
