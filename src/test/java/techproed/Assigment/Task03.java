package techproed.Assigment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Task03 {
//-Amazon sayfasına gidelim
//-Arama Kutusundaki Dropdown menuyu yazdıralım
//-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
//başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
//Not: Select Class'ı kullanalım

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
    //-Arama Kutusundaki Dropdown menuyu yazdıralım
        Select select = new Select(driverfindElement("//select"));
        select.getOptions().forEach(w-> System.out.println(w.getText()));
    //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        for (int i = 0; i < 5; i++) {
            selectIndex(driverfindElement("//select"),i);
            driverfindElement("//*[@id='nav-search-submit-button']").click();
            System.out.println(driver.getTitle());
        }
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    public WebElement driverfindElement(String xpath){
        return  driver.findElement(By.xpath(xpath));
    }
    public void selectIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }


}
