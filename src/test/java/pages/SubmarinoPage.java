package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubmarinoPage {
    private WebElement searchInput;
    private WebElement product;
    private WebElement buyButton;
    private WebElement continueButton;
    private WebDriver driver;

    public WebDriver initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\raphael.vitorino\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void searchForProduct(String productName) {
        searchInput = driver.findElement(By.id("h_search-input"));
        searchInput.sendKeys(productName);
        searchInput.sendKeys(Keys.ENTER);
    }

    public WebElement getProductInList() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.row.product-grid.no-gutters.main-grid section div.Info-bwhjk3-5 h2")));
        product = driver.findElement(By.cssSelector("div.row.product-grid.no-gutters.main-grid section div.Info-bwhjk3-5 h2"));
        return product;
    }

    public void addProductToCart() {
        driver.findElement(By.cssSelector("div.row.product-grid.no-gutters.main-grid section div.Info-bwhjk3-5 h2")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#btn-buy")));
        buyButton = driver.findElement(By.cssSelector("a#btn-buy"));
        buyButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-continue")));
        continueButton = driver.findElement(By.id("btn-continue"));
        continueButton.click();
    }

    public WebElement getProductInCart() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.link-default")));
        product = driver.findElement(By.cssSelector("a.link-default[title='Teclado Gamer Corsair Ch-9127014-br K95 Platinum Retroiluminacao Rgb Teclas Cherry Mx']"));
        return product;
    }
}
