package tests.day21_reusableMethods_HtmReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Ç03_PozitifLoginTestiRaporlu extends TestBaseRapor {
    BrcPage brcPage=new BrcPage();
    @Test
    public void test01() {
        // Acagidaki extentTest deger atamasini her seferinde yapiyoruz
        extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giris yapabilmeli");

        // Bir test method olustur positiveLoginTest()
        // https://bluerentalcars.com git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");

        // login butonuna bas
        brcPage.ilkLoginButonu.click();
        extentTest.info("login butonuna tiklanidi");

        // test data username:smt@gmail.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi");

        // test data password:12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli password yazildi");

        // login butonuna tikla
        brcPage.ikinciLoginButtonu.click();
        extentTest.info("Login butonuna basildi");

        // Degerler girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName=brcPage.kullaniciProfilIsmi.getText();
        String expectedUserName=ConfigReader.getProperty("brcValidUserName");
        Assert.assertEquals(expectedUserName,actualUserName);
        extentTest.pass("kullanici basarili sekilde giris yapti");

        Driver.closeDriver();
    }
}
