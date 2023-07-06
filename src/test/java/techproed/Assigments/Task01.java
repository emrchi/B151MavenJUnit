package techproed.Assigments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task01 {

//    - Before methodu ile drive'i olusturup ayarlamalari yapiniz
//    - ebay sayfasına gidiniz
//    - electronics bölümüne tıklayınız
//    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
//    - Her sayfanın sayfa başlığını yazdıralım
//    - After methodu ile sayfayı kapatalım

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://ebay.com");
    }

    @Test
    public void test01() {
        driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click();
        List<WebElement> pictures=driver.findElements(By.xpath("//*[@width='225'] | //*[@height='225']"));
        for (int i = 0; i < pictures.size() ; i++){
            pictures=driver.findElements(By.xpath("//*[@width='225'] | //*[@height='225']"));
            pictures.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
