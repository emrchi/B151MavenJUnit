package techproed.day08_Assertion_BeforeClassAfterClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClassAfterClass {

    /*
    BeforeClass ve AfterClass: test methodlarimizdan once bir sefer calismasini istedigimiz kodlari bu methodlara
    koyariz. Mesela testlerimiz baslamadan once database baglantisi yapmak icin kullanilabilir yada hangi driver'i
    kullanacaksak yine bunu BeforClass'a koyabiliriz. ayni sekilde testlerimizden sonra database'i sollandirmak icin yada
    raporlarimizi sonlandirmak icin de kullanabiliriz.
     */

    WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
    }
    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("qa", Keys.ENTER);
    }
    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("developer", Keys.ENTER);
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
