package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
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
import java.util.List;

public class C03_Dropdown {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    //programming languages ddm den istediğiniz 4 seçeneği seçiniz
    @Test
    public void test() throws InterruptedException {
        WebElement programingLang = driver.findElement(By.xpath("(//select)[6]"));
        Select select = new Select(programingLang);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        Thread.sleep(2000);

    //Eger sadece secili olan secenekleri yazdirmak istersek.
        select.getAllSelectedOptions().forEach(w -> System.out.println(w.getText())); //==> Lamdha ile

        System.out.println("*******************");

        for (WebElement w : select.getAllSelectedOptions()){
            System.out.println(w.getText());                                          //==> for ile
        }

    //Seceneklerden 4 tane sectigimizi dogrulayalim
        Assert.assertEquals(4, select.getAllSelectedOptions().size());

    //Sectigimiz seceneklerden ilkini yazdiralim, ilk secenegin Java oldugunu dogrulayalim
        System.out.println("*******************");
        System.out.println("Secilen seceneklerden ilki: " + select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java", select.getFirstSelectedOption().getText());

    //Sectigimiz seceneklerin hepsini kaldiralim.
        select.deselectAll();
        bekle(2);

    //sendKeys() ile istedigimiz bir secenegi gonderelim, sonra oklar ile bi alta gecip o secenegide secelim
        programingLang.sendKeys("C#", Keys.CONTROL, Keys.ARROW_DOWN, Keys.SPACE);
        bekle(2);


    //vissibleText olarak secim yapacagimiz bir method olusturup programming languages ddm den bir secenek secelim.
        selectVisibleText(programingLang, "Java");
        bekle(2);

    //selectIndex olarak secim yapacagimiz bir method olusturup programming languages ddm den bir secenek secelim.
        selectIndex(programingLang, 1);
        bekle(2);

    //selectValue olarak secim yapacagimiz bir method olusturup programming languages ddm den bir secenek secelim.
        selectValue(programingLang, "ruby");

    }

    @After
    public void tearDown() throws Exception {
        bekle(2);
        driver.close();
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
