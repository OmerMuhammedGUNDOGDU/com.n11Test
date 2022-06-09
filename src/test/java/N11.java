import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class N11 {

    @Test
    public void test01(){
        // Tarayıcı Başlat
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // www.n11.com sitesi açılır.
        driver.get("https://www.n11.com");

        // Anasayfanın açıldığı kontrol edilir
        WebElement anaSayfa=driver.findElement(By.xpath("//a[@href='https://www.n11.com']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //Login ekranı açılır
        WebElement singUp = driver.findElement(By.xpath("//a[@href='https://www.n11.com/giris-yap']"));
        singUp.click();

        // Login ekranı açıldığı kontrol edilir
        WebElement singUpCheck = driver.findElement(By.xpath("//h2[text()='Giriş Yap']"));
        Assert.assertTrue(singUpCheck.isDisplayed());

        // Siteye login olunur.
        WebElement userEmail = driver.findElement(By.xpath("//input[@data-validation='required email']"));
        userEmail.sendKeys("o.muhammed.gundogdu.test@gmail.com");
        WebElement userPassword = driver.findElement(By.xpath("//input[@data-validation='required minlength maxlength']"));
        userPassword.sendKeys("Blackice1234");

        //Şifre göster.
        //driver.findElement(By.xpath("//div[@class='showPass']")).click();

        // Giriş yap butonuna tıklanır.
        WebElement cliclButton = driver.findElement(By.xpath("//div[@class='green_flat']"));
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
