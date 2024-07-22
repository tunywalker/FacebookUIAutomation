import Base.BaseTest;
import Pages.*;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest {
    RegisterPage registerPage= new RegisterPage();
    HomePage homePage= new HomePage();

    @Test(description = "Fake Ad Soyad Algılama Kontrol")
    public void yanlisAdSoyadKontrolu() throws InterruptedException {
    homePage.kayitOlButonunaTikla();
    sleep(2000);
    registerPage.adGirisi(firstName);
    registerPage.soyadGirisi(lastName);
    registerPage.telefonEmailGirisi(wrongEmail);
    registerPage.tekrarEmailGirisi(wrongEmail);
    registerPage.sifreGirisi(password);
    registerPage.gunSecimi(birthDate[0]);
    registerPage.ayGirisi(birthDate[1]);
    registerPage.yilGirisi(birthDate[2]);
    registerPage.cinsiyetSecimi(gender);
    registerPage.kaydolButonunaTikla();
    sleep(3000);
    registerPage.fakeAdSoydHataMesajiniKontrolEt(fakeNameDetectionErrorMessage);


    }
}