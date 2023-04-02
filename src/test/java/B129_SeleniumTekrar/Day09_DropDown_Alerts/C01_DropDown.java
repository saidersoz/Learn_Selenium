package B129_SeleniumTekrar.Day09_DropDown_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {

    /*
    DropDown nedir ==> Alt başlıkların olduğun açılır menü listesi.
    DropDown nasıl automate edilir(Handle) ==>
            a - DropDown menü'yü ilk olarak locate ederiz.
            b - Select objesi oluştururuz
            c - Select objesi'nin DropDown menü WebElement'ini içeriğine ve seçeneklerine
                       erişim sağlaması için Select sınıfına arguman olarak locate ettiğimiz WebElement'i koyarız
                       Syntax : Select select = new Select(DropDown menü WebELement);
            d - Select class'ı, sadece <select> tag'ı ile oluşturulmuş DropDown menülere uygulanabilir.
            e - Select Objesi ile DropDown'y üHandle edebilmek için 3 method kullanılır.
                     e.1 - selectByVisibleText() -> Ddm deki elemente görünür metin ile ulaşmak için kullanılır.
                     e.2 - selectByIndex() -> Index ile ulaşmak için kullanılır(Index 0 dan başlar).
                     e.3 - selectByValue() -> Elementin değeri ile ulaşmak için kullanılır(option tag'ındaki değer ile).
            f - getOptions() ==> Locate ettiğimiz ddm'de ki tüm seçenekleri bize getirir.
            g - getFirstSelectedOptions() ==> DDM'de ki en son seçli kalan ilk seçeneği bize getirir.
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

    @Test
    public void test02() {
        /*
        //a. Tüm eyalet isimlerini yazdıralım
        WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        List<WebElement> stateList = select.getOptions();//Bütün options taglarını getir
        //for (WebElement w:stateList) {
        //    System.out.println(w.getText());
        // }
        stateList.forEach(t-> System.out.println(t.getText()));
         */

        //a. Tüm eyalet isimlerini yazdıralım
        List<WebElement> tumEyaletler = driver.findElements(By.xpath("//select[@id='state']//option"));
        System.out.println(tumEyaletler.get(2).getText());
        System.out.println("*********");
        tumEyaletler.forEach(t-> System.out.println(t.getText()));

        //b. sayfada ki tüm ddm lerde ki tüm seçenekleri(option) konsolda yazdırınız
        System.out.println("*********");
        List<WebElement> tumSecenekler = driver.findElements(By.tagName("option"));
        tumSecenekler.forEach(t-> System.out.println(t.getText()));

    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}