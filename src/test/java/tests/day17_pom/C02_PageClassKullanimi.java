package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {

    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();

        // Amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        // Nutella aratalim
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // Sonuc yazisinin nutella icerdigini test edelim
        String actualSonuc=amazonPage.aramaSonucElementi.getText();
        String arananKelime="Nutella";
        Assert.assertTrue(actualSonuc.contains(arananKelime));

        Driver.closeDriver();


    }
}
