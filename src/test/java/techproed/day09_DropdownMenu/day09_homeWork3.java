package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class day09_homeWork3 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {
        //    1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        bekle(2);
        //    2.Sign in butonuna basin
        driverfindElement("(//i)[1]").click();
        bekle(2);
        //    3.Login kutusuna “username” yazin
        driverfindElement("//*[@type='text']").sendKeys("username", Keys.TAB);
        bekle(2);
        //    4.Password kutusuna “password.” yazin
        //    5.Sign in tusuna basin(not: navigate.Back yapınız)
        driverfindElement("//*[@type='password']").sendKeys("password", Keys.TAB,Keys.TAB,Keys.ENTER);
        driver.navigate().back();
        //    6.Pay Bills sayfasina gidin
        driverfindElement("//a[@id='online-banking']").click();
        bekle(2);
        driverfindElement("//*[@id='pay_bills_link']").click();
        bekle(2);
        //    7.“Purchase Foreign Currency” tusuna basin
        driverfindElement("//*[@class='ui-state-default ui-corner-top'][2]").click();
        bekle(2);
        //    8.“Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driverfindElement("(//select)[3]");
        selectValue(ddm, "EUR");
        bekle(2);
        //    9.“amount” kutusuna bir sayi girin
        driverfindElement("//*[@id='pc_amount']").sendKeys("15000");
        bekle(2);
        //    10.“US Dollars” in secilmedigini test edin
        WebElement usdollarbutton = driverfindElement("//*[@id='pc_inDollars_true']");
        Assert.assertFalse(usdollarbutton.isSelected());
        //    11.“Selected currency” butonunu secin
        driverfindElement("//*[@id='pc_inDollars_false']").click();
        bekle(2);
        //    12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driverfindElement("//*[@id='pc_calculate_costs']").click();
        bekle(2);
        driverfindElement("//*[@id='purchase_cash']").click();
        bekle(2);
        //    “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        WebElement sonucYazisi = driverfindElement("//*[@id='alert_content']");
        Assert.assertTrue(sonucYazisi.isDisplayed());
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    public  WebElement driverfindElement(String xpath){
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
