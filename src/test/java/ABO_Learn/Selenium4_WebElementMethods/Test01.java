package ABO_Learn.Selenium4_WebElementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();

        //https://www.amazon.com/ sayafasına gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(1500);

        //arama çubuğuna "Nutella" yazdırın
        WebElement aramaCubugu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaCubugu.sendKeys("Nutella");
        Thread.sleep(1500);

        //Nutella yazdırdıktan sonra ENTER'a basaraka arama işlemini yapın
        aramaCubugu.submit();
        Thread.sleep(1500);

        //Bulunan sonuç sayısını yazdırın
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Sonuc : " + sonuc.getText());
        Thread.sleep(1500);


        driver.close();

        System.err.println("TEST İS PASSED");


    }

}
