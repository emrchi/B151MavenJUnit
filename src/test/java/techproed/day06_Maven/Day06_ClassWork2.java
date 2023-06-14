package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_ClassWork2 {

//    "https://www.saucedemo.com" Adresine gidin
//    Username kutusuna "standard_user" yazdirin
//    Password kutusuna "secret_sauce" yazdirin
//    Login tusuna basin
//    Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
//    Add to Cart butonuna basin
//    Alisveris sepetine tiklayin
//    Sectiginiz urunun basarili olarak sepete eklendigini control  edin
//    Sayfayi kapatin

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //    Username kutusuna "standard_user" yazdirin
        //    Password kutusuna "secret_sauce" yazdirin
        //    Login tusuna basin
        WebElement usernameBox = driver.findElement(By.xpath("(//*[@class='input_error form_input'])[1]"));
        usernameBox.sendKeys("standard_user", Keys.TAB,"secret_sauce",Keys.ENTER);
        Thread.sleep(2000);

        //    Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.id("item_4_title_link"));
        System.out.println(ilkUrun.getText());
        ilkUrun.click();

        //    Add to Cart butonuna basin
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);

        //    Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_badge")).click();
        Thread.sleep(2000);

        //    Sectiginiz urunun basarili olarak sepete eklendigini control  edin
        if(driver.findElement(By.className("inventory_item_name")).isDisplayed()){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

        //    Sayfayi kapatin
        driver.close();







    }
}
