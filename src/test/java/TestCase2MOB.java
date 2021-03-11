import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;
import static org.openqa.selenium.By.*;

// All Sleep(); methods used to see all transactions clearly
public class TestCase2MOB {
    protected WebDriver driver;
    public static String loginUrl = "https://www.hurriyetemlak.com/";

    @Before
    public void setUp() {

        try {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emir\\IdeaProjects\\Test\\ChromeDriver\\chromedriver.exe");

            Map<String, String> mobileEmulation = new HashMap<>();

            mobileEmulation.put("deviceName", "iPhone 8");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            driver = new ChromeDriver(chromeOptions);

            driver.manage().deleteAllCookies();

            // Dynamic wait
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void Test() {

        try {

            // goes to https://www.hurriyetemlak.com
            driver.get(loginUrl);

            // Tap to 'Kapat'
            boolean checkButton = driver.findElement(By.cssSelector("#app > div.cookie-policy-wrapper > div.cookie-policy > button")).isDisplayed() ;
            if(checkButton) {
                WebElement cookieButton = driver.findElement(By.cssSelector("#app > div.cookie-policy-wrapper > div.cookie-policy > button"));
                cookieButton.click();
            }
            sleep(1000);

            // Tap to 'Kiralık'
            driver.findElement(By.cssSelector("#app > div:nth-child(2) > div > div:nth-child(2) > div > div:nth-child(2)")).click();
            sleep(1000);

            // Tap to 'Filters' Button
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.header-wrapper > div.list-basetab > div > button:nth-child(2)")).click();
            sleep(3000);

            // Tap to 'İl'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > section.location > div.city")).click();
            sleep(3000);

            //To Choose 'Ankara'
            WebElement option_ankara = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div/div[1]/section[1]/div[2]/select"));
            Select sel = new Select(option_ankara);
            sel.selectByValue("ankara");
            sleep(1000);

            // Tap to 'İlçe'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > section.location > section:nth-child(3)")).click();
            sleep(2000);

            // Tap to 'Çankaya'
            driver.findElement(By.cssSelector("#dropdown-lightbox-district > div.dropdown-wrap > div.district-list-dialog > li:nth-child(7) > label")).click();
            sleep(2000);

            // Tap to 'Uygula'
            driver.findElement(By.cssSelector("#dropdown-lightbox-district > button")).click();
            sleep(1000);

            // ScrollDown To Viewport of 'Oda Sayısı'
            WebElement oda_sayisi = driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > section.room-type > section"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].scrollIntoView()", oda_sayisi);
            oda_sayisi.click();
            sleep(1000);

            // Tap to '2+1'
            driver.findElement(By.cssSelector("#dropdown-lightbox-filter > div.dropdown-wrap > ul > li:nth-child(4) > label")).click();
            sleep(1000);

            // Tap to 'Uygula'
            driver.findElement(By.cssSelector("#dropdown-lightbox-filter > button")).click();
            sleep(1000);

           // ScrollDown To Viewport of 'Site İçinde'
            WebElement site_ici = driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > section.within-site.d-flex > label > span"));
            JavascriptExecutor jse2 = (JavascriptExecutor)driver;
            jse2.executeScript("arguments[0].scrollIntoView()", site_ici);
            site_ici.click();
            sleep(1000);

            // Tap to 'Sonuçları Göster'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.filter-button > button.btn.btn-red.cardShadow3.get-result")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            // Tap to 'First Filtered Page'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper > div.reality-list > div:nth-child(1) > div.inner > div.card-link > div > a > div > div > div > div.swiper-wrapper.listing > div.swiper-slide.swiper-slide-active > img")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // ScrollDown To Viewport of 'Telefonu Göster'
            WebElement telefon_alani = driver.findElement(By.cssSelector("#app > div:nth-child(2) > div > div > div:nth-child(3) > div.detail-container > div.detail-page__bgMidGrey > div.owner-card > div > div:nth-child(4) > div.contact > button"));
            JavascriptExecutor jse3 = (JavascriptExecutor)driver;
            jse3.executeScript("arguments[0].scrollIntoView()", telefon_alani);
            telefon_alani.click();
            sleep(1000);

            // Getting Phone Number
            String phone_number = driver.findElement(By.cssSelector("#app > div:nth-child(2) > div > div > div:nth-child(3) > div.detail-container > div.detail-page__bgMidGrey > div.owner-card > div > div:nth-child(4) > div.contact > div.phone-wrap > div > div:nth-child(3) > a")).getText();
            System.out.println(phone_number);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @After
    public void tearDown() throws Exception {
        driver.manage().deleteAllCookies();
        driver.quit();

    }

}
