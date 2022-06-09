        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.Assert;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.time.Duration;

public class Examples {

    @Test
    public void test01() {
        //1. Tarayıcı Başlat
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. 'http://automationexercise.com' sitesi açılır.
        driver.get("http://automationexercise.com");

        //3. Anasayfanın açıldığı kontrol edilir
        WebElement logoElementi= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());

        //4. Login ekranı açılır
        WebElement signUpLinki= driver.findElement(By.xpath("//a[text()=' Signup / Login'] "));
        signUpLinki.click();

        //5. Verify 'Login to your account' is visible
        WebElement loginYaziElementi= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginYaziElementi.isDisplayed());

        //6. Kullanıcı Adı ve Şifre bilgileri girilir
        WebElement emailAdresKutusu= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailAdresKutusu.sendKeys("o.muhammed.gundogdu.test@gmail.com");
        WebElement passwordKutusu= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordKutusu.sendKeys("Blackice1234");

        //7. 'login' buttonuna tıklanır
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Login durumu kontrol edilir
        WebElement loggedInYazisi= driver.findElement(By.xpath("//a[text()=' Logged in as '] "));
        Assert.assertTrue(loggedInYazisi.isDisplayed());

        //9. 'Logout' buttonuna tıklanır
        driver.findElement(By.xpath("//a[text()=' Logout'] ")).click();

        //10. Verify that user is navigated to login page
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        //11. Close driver
        driver.close();
    }
}