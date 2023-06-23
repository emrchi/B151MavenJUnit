package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {
    /*
     TestBase class'indan obje olusturmanin onune gecmek icin bu class'i abstract yapabiliriz
     TestBase testBase new = TestBase(); yani bu sekilde obje olusturmanin onune gecmis oluruz
     Bu class'a extends yaptigimiz test class'larindan ulasabiliriz.
    */

    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

    //HARD WAIT(Bekleme Methodu)
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Selenium Wait/Explicit Wait
    //1.visiblityOf(element) methodu
    public void visibleWait(WebElement element, int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //2.visibilityOfElementLocated(locator) methodu
    public void visibleWait(By locator, int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //FluentWait visible Methodu
    public void visibleFluentWait(WebElement element, int saniye, int milisaniye) {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(saniye)).        //-->FluentWait max. girilen sn bekleyecek
                pollingEvery(Duration.ofMillis(milisaniye)).                         //-->girilen milisn araliklarla webelementin etkilesime girdigini kontrol eder
                until(ExpectedConditions.visibilityOf(element));
    }

    //AlertWait methodu
    public void alertWait(int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //acceptAlert()
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //dismissAlert()
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //getTextAlert()
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    //sendKeysAlert()
    public void sendkeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText()
    public void selectVisibleText(WebElement ddm, String text) {
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //DropDown Index()
    public void selectIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value()
    public void selectValue(WebElement ddm, String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    //Switch To Window-1
    public void switchToWindow_1(int index) {
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));
    }

    //Switch To Window-2
    public void switchToWindow_2(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    //Tum Sayfa Resmi (Screenshot)
    public void screenshotFullPage() {
        String tarih = new SimpleDateFormat("_hh_mm_ss_dd_MM_yyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebElement Resmi (Screenshot)
    public void screenshotWebElement(WebElement element) {

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/elementResmi/WeScreenShot" + tarih + ".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
