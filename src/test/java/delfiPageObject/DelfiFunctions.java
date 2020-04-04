package delfiPageObject;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiFunctions {
    private final String DELFI_HOME_PAGE_URL = "delfi.lv";
    private WebDriver driver;
    private WebDriverWait wait;


    public DelfiFunctions(){
        System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }
//Function Go to URL
    public void goToUrl(String url){
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        driver.get(url);
    }
//Function Open Delfi Home Page
    public void openDelfiHomePage(){
        goToUrl(DELFI_HOME_PAGE_URL);
    }

//Function find element
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

//Function to wait while article is found
    public WebElement findElement (By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

//Function click on the article link
    public void click(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

//Close Browser
    public void closeBrowser() {
        driver.close();
    }
   }
