package B129_SeleniumTekrar.Day07_Junit_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C03_BeforeAfter {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.techproeducation.com/");
    }

    @Test
    public void test02() {
        driver.get("https://www.google.com/");
    }

}