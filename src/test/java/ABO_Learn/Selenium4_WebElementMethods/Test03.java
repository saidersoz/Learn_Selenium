package ABO_Learn.Selenium4_WebElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Test03 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.bestbuy.com adresine gidin
        driver.get("https://www.bestbuy.com");
        Thread.sleep(2000);

        //cookies cıkarsa kabul edin


        //sayfada kaç adet button bulunduğunu yazdırın
        List <WebElement> buttonList = driver.findElements(By.tagName("button"));
        System.out.println(buttonList.size());
        Thread.sleep(2000);

        //sayfada ki her bir button üzerinde ki yazıları yazdırın
        for (WebElement each : buttonList){
            System.out.println(each.getText());
        }
        Thread.sleep(2000);

        driver.close();


    }

}
