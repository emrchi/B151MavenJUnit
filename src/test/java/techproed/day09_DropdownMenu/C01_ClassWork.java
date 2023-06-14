package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {

    /*
   1)https://amazon.com adresine gidin
   2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
   ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
   ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
   ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
   ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
   */
   static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    //○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
    @Test
    public void title() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    //○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void image() {
        WebElement amazonResim = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazonResim.isDisplayed());
    }
    //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
    @Test
    public void searchBox() {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());

    }
    //○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
    @Test
    public void wrongTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }

}
