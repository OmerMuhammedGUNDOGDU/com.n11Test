import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Trendyol {
    @Test
    public void test01(){
        // Tarayıcı Başlat
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.trendyol.com sitesi açılır.
        driver.get("https://www.trendyol.com");

        // Anasayfanın açıldığı kontrol edilir
        WebElement anaSayfa=driver.findElement(By.xpath("//a[@href='https://www.trendyol.com']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //Pop-up kapatılır
        WebElement popUpClose = driver.findElement(By.xpath("//body[@class='gender-popup-lock']"));
        popUpClose.click();

        //Login ekranı açılır
        WebElement singUp = driver.findElement(By.xpath("//p[text()='Giriş Yap']"));
        singUp.click();

        // Login ekranı açıldığı kontrol edilir
        WebElement singUpCheck = driver.findElement(By.xpath("//h3[text()='Trendyol’a giriş yap veya hesap oluştur, indirimleri kaçırma!']"));
        Assert.assertTrue(singUpCheck.isDisplayed());

        // Siteye login olunur.
        WebElement userEmail = driver.findElement(By.xpath("//input[@id='login-email']"));
        userEmail.sendKeys("o.muhammed.gundogdu.test@gmail.com");
        WebElement userPassword = driver.findElement(By.xpath("//input[@id='login-password-input']"));
        userPassword.sendKeys("Blackice1234");

        //Şifre göster.
        //driver.findElement(By.xpath("//i[@class='i-eye-open']")).click();

        // Giriş yap butonuna tıklanır.
        WebElement cliclButton = driver.findElement(By.xpath("//button[@type='submit']"));
        cliclButton.click();




        // Login işlemi kontrol edilir.


        // Iphone kelimesi aranır.


        // Iphone kelimesi aratıldığı kontrol edilir.


        // Arama sonuçları sayfasından 2. sayfa açılır.


        // 2. sayfanın açıldığı kontrol edilir.


        // Sayfadaki 3. ürün favorilere eklenir.


        // Hesabım -&gt; İstek Listem / Favorilerim sayfasına gidilir.


        // “Favorilerim” sayfası açıldığı kontrol edilir.


        // Eklenen ürün favorilerden silinir ve silme işlemi kontrol edilir.


        // Üye çıkış işlemi yapılır.

    }
}
