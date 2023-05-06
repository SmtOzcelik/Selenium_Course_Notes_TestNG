package tests.day21_reusableMethods_HtmReports;

import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_ScreenShotWebElementReusableMethod {
    @Test
    public void test01() throws IOException {
        // amazon sayfasina gidip aramaKutusunun fotosunu aliniz
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.getScreenshotWebElement("amazonAramaKutusu",AmazonPage.aramaKutusu);

    }
}
