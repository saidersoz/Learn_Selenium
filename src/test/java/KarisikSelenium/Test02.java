package KarisikSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class Test02 {

    /*
    -Amazon sayfasına gidelim
    -Arama Kutusundaki Dropdown menuyu yazdıralım
    -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
    Not: Select Class'ı kullanalım
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);
        driver.close();
    }

    @Test
    public void test01() {
        List<WebElement> all = driver.findElements(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        for (int i = 0; i <29 ; i++) {
            System.out.println(all.get(i).getText());
        }


    }
}
