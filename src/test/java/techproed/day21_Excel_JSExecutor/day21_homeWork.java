package techproed.day21_Excel_JSExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class day21_homeWork {
    @Test
    public void odev1() throws IOException {

        //1.satirdaki 2.hucreye gidelim ve yazdiralim
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        //1.satirdaki 2.hucreyi bir string degiskene atayalim ve  yazdiralim
        String satir1hucre2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("birinciSatIkinciSut = " + satir1hucre2);

        //2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
        String satir2hucre4 = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        Assert.assertEquals("Kabil",satir2hucre4);

        //Satir sayisini bulalim
        System.out.println("Satir Sayisi = " + workbook.getSheet("Sayfa1").getLastRowNum());

        //Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Kullanilan Satir Sayisi = " + workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());

        //Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map<String,String> ContriesCapitals = new LinkedHashMap<>();

        for (int i = 0; i < workbook.getSheet("Sayfa1").getLastRowNum(); i++) {
            if (workbook.getSheet("Sayfa1").getRow(i) != null) {
                String Country = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
                String Capital = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
                ContriesCapitals.put(Country, Capital + "\n");
            }
        }
        System.out.println(ContriesCapitals);
    }
}
