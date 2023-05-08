package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {
    BrcPage brcPage=new BrcPage();

    @DataProvider
    public static Object[][] kullaniciListesi() {
        Object[][] kullaniciBilgileri={{"firuze@nehaber.com","5879"},{"murat@mail","12345"},{"samet@gelidi","1245678"}};

        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void yanlisSifre(String userEmail,String password) {
        // Bir test method olustur positiveLoginTest()
        // https://bluerentalcars.com git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // login butonuna bas
        brcPage.ilkLoginButonu.click();
        // test data username:dataprovider den alallim
        brcPage.emailTextBox.sendKeys(userEmail);
        // test data password:dataprovider den alallim
        brcPage.passwordTextBox.sendKeys(password);
        // login butonuna tikla
        brcPage.ikinciLoginButtonu.click();
        // Degerler girildiginde sayfaya basarili sekilde girilemedigini test et

        Assert.assertTrue(brcPage.ikinciLoginButtonu.isDisplayed());
        Driver.closeDriver();
    }

}
