package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase2_LoginUserWithCorrectEmailAndPassword {

    //1. Launch browser
    //1. Tarayıcıyı başlatın
    //2. Navigate to url 'http://automationexercise.com'
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Verify that home page is visible successfully
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. Click on 'Signup / Login' button
    //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //5. Verify 'Login to your account' is visible
    //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
    //6. Enter correct email address and password
    //6. Doğru e-posta adresini ve şifreyi girin
    //7. Click 'login' button
    //7. 'Giriş' düğmesine tıklayın
    //8. Verify that 'Logged in as username' is visible
    //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
    //9. Click 'Delete Account' button
    //9. 'Hesabı Sil' düğmesini tıklayın
    //10. Verify that 'ACCOUNT DELETED!' is visible
    //10. 'HESAP SİLİNDİ!' görünür


    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement sayfa = driver.findElement(By.xpath("//div[@class='container']"));
        if (sayfa.isDisplayed()){
            System.out.println("Ana sayfanın başarıyla göründüğünü doğrulayın (TEST PASSED)");
        }else {
            System.out.println("Ana sayfanın başarıyla göründüğünü doğrulayın (TEST FAILED)");
        }

        //4. Click on 'Signup / Login' button
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click(); Thread.sleep(1000);

        //5. Verify 'Login to your account' is visible
        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        WebElement newUserSignUp = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        String actual = newUserSignUp.getText();
        String excepted = "Login to your account";
        Assert.assertEquals(actual,excepted);Thread.sleep(1000);

        //6. Enter correct email address and password
        //6. Doğru e-posta adresini ve şifreyi girin
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("m.said.ersoz3443@gmail.com"); Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("said3461"); Thread.sleep(1000);

        //7. Click 'login' button
        //7. 'Giriş' düğmesine tıklayın
        WebElement login2 = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        login2.click(); Thread.sleep(1000);

        //8. Verify that 'Logged in as username' is visible
        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        String actualUserName = loggedInAsUsername.getText();
        String exceptedUserName = "Logged in as said";

        if (actualUserName.equals(exceptedUserName)){
            System.out.println("Logged in as said (TEST PASSED)");
        }else {
            System.out.println("Logged in as said (TEST FAIL)");
        }Thread.sleep(1000);
        //9. Click 'Delete Account' button
        //9. 'Hesabı Sil' düğmesini tıklayın
        WebElement deleteAccount = driver.findElement(By.xpath("//a[text()=' Delete Account']"));
        deleteAccount.click(); Thread.sleep(1500);

        //10. Verify that 'ACCOUNT DELETED!' is visible
        //10. 'HESAP SİLİNDİ!' görünür
        WebElement delete = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        if (delete.isDisplayed()){
            System.out.println("ACCOUNT DELETED! (TEST PASSED)");
        }else {
            System.out.println("ACCOUNT DELETED! (TEST FAIL)");
        }

    }
}
