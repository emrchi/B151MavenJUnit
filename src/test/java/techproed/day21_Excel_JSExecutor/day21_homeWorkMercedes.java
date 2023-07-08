package techproed.day21_Excel_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import static org.openqa.selenium.Keys.TAB;

public class day21_homeWorkMercedes extends TestBase {
    @Test
    public void mercedesTest() {
        // https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE sayfasina gidelim
        driver.get("http://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE");
        bekle(2);
        //Cikan cookie'i kapatalim
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB,Keys.ENTER).perform();
    }



}
