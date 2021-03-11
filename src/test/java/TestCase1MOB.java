import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

// All Sleep(); methods used to see all transactions clearly

public class TestCase1MOB {
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

            // Tap to 'Satılık'
            driver.findElement(By.cssSelector("#app > div:nth-child(2) > div > div:nth-child(2) > div > div:nth-child(1)")).click();
            sleep(1000);

            // Tap to 'Filters' Button
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.header-wrapper > div.list-basetab > div > button:nth-child(2)")).click();
            sleep(3000);

            // Tap to 'İl'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > section.location > div.city")).click();
            sleep(1000);

            //To Choose 'İzmir'
            WebElement option_izmir = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div/div[1]/section[1]/div[2]/select"));
            Select sel = new Select(option_izmir);
            sel.selectByValue("izmir");
            sleep(1000);

            // Tap to 'İlçe'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > section.location > section:nth-child(3)")).click();
            sleep(2000);

            // Tap to 'Bornova'
            driver.findElement(By.cssSelector("#dropdown-lightbox-district > div.dropdown-wrap > div.district-list-dialog > li:nth-child(7)")).click();
            sleep(2000);

            // Tap to 'Uygula'
            driver.findElement(By.cssSelector("#dropdown-lightbox-district > button")).click();
            sleep(1000);

            //Tap to 'İş Yeri'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > div:nth-child(4) > div > ul > li:nth-child(2) > div")).click();
            sleep(2000);

            // ScrollDown To Viewport of 'FiyatMin'
            WebElement myElement = driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > section.price > div > div:nth-child(1)"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].scrollIntoView()", myElement);
            sleep(1000);

            // Tap to 'FiyatMin'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > section.price > div > div:nth-child(1) > input")).sendKeys("100000");
            sleep(1000);

            // Tap to 'FiyatMax'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > section.price > div > div:nth-child(2) > input")).sendKeys("2000000");
            sleep(1000);

            // Tap to 'Bina Yaşı'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > section.building-age > section")).click();
            sleep(1000);

            // Tap to 'Sıfır Bina'
            driver.findElement(By.cssSelector("#dropdown-lightbox-filter > div.dropdown-wrap > ul > li:nth-child(2) > label")).click();
            sleep(1000);

            // Tap to '1-5'
            driver.findElement(By.cssSelector("#dropdown-lightbox-filter > div.dropdown-wrap > ul > li:nth-child(3) > label")).click();
            sleep(1000);

            // Tap to '6-10'
            driver.findElement(By.cssSelector("#dropdown-lightbox-filter > div.dropdown-wrap > ul > li:nth-child(4) > label")).click();
            sleep(1000);

            // Tap to 'Uygula'
            driver.findElement(By.cssSelector("#dropdown-lightbox-filter > button")).click();
            sleep(1000);

            // Tap to 'Sonuçları Göster'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.filter-button > button.btn.btn-red.cardShadow3.get-result")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // Tap to 'Filtrele'
            driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.header-wrapper > div.list-basetab > div > button:nth-child(2)")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // Check firstFilterElement
            WebElement filter1 = driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > div.tag-cloud > div > div > div > div > div.swiper-slide.swiper-slide-active > div > div > p"));
            if(filter1.getText().equals("6-10"))
                System.out.println("6-10 checked");

            // Check secondFilterElement
            WebElement filter2 = driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > div.tag-cloud > div > div > div > div > div.swiper-slide.swiper-slide-next > div > div > p"));
            if(filter2.getText().equals("1-5"))
                System.out.println("1-5 checked");

            // Check thirdFilterElement
            WebElement filter3 = driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > div.tag-cloud > div > div > div > div > div:nth-child(3) > div > div > p"));
            if(filter3.getText().equals("Sıfır Bina"))
                System.out.println("Sıfır Bina checked");


            // Drag to Clickable Area Of Filtered Options
            WebElement source= driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > div.tag-cloud > div > div > div > div > div:nth-child(3) > div > div > p"));
            WebElement target= driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > div.tag-cloud > div > div > div > div > div.swiper-slide.swiper-slide-active > div > div > p"));

            Actions dragToMaxPrice = new Actions(driver);
            dragToMaxPrice.dragAndDrop(source, target).build().perform();


            // Check fourthFilterElement
            WebElement filter4 = driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > div.tag-cloud > div > div > div > div > div.swiper-slide.swiper-slide-next > div > div > p"));
            if(filter4.getText().equals("2.000.000 TL"))
                System.out.println("2.000.000 TL checked");
            sleep(3000);

            // Check fifthFilterElement
            WebElement filter5 = driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > div.tag-cloud > div > div > div > div > div:nth-child(5) > div > div > p"));
            if(filter5.getText().equals("100.000 TL"))
                System.out.println("100.000 TL checked");
            sleep(2000);

            //Drag to Clickable Area Of Filtered Options
            WebElement source2= driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > div.tag-cloud > div > div > div > div > div:nth-child(4) > div > div > p"));
            WebElement target2= driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > div.tag-cloud > div > div > div > div > div.swiper-slide.swiper-slide-active > div > div > p"));

            Actions dragToCategory = new Actions(driver);
            dragToCategory.dragAndDrop(source2, target2).build().perform();

            // Check sixthFilterElement
            WebElement filter6 = driver.findElement(By.cssSelector("#app > div.listing-main-wrapper > div.listing > div.listing-wrapper.filter-wrapper > div > div.wrapper > div.tag-cloud > div > div > div > div > div:nth-child(6) > div > div > p"));
            if(filter6.getText().equals("İşyeri"))
                System.out.println("İş Yeri checked");


        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @After
    public void tearDown() throws Exception {

        driver.manage().deleteAllCookies();
       // driver.quit();

    }

}
