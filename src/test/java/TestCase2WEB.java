import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

// All Sleep(); methods used to see all transactions clearly

public class TestCase2WEB {
    protected WebDriver driver;
    public static String loginUrl = "https://www.hurriyetemlak.com/";

    @Before
    public void setUp() {

        try {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emir\\IdeaProjects\\Test\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();

            driver.manage().window().maximize();
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

            // Click to 'Kiralık'
            driver.findElement(By.cssSelector("#__layout > div > section.home-wrapper > div.home-search-wrap > div > div.middle.home-content > div > ul > li:nth-child(3) > a")).click();
            sleep(5000);

            // Click to 'il' TextBox
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.locationSec > section.filter-item-wrap.loc.locationCitySec > div > div > div > div > div > div.he-select-base__container")).click();
            sleep(1000);

            // Click to 'Ankara' from Radio Buttons
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.locationSec > section.filter-item-wrap.loc.locationCitySec > div > div > div > div > div > div.he-popper.he-select-base__dropdown > div > div.he-select-base__list > ul > li:nth-child(2)")).click();
            sleep(1000);

            // Click to 'İlçe' TextBox
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.locationSec > section.filter-item-wrap.loc.locationCountySec > div > div > div > div.he-select-base__container")).click();
            sleep(3000);

            //Click to SubTextBox Area
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.locationSec > section.filter-item-wrap.loc.locationCountySec > div > div > div > div.he-popper.he-select-base__dropdown > input")).sendKeys("Çankaya");
            sleep(1000);

            // Click to 'Çankaya'
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.locationSec > section.filter-item-wrap.loc.locationCountySec > div > div > div > div.he-popper.he-select-base__dropdown > div > div.he-select-base__list > ul > li > div")).click();
            sleep(1000);

            // ScrollDown To Viewport of 'Oda Salon Sayısı'
            WebElement myElement = driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.roomTypeSec > section > div > div > div"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].scrollIntoView()", myElement);

            //Click to 'Oda Salon Sayısı'
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.roomTypeSec > section > div > div > div")).click();
            sleep(1000);

            //Click to '2+1'
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.roomTypeSec > section > div > div.dropdown-lightbox > div > div > ul > li:nth-child(3) > label ")).click();
            sleep(1000);

            // ScrollDown To Viewport of 'Site İçerisinde'
            WebElement myelement2 = driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.filter-switch.withinSiteSec > label > div.md-switch-thumb"));
            JavascriptExecutor jse2 = (JavascriptExecutor)driver;
            jse2.executeScript("arguments[0].scrollIntoView()", myelement2);

            //Click To 'Site İçinde'
            myelement2.click();
            sleep(2000);

            // Click To 'Ara'
            driver.findElement(By.linkText("Ara")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            // Click to First Filtered Detail Page
            driver.findElement(By.cssSelector("#\\34 337-2719 > div > div.list-view-content > div.bottom.sibling > div.left > div.down > div.links > a")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            //Click to 'Telefon Numarasını Göster'
            driver.findElement(By.cssSelector("#__layout > div > div > section.wrapper.detail-page > div > div.detail-sidebar.cont-block.right > div > section > div > div.owner-phone-numbers > button")).click();
            sleep(1000);

            //Getting Phone Number
            String phone_number = driver.findElement(By.cssSelector("#__layout > div > div > section.wrapper.detail-page > div > div.detail-sidebar.cont-block.right > div > section > div > div.owner-phone-numbers > div > ul > li:nth-child(3) > a")).getText();
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
