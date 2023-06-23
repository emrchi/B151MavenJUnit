package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C04_Faker  {

    @Test
    public void faker() {
        /*
        Faker Class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir.
         */

        Faker faker = new Faker();

        //faker objesini kullanarak bir isim yazdiriniz
        System.out.println("Isim : " + faker.name().firstName());

        //faker objesini kullanarak bir lastName yazdiriniz
        System.out.println("SoyIsim : " + faker.name().lastName());

        //faker objesini kullanarak bir fullName yazdiriniz
        System.out.println("FullName : " + faker.name().fullName());

        //faker objesini kullanarak bir adres yazdiriniz
        System.out.println("Adres : " + faker.address().fullAddress());

        //faker objesini kullanarak bir tel_no yazdiriniz
        System.out.println("Tel_No :" + faker.phoneNumber().cellPhone());

        //Rastgele 15 haneli bir numara yazdiralim
        System.out.println("15 Haneli Numara :" + faker.number().digits(15));

        //Mestlek pozisyonu
        System.out.println(faker.job().position());
    }
}
