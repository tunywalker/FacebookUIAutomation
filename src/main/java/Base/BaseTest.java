package Base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {
    //Deneme amaçlıdır !
    //MainPage mainPage = new MainPage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}