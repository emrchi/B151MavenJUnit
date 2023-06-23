package techproed.day13_Cookies_Actions;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.utilities.TestBase;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie'leri listeleyin
        /*
        Cookie'leri listelemek istersek
            driver.manage().getCookies() methodu ile bir Set ya da ArraList'e atarak listeyebiliriz
        */
        //Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);   --> Lambda ile

        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie w : cookieSet) {
            System.out.println(sayac + ". cookie : " + w);
            System.out.println(sayac + ". cookieName : " + w.getName()); //--> Sadece Cookie'lerin isimlerini aliriz
            System.out.println(sayac + ". cookieValue : " + w.getValue()); //--> Sadece Cookie'lerin Value'lerini  aliriz
            sayac++;
        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookie'lerin sayisi : " + cookieSet.size());
        Assert.assertTrue(cookieSet.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        //getCookieNamed() methodu ile bize verilen cookie isminin getValue() methoduyla gerçek değerini actualCookieValue değişkenine assing ettik
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookie);
        cookieSet = driver.manage().getCookies();  //Ekledikten  sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz

        //6-eklediginiz cookie'nin sayfaya eklendigini test edin
        Assert.assertEquals("cikolatali", driver.manage().getCookieNamed("en sevdigim cookie").getValue());

        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        int silinmedenOnce = cookieSet.size();
        System.out.println("Silinmeden Once Cookie'lerin sayisi : " + silinmedenOnce);
        driver.manage().deleteCookieNamed("skin");
        cookieSet = driver.manage().getCookies();   //Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        int silindiktenSonra = cookieSet.size();
        System.out.println("Silindikten Sonra Cookie'lerin sayisi : " + silindiktenSonra);
        Assert.assertEquals(1,silinmedenOnce - silindiktenSonra);

        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());
    }
}
