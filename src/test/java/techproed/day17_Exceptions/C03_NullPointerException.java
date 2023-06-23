package techproed.day17_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_NullPointerException  {

    /*
     NULL_POINTER_EXCEPTION
           Obje yada değişken oluşturup bunlara atama yapmadığımız zaman direk oluşturmuş olduğumuz
        obje yada değişkeni kullanmak istersek nullPointerException hatasi alırız.
      */
    WebDriver driver;
    Faker faker;
    Actions actions;
    int sayi;
    String name;

    @Test
    public void test01() {
        /*
        driver = new ChromeDriver(); normalde bu atamayı yapmamız gerekir. Bu atamayı yapmadığımız taktirde yada
        unuttuğumuz zaman nullpointerexception hatası alırız
         */
        driver.get("https://amazon.com");//-->java.lang.NullPointerException
    }

    @Test
    public void test02() {
        //faker = new Faker();
        System.out.println(faker.name().fullName());//-->java.lang.NullPointerException
    }

    @Test
    public void test03() {

    }
}
