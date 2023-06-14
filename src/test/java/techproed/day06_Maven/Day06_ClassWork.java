package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_ClassWork {

//    C01_TekrarTesti isimli bir class  olusturun
//    https://www.google.com/  adresine gidin
//    cookies uyarisini  kabul ederek kapatin
//    Sayfa	basliginin	"Google"	ifadesi	icerdigini	test  edin
//    Arama cubuguna "Nutella" yazip aratin
//    Bulunan sonuc sayisini yazdirin
//    sonuc sayisinin 10 milyon'dan fazla oldugunu test  edin
//    Sayfayi kapatin

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    https://www.google.com/  adresine gidin
        driver.get("https://www.google.com/");

        //    cookies uyarisini  kabul ederek kapatin
        //    Sayfa	basliginin	"Google"	ifadesi	icerdigini	test  edin
        if(driver.getTitle().contains("Google")){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

        //    Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.id("APjFqb")).sendKeys("Nutella", Keys.ENTER);

        //    Bulunan sonuc sayisini yazdirin
        String [] sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        String sonucSayisi = sonucYazisi[1];
        System.out.println(sonucSayisi);


        //    sonuc sayisinin 10 milyon'dan fazla oldugunu test  edin
        if (convertStringToInt(sonucSayisi)>1000000000){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

        //    Sayfayi kapatin
        driver.close();
    }
    public static int convertStringToInt(String sonucSayisi) {
        try {
            return Integer.valueOf(sonucSayisi);

        }catch (NumberFormatException e) {

            sonucSayisi = sonucSayisi.replaceAll("[^0-9]","");

            return Integer.valueOf(sonucSayisi);
        }
    }


}
