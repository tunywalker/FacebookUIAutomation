package Pages;

import Base.BaseLibrary;
import Base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

public class RegisterPage extends BaseLibrary {

    @Step("Ad Girişi")
    public RegisterPage adGirisi(String firstName) {
        WebElement nameInput = driver.findElement(By.cssSelector("[name=\"firstname\"]"));
        nameInput.sendKeys(firstName);

        // First name'in başarılı bir şekilde girilip girilmediğini kontrol et
        String enteredFirstName = nameInput.getAttribute("value");
        Assert.assertEquals("First name alanına girilen değer beklenen değerden farklı!",firstName,enteredFirstName );

        screenshot();
        return this;
    }

    @Step("Soyad Girişi")
    public RegisterPage soyadGirisi(String lastName) {
        WebElement lastnameInput = driver.findElement(By.cssSelector("[name=\"lastname\"]"));
        lastnameInput.sendKeys(lastName);
        String enteredLastName = lastnameInput.getAttribute("value");
        Assert.assertEquals("Last First name alanına girilen değer beklenen değerden farklı!",lastName,enteredLastName );
        screenshot();
        return this;
    }

    @Step("Eposta Adresi Veya Telefon Numarası Girişi")
    public RegisterPage telefonEmailGirisi(String emailOrPhoneNumber)
    {
        WebElement emailOrPhoneNumberInput = driver.findElement(By.cssSelector("[name=\"reg_email__\"]"));
        emailOrPhoneNumberInput.sendKeys(emailOrPhoneNumber);
        String enteredemailOrPhoneNumber = emailOrPhoneNumberInput.getAttribute("value");
        Assert.assertEquals("Eposta veya telefon  alanına girilen değer beklenen değerden farklı!",emailOrPhoneNumber,enteredemailOrPhoneNumber );
        screenshot();
        return this;
    }

    @Step("Eposta Adresini Tekrar Gir")
    public RegisterPage tekrarEmailGirisi(String emailOrPhoneNumber)
    {
        WebElement emailOrPhoneNumberInput = driver.findElement(By.cssSelector("[name=\"reg_email_confirmation__\"]"));
        emailOrPhoneNumberInput.sendKeys(emailOrPhoneNumber);
        String enteredemailOrPhoneNumber = emailOrPhoneNumberInput.getAttribute("value");
        Assert.assertEquals("Eposta veya telefon alanına girilen değer beklenen değerden farklı!",emailOrPhoneNumber,enteredemailOrPhoneNumber );
        screenshot();
        return this;
    }



    @Step("Şifre Girişi")
    public RegisterPage sifreGirisi(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[name=\"reg_passwd__\"]"));
        passwordInput.sendKeys(password);
        String enteredPassword = passwordInput.getAttribute("value");
        Assert.assertEquals("Şifre alanına girilen değer beklenen değerden farklı!", password.trim(), enteredPassword.trim());
        screenshot();
        return this;
    }

    @Step("Gün Seçimi Yap")
    public RegisterPage gunSecimi(String day) {
        WebElement daySelect = driver.findElement(By.cssSelector("[name=\"birthday_day\"]"));
        Select select = new Select(daySelect);
        select.selectByValue(day);
        String selectedDay = select.getFirstSelectedOption().getAttribute("value");
        Assert.assertEquals("Gün seçimi beklenen değerden farklı!", day.trim(), selectedDay.trim());
        screenshot();
        return this;
    }

    @Step("Ay Seçimi Yap")
    public RegisterPage ayGirisi(String month) {
        WebElement monthSelect = driver.findElement(By.cssSelector("[name=\"birthday_month\"]"));
        Select select = new Select(monthSelect);
        select.selectByVisibleText(month);
        String selectedMonth = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Ay seçimi beklenen değerden farklı!", month.trim(), selectedMonth.trim());
        screenshot();
        return this;
    }

    @Step("Yıl Seçimi Yap")
    public RegisterPage yilGirisi(String year) {
        WebElement yearSelect = driver.findElement(By.cssSelector("[name=\"birthday_year\"]"));
        Select select = new Select(yearSelect);
        select.selectByVisibleText(year);
        String selectedYear = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Yıl seçimi beklenen değerden farklı!", year.trim(), selectedYear.trim());
        screenshot();
        return this;
    }

    @Step("Cinsiyet Seçimi Yap")
    public RegisterPage cinsiyetSecimi(String gender) {
        WebElement selectedRadioButton = null;
        String genderId;
        switch (gender) {
            case "Kadın":
                selectedRadioButton = driver.findElement(By.cssSelector("input[value='1']"));
                genderId = "1";
                break;
            case "Erkek":
                selectedRadioButton = driver.findElement(By.cssSelector("input[value='2']"));
                genderId = "2";
                break;
            case "Özel":
                selectedRadioButton = driver.findElement(By.cssSelector("input[value='-1']"));
                genderId = "-1";
                break;
            default:
                throw new IllegalArgumentException("Geçersiz cinsiyet: " + gender);
        }
        if (selectedRadioButton != null) {
            selectedRadioButton.click();
            String selectedValue = selectedRadioButton.getAttribute("value");
            Assert.assertEquals("Seçilen cinsiyet beklenen değerden farklı!", genderId, selectedValue);
            screenshot();
        }
        return this;
    }

    @Step("Kaydol Butonuna Tıkla")
    public RegisterPage kaydolButonunaTikla() {
        WebElement kaydolButton = driver.findElement(By.name("websubmit"));
        kaydolButton.click();
        screenshot();
        return this;
    }

    @Step("Hata Mesajını Kontrol Et")
    public RegisterPage fakeAdSoydHataMesajiniKontrolEt(String expectedMessage) {
        WebElement errorDiv = driver.findElement(By.id("reg_error"));
        String actualMessage = errorDiv.getText().trim();
        Assert.assertTrue("Hata mesajı beklenen değeri içermiyor!", actualMessage.contains(expectedMessage));
        screenshot();
        return this;
    }

}