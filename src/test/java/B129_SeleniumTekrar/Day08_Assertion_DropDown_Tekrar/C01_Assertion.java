package B129_SeleniumTekrar.Day08_Assertion_DropDown_Tekrar;

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

import static org.junit.Assert.assertTrue;

public class C01_Assertion {

    /*
        1)https://amazon.com adresinegidin
        2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
        ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
        ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
        */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void titleTest() {
        //○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void imageTest() {
        //○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void searchBox() {
        //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest() {
        //○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
        Assert.assertFalse(driver.getTitle().contains("amazon"));

        //2.yol
        //String actualTitle = driver.getTitle();
        //String expectedTitle = "amazon";
        //Assert.assertFalse(actualTitle.contains(expectedTitle));

    }

}
