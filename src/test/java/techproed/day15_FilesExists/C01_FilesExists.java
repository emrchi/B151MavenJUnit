package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {

        /*
    Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulayabilmek
için;
    Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
assing ederiz.
 */
    String dosyaYolu = "C:\\Users\\emres\\OneDrive\\Desktop\\CV Emre Yilmaz.pdf";
        //--> "C" den once ve en sondaki çift tırnaktan önce /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu)));  //--> Dosya varsa true yoksa false doner.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test02() throws InterruptedException {
          /*
        Bir server'da farkli işletim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
    daha dinamik olması açısından System.getProperty("os.name") bu şekilde işletim sistemi alır
    her işletim sistemin kullanıcı yolu farklı olacağından System.getProperty("user.home")
    bilgisayarımızdaki kullanıcı yolunu bu şekilde String bir değişkene farklıYol ismiyle System.getProperty("user.home")
    atayarak herseferinde farklı yolları almayla uğraşmamış oluruz. Dosya diyelimki masaüstünde ve her işletim
    sisteminde bize aynı yolu vereceği için bunuda ortakYol olarak bir String'e assing ederiz
     */
        String farkliyol = "";
        String isletimSistemiadi = System.getProperty("os.name");//--> Isletim sistemimizin adini verir.
        System.out.println(isletimSistemiadi);                   //Windows 11

        String kullaniciyolu = System.getProperty("user.home"); //Bilgisayarimizdaki kullanici yolunu verir.
        System.out.println(kullaniciyolu);                          //C:\Users\emres

        if(isletimSistemiadi.contains("Win")){
            farkliyol = System.getProperty("user.home");//--> Windows isletim sistemi yolu
        }else if(isletimSistemiadi.contains("mac")){
            farkliyol = "/Users/aycapolatkamali"; //--> Mac isletim sistemi yolu
        }
        String ortakYol ="/OneDrive/Desktop/CV Emre Yilmaz.pdf";
        String dosyayolu = farkliyol + ortakYol;
        System.out.println(Files.exists(Paths.get(dosyayolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
        try {
            Files.delete(Paths.get(dosyayolu));   //--> Bu sekilde dosya yolu ile belirtmis oldugumuz dosyayi sileriz
        }catch (IOException e) {
            System.out.println("Dosya bulunamadi");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyayolu))); //--> Sildigimiz icin assertFalse kullandik
        System.out.println(Files.exists(Paths.get(dosyayolu)));
        Thread.sleep(2000);
        try {
            Files.createFile(Paths.get(dosyayolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
    Her seferinde test ettigimiz sayfada download islemi yapiliyorsa gereksiz dosya kalabaligini onlemek icin
    yukardaki delete islemini kullanabiliriz
        */
    }
    /*
    Yukaridaki methodlarda bilgisayarimizdaki dosya yolunun varligini Files.exists() methodu ile test etmistik.
    Ayni islemi asagidaki ornekteki gibi File class'indan obje olusturarak da yapabiliriz
    */
    @Test
    public void test03() {
        String dosyaYolu = "C:\\Users\\emres\\OneDrive\\Desktop\\CV Emre Yilmaz.pdf";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();
    }
}
