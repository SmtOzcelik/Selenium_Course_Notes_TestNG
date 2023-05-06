package tests.day21_reusableMethods_HtmReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Ç03_PozitifLoginTestiRaporlu {
    BrcPage brcPage=new BrcPage();
    @Test
    public void test01() {

        // Bir test method olustur positiveLoginTest()
        // https://bluerentalcars.com git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // login butonuna bas

        brcPage.ilkLoginButonu.click();
        // test data username:smt@gmail.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        // test data password:12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        // login butonuna tikla
        brcPage.ikinciLoginButtonu.click();
        // Degerler girildiginde sayfaya basarili sekilde girilebildigini test et

        String actualUserName=brcPage.kullaniciProfilIsmi.getText();
        String expectedUserName=ConfigReader.getProperty("brcValidUserName");
        Assert.assertEquals(expectedUserName,actualUserName);

        Driver.closeDriver();
    }
}
