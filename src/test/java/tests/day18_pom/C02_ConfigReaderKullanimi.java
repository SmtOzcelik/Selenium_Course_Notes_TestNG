package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {
    @Test
    public void test01() {
        FacebookPage facebookPage=new FacebookPage();
        // facebook anasayfa gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        // kullanici mail kutusuna yanilis kullanici adi yazdirin
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));

        // kullanici sifre kutusuna yanilis  password yazdirin
        facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        // login butonuna basin
        facebookPage.loginTusu.click();
        // giris yapilmadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        //sayfayi kapatin
        Driver.closeDriver();

    }
}
