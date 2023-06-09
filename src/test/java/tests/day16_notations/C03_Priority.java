package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {
    /*
    TestNG test methodlarini isim sirasina gore calistirir.Eger isim siralamasinin disinda
    bir siralama ile calismasini isterseniz o zaman test methodlarini oncelik
    (priority) tanimlayabiliriiz

    Priority kucukten buyuge calisir. eger bir test method unda priority degeri atanmamissa
    default olarak priority=0 kabul edilir.

     */
    @Test(priority = 5)
    public void amazonTesti() {

        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }
    @Test(groups = "grup1")
    public void techproedTesti() {
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }
}
