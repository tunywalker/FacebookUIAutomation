package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseLibrary {
    @Step("Kayıt Ol Butonuna Tıkla")
    public HomePage kayitOlButonunaTikla() {
        // XPath ile butonu bulun
        WebElement registerButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"));
        registerButton.click();
        return this;
    }

    @Step("Home Page Alanı Görüntüleme Kontrolü")
    public HomePage homepageKontrol()
    {
        String currentUrl = driver.getCurrentUrl();
        screenshot();
        Assert.assertEquals("https://www.facebook.com/?sk=welcome", currentUrl);
        return this;
    }
}