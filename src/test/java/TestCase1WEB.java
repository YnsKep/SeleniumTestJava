import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

// All Sleep(); methods used to see all transactions clearly

public class TestCase1WEB {
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

            // Click to 'Satılık'
            driver.findElement(By.cssSelector("#__layout > div > section > div.home-search-wrap > div > div.middle.home-content > div > ul > li:nth-child(1) > a")).click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // Click to 'il' TextBox
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.locationSec > section.filter-item-wrap.loc.locationCitySec > div > div > div > div")).click();
            sleep(1000);

            // Click to 'İzmir' from Radio Buttons
            driver.findElement(By.cssSelector(" #listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.locationSec > section.filter-item-wrap.loc.locationCitySec > div > div > div > div > div > div.he-popper.he-select-base__dropdown > div > div.he-select-base__list > ul > li:nth-child(3)")).click();
            sleep(2000);

            // Click to 'İlçe' TextBox
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.locationSec > section.filter-item-wrap.loc.locationCountySec > div > div > div > div.he-select-base__container")).click();
            sleep(2000);

            //Click to SubTextBox Area
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.locationSec > section.filter-item-wrap.loc.locationCountySec > div > div > div > div.he-popper.he-select-base__dropdown > input")).sendKeys("Bornova");
            sleep(1000);

            // Click to 'Bornova'
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.locationSec > section.filter-item-wrap.loc.locationCountySec > div > div > div > div.he-popper.he-select-base__dropdown > div > div.he-select-base__list > ul > li > div")).click();
            sleep(1000);

            // Click to 'İş yeri'
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.filter-item-wrap.categoryMainSec > div > ul > li:nth-child(2)")).click();
            sleep(1000);

            //Click to PriceMin
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.filter-item-wrap.priceSec > div > div:nth-child(1) > input")).sendKeys("100.000");
            sleep(1000);

            //Click to PriceMax
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.filter-item-wrap.priceSec > div > div:nth-child(2) > input")).sendKeys("2.000.000");
            sleep(1000);


            // ScrollDown To Viewport of 'Bina Yaşı'
            WebElement myElement = driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.buildingAgeSec > section > div > div > div"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].scrollIntoView()", myElement);

            //Click to 'Bina Yaşı'
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.buildingAgeSec > section > div > div > div")).click();
            sleep(1000);

            //Click to 'Sıfır Bina'
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.buildingAgeSec > section > div > div.dropdown-lightbox > div > div > ul > li:nth-child(1)")).click();
            sleep(1000);


            //Click to '1-5'
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.buildingAgeSec > section > div > div.dropdown-lightbox > div > div > ul > li:nth-child(2)")).click();
            sleep(1000);

            //Click to '6-10'
            driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.buildingAgeSec > section > div > div.dropdown-lightbox > div > div > ul > li:nth-child(3)")).click();
            sleep(1000);

            // ScrollDown To Viewport of 'Ara' button
            WebElement myelement2 = driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.left-content > div:nth-child(1) > section.listing-filter > div > section.filter-button-wrapper > a.btn.btn-red.btn-large"));
            JavascriptExecutor jse2 = (JavascriptExecutor)driver;
            jse2.executeScript("arguments[0].scrollIntoView()", myelement2);

            //Click to 'Ara'
            driver.findElement(By.linkText("Ara")).click();

            // Wait for page load
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // Check firstFilterElement
            WebElement filter1 = driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.right-content.content > div.applied-filters.filters--expanded > div.applied-filters__inner > ul > li:nth-child(1) > span.applied-filters-list-item.last--item"));
            if(filter1.getText().equals("İzmir"))
                System.out.println("İzmir checked");

            // Check secondFilterElement
            WebElement filter2 = driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.right-content.content > div.applied-filters.filters--expanded > div.applied-filters__inner > ul > li:nth-child(2) > span.applied-filters-list-item.last--item"));
            if(filter2.getText().equals("Bornova"))
                System.out.println("Bornova checked");

            // Check thirdFilterElement
            WebElement filter3 = driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.right-content.content > div.applied-filters.filters--expanded > div.applied-filters__inner > ul > li:nth-child(3) > span.applied-filters-list-item.last--item"));
            if(filter3.getText().equals("İşyeri"))
                System.out.println("İş Yeri checked");

            // Check fourthFilterElement
            WebElement filter4 = driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.right-content.content > div.applied-filters.filters--expanded > div.applied-filters__inner > ul > li:nth-child(4) > span.applied-filters-list-item.last--item"));
            if(filter4.getText().equals("100.000 TL - 2.000.000 TL"))
                System.out.println("100.000 TL - 2.000.000 TL checked");

            // Check fifthFilterElement
            WebElement filter5 = driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.right-content.content > div.applied-filters.filters--expanded > div.applied-filters__inner > ul > li:nth-child(5) > span.applied-filters-list-item"));
            if(filter5.getText().equals("Sıfır Bina"))
                System.out.println("Sıfır Bina checked");

            // Check sixthFilterElement
            WebElement filter6 = driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.right-content.content > div.applied-filters.filters--expanded > div.applied-filters__inner > ul > span:nth-child(6)"));
            if(filter6.getText().equals("1-5"))
                System.out.println("1-5 checked");

            // Check seventhFilterElement
            WebElement filter7 = driver.findElement(By.cssSelector("#listPage > div.list-page-wrapper > div.wrapper.list-wrapper > div > div.right-content.content > div.applied-filters.filters--expanded > div.applied-filters__inner > ul > span.applied-filters-list-item.last--item"));
            Assert.assertEquals("6-10", filter7.getText());

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
