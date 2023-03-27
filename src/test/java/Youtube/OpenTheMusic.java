package Youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Key;
import java.time.Duration;

public class OpenTheMusic {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.youtube.com/");
        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.cssSelector("input[autocapitalize='none']"));
        searchButton.sendKeys("Stressed out");
        searchButton.submit();
        Thread.sleep(2000);

        WebElement firstMusic = driver.findElement(By.xpath("(//div[@id='dismissible'])[1]"));
        firstMusic.click();
        Thread.sleep(3500);

        driver.close();
    }

}
