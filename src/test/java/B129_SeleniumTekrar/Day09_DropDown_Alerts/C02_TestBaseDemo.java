package B129_SeleniumTekrar.Day09_DropDown_Alerts;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class C02_TestBaseDemo extends TestBase{

    @Test
    public void test01() {
        ///TechPro sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        //Başlığın "Bootcamb" içerdiğini test edelim
        String actualTitle = driver.getTitle();
        String exceptedTitle = "Bootcamp";

        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains(exceptedTitle));
    }
}
