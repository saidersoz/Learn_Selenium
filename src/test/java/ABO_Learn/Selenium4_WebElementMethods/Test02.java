package ABO_Learn.Selenium4_WebElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Test02 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);

        //cookies çıkarsa kabul et butonuna basın
        //e-posa kutusuna rastgele bir mail girin
        WebElement email =  driver.findElement(By.xpath("//input[@class='inputtext _55r1 _6luy']"));
        email.sendKeys("msefgedsf@gmail.com");
        Thread.sleep(2000);

        //şifre kısmına rastgele bir şifre girin
        WebElement sifre =  driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        sifre.sendKeys("qwertujmdlg6431ef4");
        Thread.sleep(2000);

        //giriş yap butonuna basın
        WebElement login = driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']"));
        login.click();
        Thread.sleep(2000);

        //uyarı olarak "The email or mobile number you entered isn't connected to an account to an account. Find yor account"
        //             mesajınının çıktısını test edin
        WebElement uyariMesaji = driver.findElement(By.xpath("//div[@class='_9ay7']"));
        System.out.println(uyariMesaji.getText());
        Thread.sleep(2000);


        //sayfayı kapatın
        driver.close();

        System.out.println("Çalışıyor Sorun Yok :))))");


    }

}
