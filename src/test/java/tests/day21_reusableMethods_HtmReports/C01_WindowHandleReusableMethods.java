package tests.day21_reusableMethods_HtmReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/windows adresine git
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandle=Driver.getDriver().getWindowHandle();
        // Click Here tusuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String>windowHandleSeti=Driver.getDriver().getWindowHandles();
        String ikinciSayfaWindowHandle="";

        for (String each:windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandle=each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWindowHandle);
        System.out.println(Driver.getDriver().getTitle());
        // acilan yeni tab in title nin "New Window" old. test edin
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @Test
    public void test02() {
        // https://the-internet.herokuapp.com/windows adresine git
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        // Click Here tusuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        // acilan yeni tab in title nin "New Window" old. test edin
        ReusableMethods.switchToWindow("New Window");
        String expectedTitle="New Window";

        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();

    }
}
