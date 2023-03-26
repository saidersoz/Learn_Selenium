package KarisikSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Scanner;

public class Test01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.desmos.com");
        Thread.sleep(1800);

        WebElement matAraclari = driver.findElement(By.xpath("//span[@class='dcg-header-link-title']"));
        matAraclari.click();
        Thread.sleep(1800);

        WebElement hesapMakinasi = driver.findElement(By.xpath("//span[text()='Hesap Makinesi']"));
        hesapMakinasi.click();
        Thread.sleep(1800);

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen Sayı Giriniz : ");
        int number1 = input.nextInt();


        System.out.println("Yapmak istediğiniz işlemi seçiniz ==>  \n" +
                "Toplama İşlemi için ==> '+' \n" +
                "Çıkarma İşlemi için ==> '-' \n" +
                "Çarpma İşlemi için  ==> '*' \n" +
                "Bölme İşlemi İçin   ==> '/' \n" +
                "İşaretlerini Seçiniz :");
        Character islem = input.next().charAt(0);


        System.out.println("Lütfen Sayı Giriniz : ");
        int number2 = input.nextInt();




        //Girilen 1. Rakamlar için
        if (number1 == 1) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[13]")).click();
        } else if (number1 == 2) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[14]")).click();
        } else if (number1 == 3) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[15]")).click();
        } else if (number1 == 4) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[9]")).click();
        } else if (number1 == 5) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[10]")).click();
        } else if (number1 == 6) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[11]")).click();
        } else if (number1 == 7) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[5]")).click();
        } else if (number1 == 8) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[6]")).click();
        } else if (number1 == 9) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[7]")).click();
        } else if (number1 == 0) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[17]")).click();
        } else {
            System.out.println("Geçersiz Sayı");
        }




        //İşlem operatörleri için
        if (islem == '+') {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[16]")).click();
        } else if (islem == '-') {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[12]")).click();
        } else if (islem == '*') {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[8]")).click();
        } else if (islem == '/') {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[4]")).click();
        } else {
            System.out.println("Geçersiz İşlem");
        }




        //Girilen 2.Rakamlar için
        if (number2 == 1) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[13]")).click();
        } else if (number2 == 2) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[14]")).click();
        } else if (number2 == 3) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[15]")).click();
        } else if (number2 == 4) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[9]")).click();
        } else if (number2 == 5) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[10]")).click();
        } else if (number2 == 6) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[11]")).click();
        } else if (number2 == 7) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[5]")).click();
        } else if (number2 == 8) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[6]")).click();
        } else if (number2 == 9) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[7]")).click();
        } else if (number2 == 0) {
            driver.findElement(By.xpath("(//div[@class='dcg-keypad-btn-container'])[17]")).click();
        } else {
            System.out.println("Geçersiz Sayı");
        }
        Thread.sleep(1000);



        //Enter Tuşu
        driver.findElement(By.xpath("//span[@class='dcg-keypad-btn dcg-btn-short-blue dcg-hovered']")).click();
        Thread.sleep(1800);

        //sonuç
        WebElement sonuc1 = driver.findElement(By.xpath("(//span[@class='dcg-mq-digit'])[3]"));
        WebElement sonuc2 = driver.findElement(By.xpath("(//span[@class='dcg-mq-digit'])[4]"));

        System.out.print("Sonuç : ");
        System.out.print(sonuc1.getText());
        System.out.println(sonuc2.getText());
        Thread.sleep(2000);

         driver.close();

    }


}
