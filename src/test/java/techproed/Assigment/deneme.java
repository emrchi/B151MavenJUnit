package techproed.Assigment;

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

public class deneme {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void ebay() throws InterruptedException {
        driver.get("https://www.ebay.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li[@class='hl-cat-nav__js-tab'])[1]")).click();
        Thread.sleep(2000);

        for (int i = 0; i < 24 ; i++) {
            List<WebElement> liste = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            liste.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
