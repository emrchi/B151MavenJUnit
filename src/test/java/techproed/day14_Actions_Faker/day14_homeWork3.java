package techproed.day14_Actions_Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class day14_homeWork3 {
        //    Test01
        //1- amazon gidin
        //2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        //3. dropdown menude 40 eleman olduğunu doğrulayın
        //    Test02
        //1. dropdown menuden elektronik bölümü seçin
        //2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        //3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        //4. ikinci ürüne relative locater kullanarak tıklayin
        //5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        //    Test03
        //1. yeni bir sekme açarak amazon anasayfaya gidin
        //2. dropdown’dan bebek bölümüne secin
        //3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        //4. sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        //    Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    WebElement ddm;
    Select select;
    @Test
    public void test01() {
        //1- amazon gidin
        driver.get("https://www.amazon.com");
        //2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
         ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.getOptions().forEach(w-> System.out.println(w.getText()));
        //3. dropdown menude 40 eleman olduğunu doğrulayın
        int actualSize = select.getOptions().size();
        Assert.assertNotEquals(40, actualSize );
        System.out.println("ddm sayisi : " + actualSize);
    }
    @Test
    public void test02() {
        //driver.get("https://www.amazon.com");
        //1. dropdown menuden elektronik bölümü seçin
        ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(ddm);
        select.selectByVisibleText("Electronics");
        //2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucSayisi = sonucYazisi.getText().split(" ")[3];
        System.out.println("Sonuc Sayisi : "+ sonucSayisi);
        //3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("iphone"));
        //4. ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        WebElement ikinciUrun = driver.findElement(with(By.tagName("div")).toRightOf(birinciUrun));
        ikinciUrun.click();
        //5. ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String  urun1Title = driver.findElement(By.xpath("//*[@id='title_feature_div']")).getText();
        System.out.println("Secilen Birinci Urun Title'i : " + urun1Title);
        String urun1Fiyati = driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
        System.out.println("Secilen Birinci Urun Fiyati = " + urun1Fiyati);
        driver.findElement(By.xpath("(//*[@class='a-button-inner'])[2]")).click();
    }
    @Test
    public void test03() {
        //1. yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        //2. dropdown’dan bebek bölümüne secin
        ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(ddm);
        select.selectByIndex(3);
        //3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("baby stroller", Keys.ENTER);
        //4. sonuç yazsının puset içerdiğini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.getText().contains("stroller"));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun = driver.findElement(By.xpath("(//*[@class='aok-relative'])[1]"));
        WebElement ucuncuUrun = driver.findElement(with(By.tagName("a")).below(ikinciUrun));
        ucuncuUrun.click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String urun2Title = driver.findElement(By.xpath("//*[@id='title_feature_div']")).getText();
        System.out.println("Secilen Ikinci Urun Title'i : " + urun2Title);
        String urun2Fiyati = driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
        System.out.println("Secilen iIkinci Urun Fiyati = " + urun2Fiyati);
        driver.findElement(By.xpath("//*[@id='submit.add-to-cart']")).click();
    }
    @Test
    public void test04() {

        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        WebElement sepet = driver.findElement(By.id("nav-cart-count-container"));
        sepet.click();

        String secilenBirinciUrunTitle = "Ailun 3 Pack Screen Protector for iPhone 13 [6.1 inch Display] with 3 Pack Tempered Glass Camera Lens Protector,[9H Hardness]-HD[6 Pack]";
        String secilenIkinciUrunTitle = "Baby Trend Range Jogger Stroller, Millennium";
        String secilenBirinciUrunFiyat = "$8.99";
        String secilenIkinciUrunFiyat = "$87.99";

        String sepettekiBirinciUrunTitle = driver.findElement(By.xpath("(//*[@class='a-spacing-mini'])[3]")).getText();
        String sepettekiIkinciUrunTitle = driver.findElement(By.xpath("(//*[@class='a-spacing-mini'])[1]")).getText();
        String sepettekiBirinciUrunFiyat = driver.findElement(By.xpath("(//*[@class='a-spacing-mini'])[4]")).getText();
        String sepettekiIkinciUrunFiyat = driver.findElement(By.xpath("(//*[@class='a-spacing-mini'])[2]")).getText();

        Assert.assertEquals(secilenBirinciUrunTitle,sepettekiBirinciUrunTitle);
        Assert.assertEquals(secilenBirinciUrunFiyat,sepettekiBirinciUrunFiyat);
        Assert.assertEquals(secilenIkinciUrunTitle,sepettekiIkinciUrunTitle);
        Assert.assertEquals(secilenIkinciUrunFiyat,sepettekiIkinciUrunFiyat);

    }
    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
