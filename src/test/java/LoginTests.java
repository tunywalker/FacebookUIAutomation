import Base.BaseTest;
import Pages.*;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Test(description = "Kullanıcı adı ve şifre ile başarılı giriş")
    public void DogruBilgilerleGirisYap() throws InterruptedException {
        loginPage
                .emailDoldur(email)
                .passwordDoldur(password)
                .loginTikla();
        sleep(3000);
        homePage.homepageKontrol();

    }

    @Test(description = "Hatalı kullanıcı adı veya şifre ile başarısız giriş denemesi")
    public void YanlisBilgilerleGirisYap() throws InterruptedException {
        loginPage
                .emailDoldur(wrongEmail)
                .passwordDoldur(password)
                .loginTikla();
        sleep(3000);
        loginPage
                .hataliGirisKontrolu();

    }


    @Test(description = "\t\"Şifremi Unuttum\" bağlantısı ile E-Posta kullanarak şifre sıfırlama")
    public void epostaSifreSifirla() throws InterruptedException {
        loginPage
                .sifremiunuttumTikla();
        sleep(2000);
        loginPage
                .sifirlanacakEpostaDoldur(email)
                .araButonaTikla();
        sleep(2000);
        loginPage
                .baskaBirYolSecButonaTikla()
                .devamButonaTikla();
    }

}
