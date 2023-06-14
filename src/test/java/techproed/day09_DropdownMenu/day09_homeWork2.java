package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.harmony.unpack200.bytecode.forms.IMethodRefForm;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class day09_homeWork2 {

    static WebDriver driver;
    @BeforeClass
    public static void  setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //    ●https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void test01() {
        //    -Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement ddm = driverfindElement("//select");
        Select select = new Select(ddm);
        Assert.assertEquals(45,select.getOptions().size());
        bekle(2);
    }

    @Test
    public void test02() {
        //    -Test 2
        //    1.Kategori menusunden Books secenegini secin
       WebElement ddm =  driverfindElement("//select");
       selectVisibleText(ddm,"Books");
       bekle(2);
        //    2.Arama kutusuna Java yazin ve aratin
       driverfindElement("//*[@id='twotabsearchtextbox']").sendKeys("Java", Keys.ENTER);
       bekle(2);
        //    3.Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driverfindElement("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]");
        System.out.println(sonucYazisi.getText());
        //    4.Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("Java"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }

    public static WebElement driverfindElement(String xpath){
      return  driver.findElement(By.xpath(xpath));
    }


    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }
    public void selectIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    public void selectValue(WebElement ddm, String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
