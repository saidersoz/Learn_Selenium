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
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class C02_DropDown {


    /*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    -3 farklı test methodu oluşturalım
        1.Method:
            a. Yil,ay,gün dropdown menu'leri locate ediniz
            b. Select objesi olustur
            c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
            a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws Exception {
       Thread.sleep(1500);
       driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //                 1.Method:
        // a. Yil,ay,gün dropdown menu'leri locate ediniz
        // b. Select objesi olustur
        // c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        Select optionsYear = new Select(year);
        optionsYear.selectByValue("2000"); Thread.sleep(1000);
        //optionsYear.selectByIndex(5); // selectByIndex(5)==> index 0 dan başlar DropDOwn menüde 6.yı alır.

        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select optionsMonth = new Select(month);
        optionsMonth.selectByIndex(4);Thread.sleep(1000);
        //optionsMonth.selectByValue("May"); //selectByValue("May") ==> String olarak değer gireriz onu bulur ve seçer

        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select optionsDay = new Select(day);
        optionsDay.selectByVisibleText("31");Thread.sleep(1000);
    }

    @Test
    public void test02() throws InterruptedException {
        //          2.Method:
        //a. Tüm eyalet isimlerini yazdıralım
        List<WebElement> state = driver.findElements(By.xpath("//select[@id='state']"));

        for (WebElement each : state){
            System.out.println(state.get(0).getText()); Thread.sleep(1500);
        }
    }

    @Test
    public void test03() throws InterruptedException {
        //3.Method:
        //a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement selectAState = driver.findElement(By.xpath("//option[text()='Select a State']"));

        String actualText = selectAState.getText();
        String exceptedText = "Select a State";

        Assert.assertEquals(actualText,exceptedText); Thread.sleep(1500);

        if (actualText.equals(exceptedText)){
            System.out.println("Test Passed ");
        }else {
            System.out.println("Test Failed");
        }

    }
}


















