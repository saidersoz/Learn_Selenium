package KarisikSelenium;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Test03 extends TestBase {

    @Test
    public void test01() {
        //● Tests package’inda yeni bir class olusturun: WindowHandle
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String text1 = driver.getPageSource();
        Assert.assertTrue(text1.contains("Opening a new window"));
        bekle(2);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("The Internet"));
        bekle(2);
        //● Click Here butonuna basın.
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click(); bekle(2);



        List<String> olusturulanPencereler = new ArrayList<>(driver.getWindowHandles());




        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(olusturulanPencereler.get(1));
        String pagetitle2 = driver.getTitle();
        Assert.assertTrue(pagetitle2.contains("New Window")); bekle(2);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String page2 = driver.getPageSource();
        Assert.assertTrue(page2.contains("New Window"));
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.
        driver.switchTo().window(olusturulanPencereler.get(0));
        String page3 = driver.getTitle();
        Assert.assertTrue(page3.contains("The Internet"));
    }
}
