package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    /*
    POM de Driver icin TestBase classina extends etmek yerine Driver class indan
    static methodlar kullanarak driver olusturup, ilgili ayarlarin yapilmasi
    ve en sonda driver in kapatilmasi tercih edilmiştir
     */
    static WebDriver driver;
    public static WebDriver getDriver(){

        if (driver == null) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }

    }
}
