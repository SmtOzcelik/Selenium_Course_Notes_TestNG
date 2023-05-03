package tests.day19_somokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTesti {
    BrcPage brcPage=new BrcPage();

    @Test
    public void yanlisSifre() {
        // Bir test method olustur positiveLoginTest()
        // https://bluerentalcars.com git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // login butonuna bas
        brcPage.ilkLoginButonu.click();
        // test data username:smt@gmail.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        // test data password:54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        // login butonuna tikla
        brcPage.ikinciLoginButtonu.click();
        // Degerler girildiginde sayfaya basarili sekilde girilemedigini test et

        Assert.assertTrue(brcPage.ikinciLoginButtonu.isDisplayed());
        Driver.closeDriver();
    }
}
