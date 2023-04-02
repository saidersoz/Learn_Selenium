package B129_SeleniumTekrar.Day09_DropDown_Alerts;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C03_Alerts extends TestBase {

    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */


    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo(). //Geçmek,Değiştirmek
                alert().   //Alert'e geçiş yaptı
                accept(); //Çıkan uyarı da OK veya Tamam' basar
        Thread.sleep(3000);

        //result mesajının  “You successfully clicked an alert” oldugunu test edin.
        String actualTest = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedTest = "You successfully clicked an alert";

        Assert.assertTrue(actualTest.contains(expectedTest));

        System.out.println("acceptAlert() Test PASSED");
        Thread.sleep(1500);
    }

    @Test
    public void dismissAlert() throws InterruptedException {
        //Bir metod olusturun: dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();Thread.sleep(3000);
        driver.switchTo(). //Geçmek,Değiştirmek
                alert().   //Alert'e geçiş yaptı
                dismiss(); //Çıkan uyarıya cancel veya hayır der
        Thread.sleep(2000);

        //result mesajının “successfuly” icermedigini test edin.
        String actualTest = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedTest = "successfuly";

        Assert.assertFalse(actualTest.contains(expectedTest));
        System.out.println("dismissAlert() Test PASSED");
        Thread.sleep(1500);
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        //Bir metod olusturun: sendKeysAlert
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Said Ersöz"+Keys.ENTER); driver.switchTo().alert().accept(); Thread.sleep(1500);

        String actualTest = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedTest = "Said Ersöz";

        Assert.assertTrue(actualTest.contains(expectedTest));
        System.out.println("sendKeysAlert() Test PASSED");
        Thread.sleep(1500);
    }
}
