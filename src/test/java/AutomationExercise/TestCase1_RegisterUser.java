package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestCase1_RegisterUser {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 1. Tarayıcıyı başlatın
        // 1. Launch browser

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        Thread.sleep(1500);

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        WebElement login =  driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        login.click(); Thread.sleep(1500);


        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        //5. Verify 'New User Signup!' is visible
        WebElement name =  driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("Said Ersöz"); Thread.sleep(1000);

        //6. Enter name and email address
        //6. Adı ve e-posta adresini girin
        WebElement mail =  driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        mail.sendKeys("m.said.ersoz3443@gmail.com"); Thread.sleep(1000);

        //7. Click 'Signup' button
        //7. 'Kaydol' düğmesini tıklayın
        WebElement signUp = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUp.click(); Thread.sleep(1000);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        WebElement information = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        String info =  information.getText();
        String infoTrue = "ENTER ACCOUNT INFORMATION";

        if (infoTrue.equals(info)){
            System.out.println("INFORMATION TEST PASSED");
        }else {
            System.out.println("INFORMATION TEST FAILED");
        }Thread.sleep(1000);


        //9. Fill details: Title, Name, Email, Password, Date of birth
        //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        WebElement mr = driver.findElement(By.xpath("//label[@for='id_gender1']")); mr.click();
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("said3461"); Thread.sleep(1000);
        //WebElement day = driver.findElement(By.xpath("//select[@data-qa='days']"));day.click(); Thread.sleep(1000);
        WebElement may31 = driver.findElement(By.xpath("//option[@value='31']")); may31.click();Thread.sleep(1000);
        //WebElement month = driver.findElement(By.xpath("//select[@data-qa='months']")); month.click();Thread.sleep(1000);
        WebElement may = driver.findElement(By.xpath("(//option[@value='5'])[2]")); may.click();Thread.sleep(1000);
        //WebElement year = driver.findElement(By.xpath("(//select[@data-qa='years']")); year.click();Thread.sleep(1000);
        WebElement year2000 = driver.findElement(By.xpath("//option[@value='2000']")); year2000.click();Thread.sleep(1000);


        //10. Select checkbox 'Sign up for our newsletter!'
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        WebElement signUpNews = driver.findElement(By.xpath("//input[@name='newsletter']")); signUpNews.click(); Thread.sleep(1000);

        //11. Select checkbox 'Receive special offers from our partners!'
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        WebElement selectPartners = driver.findElement(By.xpath("//input[@name='optin']")); selectPartners.click(); Thread.sleep(1000);

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.click(); firstName.sendKeys("Said"); Thread.sleep(1000);

        WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.click(); lastName.sendKeys("Ersöz"); Thread.sleep(1000);

        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.click(); company.sendKeys("TechProEducation"); Thread.sleep(1000);

        WebElement address1 = driver.findElement(By.xpath("//input[@id='address1']"));
        address1.click(); address1.sendKeys("ISTANBUL"); Thread.sleep(1000);

        WebElement address2 = driver.findElement(By.xpath("//input[@id='address2']"));
        address2.click(); address2.sendKeys("USA"); Thread.sleep(1000);

        WebElement country = driver.findElement(By.xpath("//option[@value='United States']"));
        country.click(); Thread.sleep(1000);

        WebElement state = driver.findElement(By.xpath("//input[@id='state']"));
        state.click(); state.sendKeys("OKAY"); Thread.sleep(1000);

        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        city.click(); city.sendKeys("FLORIDA"); Thread.sleep(1000);

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='zipcode']"));
        zipCode.click(); zipCode.sendKeys("34000"); Thread.sleep(1000);

        WebElement mobileNumber = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        mobileNumber.click(); mobileNumber.sendKeys("05555555555"); Thread.sleep(1000);

        //13. Click 'Create Account button'
        //13. 'Hesap Oluştur düğmesini' tıklayın
        WebElement createAccount = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccount.click(); Thread.sleep(1000);


        //14. Verify that 'ACCOUNT CREATED!' is visible
        //14. 'HESAP OLUŞTURULDU!' görünür
        String accountCreated = "ACCOUNT CREATED!";

        WebElement accountCreatedTest = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));

            if (accountCreated.equals(accountCreatedTest.getText())){
                System.out.println("ACCOUNT CREATED TEST PASSED");
            }else {
                System.out.println("ACCOUNT CREATED TEST FAILED");
            }Thread.sleep(1400);


            //reklam geç
        WebElement reklam = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
        reklam.click(); Thread.sleep(1000);


        //15. Click 'Continue' button
        //15. 'Devam Et' düğmesini tıklayın
        WebElement devamEt = driver.findElement(By.xpath("//div[@class='pull-right']"));
        devamEt.click(); Thread.sleep(1200);


        //16. Verify that 'Logged in as username' is visible
        ///16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement logged = driver.findElement(By.xpath("//i[@class='fa fa-user']"));

        if (logged.isDisplayed()){
            System.out.println("DISPLAYED TEST PASSED");
        }else {
            System.out.println("DISPLAYED TEST FAIL");
        }Thread.sleep(1200);


        //17. Click 'Delete Account' button
        //17. 'Hesabı Sil' düğmesini tıklayın
        WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccount.click();  Thread.sleep(1000);


        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
        WebElement delete = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        System.out.println("ACCOUNT DELETED TEST PASSED");
        delete.click(); Thread.sleep(1500);


        System.out.println("TEST PASSED");
        driver.close();

    }

}
