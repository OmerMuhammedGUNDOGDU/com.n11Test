import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class N11 {
    WebDriver driver;
    @Before
    public void setUp(){
        //1- Tarayıcı Başlat
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //2- www.n11.com sitesi açılır.
        driver.get("https://www.n11.com");

        //3- Anasayfanın açıldığı kontrol edilir
        WebElement anaSayfa = driver.findElement(By.xpath("//a[@href='https://www.n11.com']"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //4- Login ekranı açılır
        WebElement singUp = driver.findElement(By.xpath("//a[@href='https://www.n11.com/giris-yap']"));
        singUp.click();

        //5- Login ekranı açıldığı kontrol edilir
        WebElement singUpCheck = driver.findElement(By.xpath("//h2[text()='Giriş Yap']"));
        Assert.assertTrue(singUpCheck.isDisplayed());

        //6- Siteye login olunur.
        WebElement userEmail = driver.findElement(By.xpath("//input[@data-validation='required email']"));
        userEmail.sendKeys("o.muhammed.gundogdu.test@gmail.com");
        WebElement userPassword = driver.findElement(By.xpath("//input[@data-validation='required minlength maxlength']"));
        userPassword.sendKeys("Blackice1234");

        //7- Şifre göster.
        driver.findElement(By.xpath("//div[@class='showPass']")).click();

        //8- Giriş yap butonuna tıklanır.
        WebElement clickButton = driver.findElement(By.xpath("//div[@class='green_flat']"));
        clickButton.click();

        //9- Login işlemi kontrol edilir.
        WebElement clickCheck = driver.findElement(By.xpath("//a[@class='menuLink user']"));
        Assert.assertTrue(clickCheck.isDisplayed());

        //10- Iphone kelimesi aranır.
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchData']"));
        searchBox.sendKeys("IPHONE");
        driver.findElement(By.xpath("//a[@class='searchBtn']")).click();

        //11- Iphone kelimesi aratıldığı kontrol edilir.
        WebElement searchResult = driver.findElement(By.xpath("//div[@class='resultText ']"));
        Assert.assertTrue(searchResult.isDisplayed());

        //12- Arama sonuçları sayfasından 2. sayfa açılır.
        driver.findElement(By.xpath("//a[text()='2']")).click();

        //13- 2. sayfanın açıldığı kontrol edilir.
        WebElement pageCheck = driver.findElement(By.xpath("//a[@href='https://www.n11.com/arama?q=IPHONE&pg=2']"));
        Assert.assertTrue(pageCheck.isDisplayed());

        //14- Sayfadaki 3. ürün favorilere eklenir.
        WebElement favorite = driver.findElement(By.xpath("//span[@data-controlformid='addToWatchlistForm527733944']"));
        favorite.click();

        //15- Hesabım > İstek Listem / Favorilerim sayfasına gidilir.
        WebElement favoriList = driver.findElement(By.xpath("//a[@title='Favorilerim / Listelerim']"));
        favoriList.click();

        //16- “Listem / Favorilerim” sayfası açıldığı kontrol edilir.
        WebElement favoriListCheck = driver.findElement(By.xpath("//h2[text()='Favorilerim / Listelerim']"));
        Assert.assertTrue(favoriListCheck.isDisplayed());

        //17- Favorilerim sayfasına gidilir.
        driver.findElement(By.xpath("//h4[text()='Favorilerim (1)']")).click();

        //18- Favorilerim sayfasına gidildiği kontrol edilir.
        WebElement myFavorite = driver.findElement(By.xpath("//h2[text()='Favorilerim']"));
        Assert.assertTrue(myFavorite.isDisplayed());

        //18- Eklenen ürün favorilerden silinir ve silme işlemi kontrol edilir.
        WebElement deletefavorite = driver.findElement(By.xpath("//span[@class='deleteProFromFavorites']"));
        deletefavorite.click();

        //19- PopUp kapatma
        driver.findElement(By.xpath("//span[@class='btn btnBlack confirm']")).click();

        //20- Favorilerden silinen ürün sonrası kontrol işlemi
        WebElement sonuc = driver.findElement(By.xpath("//div[text()='İzlediğiniz bir ürün bulunmamaktadır.']"));
        Assert.assertTrue(sonuc.isDisplayed());

        //21- Üye çıkış işlemi yapılır.
        driver.close();

    }
}
