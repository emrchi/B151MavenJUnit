package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {
    @Test
    public void test01() {
        String dosyaYolu = "C:\\Users\\emres\\Downloads\\b10 all test cases, code.docx";
        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
            /*
        Dosyayı daha önce indirdiğimiz için ve tekrar testi çalıştırdığımızda yine aynı dosyayı indireceği için
        burda dosyayı basta  sildik
            */
        }

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']")).click();
        bekle(5); //--> Indirme suresini goz onunde bulundurarak bekle koyduk
        //Dosyanın başarıyla indirilip indirilmediğini test edelim

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

}
