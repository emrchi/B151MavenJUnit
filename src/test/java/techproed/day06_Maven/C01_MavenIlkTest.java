package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //        https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");
        //        arama kutusunu locate edelim
        WebElement aramakutusu = driver.findElement(By.cssSelector("input[id=twotabsearchtextbox]"));

        //        “Samsung headphones” ile arama yapalim
        aramakutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //        Bulunan sonuc sayisini yazdiralim
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuc Sayisi: " + sonuc.getText().split(" ")[2]);

        //        Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//h2//a)[1]")).click();

        //        Sayfadaki tum basliklari yazdiralim  Asagida biz cok yazdirmamak icin  h1 ve h2 yi aldik ama butun basliklar icin h6 ya kadar almaliydik.
        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1 | //h2"));
        sayfaBasliklari.forEach(t-> System.out.println(t.getText()));

        driver.close();
    }
}
