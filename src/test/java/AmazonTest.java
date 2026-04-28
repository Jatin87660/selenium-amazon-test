import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class AmazonTest {

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.set(wd);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void searchPrice(String productName) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://www.amazon.in");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")))
                .sendKeys(productName);

        driver.findElement(By.id("nav-search-submit-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));

        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

        String page = driver.getPageSource().toLowerCase();

        if (page.contains("captcha") || page.contains("robot check")) {
            System.out.println("Amazon blocked automation with CAPTCHA.");
            return;
        }

        List<WebElement> products = wait.until(d -> d.findElements(
                By.xpath("//div[@data-component-type='s-search-result']//a[contains(@href,'/dp/')]")
        ));

        if (products.isEmpty()) {
            System.out.println("No products found for: " + productName);
            return;
        }

        products.get(0).click();

        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }

        WebElement priceElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("span.a-price span.a-offscreen")
                )
        );

        String price = priceElement.getAttribute("textContent").trim();

        System.out.println(productName + " Price: " + price);





    }

    @Test
    public void testIphone() {
        searchPrice("iPhone");
    }

    @Test
    public void testGalaxy() {
        searchPrice("Samsung Galaxy");
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
