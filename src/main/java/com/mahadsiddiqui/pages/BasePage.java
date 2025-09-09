package com.mahadsiddiqui.pages;

import com.mahadsiddiqui.config.WebDriverConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * Base page class containing common web element interactions
 * Provides reusable methods for all page objects
 */
public class BasePage {
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WebDriverConfig.getExplicitWaitTimeout()));
    }
    
    /**
     * Navigate to a specific URL
     */
    public void navigateTo(String url) {
        driver.get(url);
    }
    
    /**
     * Get current page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    /**
     * Get current page URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    /**
     * Wait for element to be visible
     */
    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    /**
     * Wait for element to be clickable
     */
    public WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    /**
     * Wait for element to be present
     */
    public WebElement waitForElementPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    /**
     * Click on element
     */
    public void click(By locator) {
        WebElement element = waitForElementClickable(locator);
        element.click();
    }
    
    /**
     * Click on element with JavaScript
     */
    public void clickWithJS(By locator) {
        WebElement element = waitForElementVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    
    /**
     * Send text to input field
     */
    public void sendKeys(By locator, String text) {
        WebElement element = waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    /**
     * Get text from element
     */
    public String getText(By locator) {
        WebElement element = waitForElementVisible(locator);
        return element.getText();
    }
    
    /**
     * Get attribute value from element
     */
    public String getAttribute(By locator, String attributeName) {
        WebElement element = waitForElementVisible(locator);
        return element.getAttribute(attributeName);
    }
    
    /**
     * Check if element is displayed
     */
    public boolean isElementDisplayed(By locator) {
        try {
            WebElement element = waitForElementVisible(locator);
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    
    /**
     * Check if element is enabled
     */
    public boolean isElementEnabled(By locator) {
        WebElement element = waitForElementVisible(locator);
        return element.isEnabled();
    }
    
    /**
     * Check if element is selected
     */
    public boolean isElementSelected(By locator) {
        WebElement element = waitForElementVisible(locator);
        return element.isSelected();
    }
    
    /**
     * Select option from dropdown by visible text
     */
    public void selectByVisibleText(By locator, String visibleText) {
        WebElement element = waitForElementVisible(locator);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }
    
    /**
     * Select option from dropdown by value
     */
    public void selectByValue(By locator, String value) {
        WebElement element = waitForElementVisible(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }
    
    /**
     * Select option from dropdown by index
     */
    public void selectByIndex(By locator, int index) {
        WebElement element = waitForElementVisible(locator);
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    
    /**
     * Get all options from dropdown
     */
    public List<WebElement> getDropdownOptions(By locator) {
        WebElement element = waitForElementVisible(locator);
        Select select = new Select(element);
        return select.getOptions();
    }
    
    /**
     * Switch to frame by index
     */
    public void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }
    
    /**
     * Switch to frame by name or ID
     */
    public void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }
    
    /**
     * Switch to frame by element
     */
    public void switchToFrame(By locator) {
        WebElement frameElement = waitForElementVisible(locator);
        driver.switchTo().frame(frameElement);
    }
    
    /**
     * Switch back to default content
     */
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
    
    /**
     * Switch to new window/tab
     */
    public void switchToNewWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    
    /**
     * Switch to specific window by title
     */
    public void switchToWindowByTitle(String title) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }
    
    /**
     * Close current window and switch to parent
     */
    public void closeCurrentWindow() {
        driver.close();
        Set<String> windowHandles = driver.getWindowHandles();
        if (!windowHandles.isEmpty()) {
            driver.switchTo().window(windowHandles.iterator().next());
        }
    }
    
    /**
     * Scroll to element
     */
    public void scrollToElement(By locator) {
        WebElement element = waitForElementVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    /**
     * Scroll to top of page
     */
    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
    
    /**
     * Scroll to bottom of page
     */
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    
    /**
     * Wait for page to load
     */
    public void waitForPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }
    
    /**
     * Take screenshot
     */
    public void takeScreenshot(String fileName) {
        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                    .takeScreenshot(driver);
            
            File destFile = new File(WebDriverConfig.getProperty("screenshot.path", "screenshots/") + fileName + ".png");
            ImageIO.write(screenshot.getImage(), "PNG", destFile);
        } catch (IOException e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }
    }
    
    /**
     * Wait for alert and accept it
     */
    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    /**
     * Wait for alert and dismiss it
     */
    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    
    /**
     * Get alert text
     */
    public String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
    
    /**
     * Send text to alert
     */
    public void sendKeysToAlert(String text) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }
    
    /**
     * Double click on element
     */
    public void doubleClick(By locator) {
        WebElement element = waitForElementVisible(locator);
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.doubleClick(element).perform();
    }
    
    /**
     * Right click on element
     */
    public void rightClick(By locator) {
        WebElement element = waitForElementVisible(locator);
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.contextClick(element).perform();
    }
    
    /**
     * Hover over element
     */
    public void hoverOverElement(By locator) {
        WebElement element = waitForElementVisible(locator);
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.moveToElement(element).perform();
    }
    
    /**
     * Drag and drop element
     */
    public void dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = waitForElementVisible(sourceLocator);
        WebElement target = waitForElementVisible(targetLocator);
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }
}
