package Pages;

import Base.BaseLibrary;
import Base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class LoginPage extends BaseLibrary {

    @Step("Hatalı giriş Kontrolü Sağlanır")
    public LoginPage hataliGirisKontrolu() {
        String value4 = driver.getCurrentUrl();

        Assert.assertTrue(value4.contains("https://www.facebook.com/login/?privacy_mutation_token="));
        screenshot();
        return this;
    }


    @Step("Email Alanı Doldurulur")
    public LoginPage emailDoldur(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
        screenshot();
        return this;
    }

    @Step("Parola Alanı Doldurulur")
    public LoginPage passwordDoldur(String password) {
        driver.findElement(By.id("pass")).sendKeys(password);
        screenshot();
        return this;
    }

    @Step("Giriş Yap Butonuna Tıklanır")
    public LoginPage loginTikla() {
        driver.findElements(By.xpath("//*[contains(text(),'Giriş Yap')]")).get(1).click();
        screenshot();
        return this;
    }

    @Step("Şifremi Unuttum Butonuna Tıklanır")
    public LoginPage sifremiunuttumTikla() {
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Şifreni mi Unuttun?"));
        forgotPasswordLink.click();
        screenshot();
        return this;
    }

    @Step("E-posta adresi {email} girilir")
    public LoginPage sifirlanacakEpostaDoldur(String email) {
        WebElement emailInput = driver.findElement(By.id("identify_email"));
        emailInput.sendKeys(email);
        screenshot();
        return this;
    }

    @Step("Ara butonuna tıklanır")
    public LoginPage araButonaTikla() {
        WebElement araButonu = driver.findElement(By.xpath("//button[@id='did_submit']"));
        araButonu.click();
        screenshot();
        return this;
    }
    @Step("Başka bir yol seç butonuna tıklanır")
    public LoginPage baskaBirYolSecButonaTikla() {
        WebElement baskaBirYolDenemeLinki = driver.findElement(By.xpath("//a[@role='button' and contains(text(), 'Başka bir yol dene')]"));

        baskaBirYolDenemeLinki.click();
        screenshot();
        return this;
    }
    @Step("Eposta ile şifre sıfırlamak için devam butonuna basılır. Ve doğrulama maili gelip gelmediği gözlemlenir.")
    public LoginPage devamButonaTikla() {
        WebElement devamButonu = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/form/div/div[3]/div/div[1]/button"));

        devamButonu.click();
        screenshot();
        return this;
    }


}