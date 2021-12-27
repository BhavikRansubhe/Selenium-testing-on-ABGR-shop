import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class ABGRFruitAndVeggiesShop {

    public static WebDriver driver;
    public static String email = "master";
    public static String password = "1234";

    @BeforeClass
    public void setup() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:\\BE SEM 1\\STQA\\Fruit&VeggiesShop[Website]\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://abgr-shop.000webhostapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
