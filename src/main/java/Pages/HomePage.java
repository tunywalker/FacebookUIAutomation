package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends BaseLibrary {
    @Step("Home Page Alanı Görüntüleme Kontrolü")
    public HomePage homepageKontrol()
    {
        String currentUrl = driver.getCurrentUrl();
        screenshot();
        Assert.assertEquals("https://www.facebook.com/?sk=welcome", currentUrl);
        return this;
    }
}