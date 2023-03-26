import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class deneme {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        System.out.println("ok sorun yok");

        System.out.println("Yapmak istediğiniz işlemi seçiniz ==>  \n" +
                "Toplama İşlemi için ==> '+' \n" +
                "Çıkarma İşlemi için ==> '-' \n" +
                "Çarpma İşlemi için  ==> '*' \n" +
                "Bölme İşlemi İçin   ==> '/' \n" +
                "İşaretlerini Seçiniz :");
    }

}
