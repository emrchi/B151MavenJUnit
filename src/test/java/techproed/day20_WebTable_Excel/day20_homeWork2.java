package techproed.day20_WebTable_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class day20_homeWork2 extends TestBase {
    //    ODEV2
    //    Yeni bir test method olusturalim writeExcelTest()
    @Test
    public void writeExcelTest() throws IOException {

    //    Adimlari takip ederek 1.satira kadar gidelim
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
    //    5.hucreye yeni bir cell olusturalim
    //    Olusturdugumuz hucreye “Nufus” yazdiralim
    //    2.satir nufus kolonuna 1500000 yazdiralim
    //    10.satir nufus kolonuna 250000 yazdiralim
    //    15.satir nufus kolonuna 54000 yazdiralim
    //    Dosyayi kaydedelim
    //    Dosyayi kapatalim

    }
}
