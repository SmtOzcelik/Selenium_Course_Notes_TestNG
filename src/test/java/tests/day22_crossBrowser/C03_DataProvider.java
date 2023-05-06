package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {



    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        // amazon ana sayfa git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // nutella icin arama yapalim
        AmazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // sonuclarin nutella icerdigini test edelim
        String expectedSonuc="Nutella";
        String actualSonuc=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        Driver.closeDriver();
    }


    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object[][] arananKelimeArrayi={{"Nutella"},{"Java"},{"cigdem"},{"Netherlands"}};
        return arananKelimeArrayi;
    }


    @Test(dataProvider = "AranacakKelimeler" )
    //arayacagimiz kelimeleri bir liste gibi tutup bana yollayacak bir veri saglayici oluşturacagiz
    public void dataProviderTesti(String arananKelime) {
        AmazonPage amazonPage=new AmazonPage();
        // amazon ana sayfa git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // Nutella,Java, cigdem ve Netherlands icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);

        // sonuclarin aradigimiz kelime icerdigini test edelim
        String expectedSonuc=arananKelime;
        String actualSonuc=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonuc.contains(expectedSonuc));

        // sayfayi kapatalim
        Driver.closeDriver();
    }
}
