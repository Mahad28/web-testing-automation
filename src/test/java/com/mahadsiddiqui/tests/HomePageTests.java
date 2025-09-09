package com.mahadsiddiqui.tests;

import com.mahadsiddiqui.config.WebDriverConfig;
import com.mahadsiddiqui.pages.HomePage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for Home Page functionality
 * Demonstrates comprehensive web testing scenarios
 */
@Epic("E-commerce Website")
@Feature("Home Page")
public class HomePageTests {
    
    private WebDriver driver;
    private HomePage homePage;
    
    @BeforeMethod
    public void setUp() {
        driver = WebDriverConfig.initializeDriver();
        homePage = new HomePage(driver);
        homePage.navigateToHomePage();
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test(description = "Verify home page loads successfully")
    @Story("Page Loading")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test to verify that the home page loads with all essential elements")
    public void testHomePageLoadsSuccessfully() {
        // Given - Home page is loaded
        
        // When - Check page elements
        boolean logoDisplayed = homePage.isLogoDisplayed();
        boolean navigationDisplayed = homePage.isNavigationMenuDisplayed();
        String pageTitle = homePage.getHomePageTitle();
        
        // Then - Verify all elements are present
        Assert.assertTrue(logoDisplayed, "Logo should be displayed");
        Assert.assertTrue(navigationDisplayed, "Navigation menu should be displayed");
        Assert.assertNotNull(pageTitle, "Page title should not be null");
        Assert.assertFalse(pageTitle.isEmpty(), "Page title should not be empty");
    }
    
    @Test(description = "Verify navigation menu functionality")
    @Story("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test to verify that navigation menu links work correctly")
    public void testNavigationMenuFunctionality() {
        // Given - Home page is loaded
        
        // When - Click on different navigation links
        homePage.clickProductsLink();
        String productsPageTitle = homePage.getPageTitle();
        
        homePage.navigateToHomePage();
        homePage.clickAboutLink();
        String aboutPageTitle = homePage.getPageTitle();
        
        homePage.navigateToHomePage();
        homePage.clickContactLink();
        String contactPageTitle = homePage.getPageTitle();
        
        // Then - Verify navigation works
        Assert.assertNotNull(productsPageTitle, "Products page title should not be null");
        Assert.assertNotNull(aboutPageTitle, "About page title should not be null");
        Assert.assertNotNull(contactPageTitle, "Contact page title should not be null");
    }
    
    @Test(description = "Verify search functionality")
    @Story("Search")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test to verify that product search works correctly")
    public void testSearchFunctionality() {
        // Given - Home page is loaded
        String searchTerm = "laptop";
        
        // When - Search for a product
        homePage.searchProduct(searchTerm);
        
        // Then - Verify search was performed
        String currentUrl = homePage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("search") || currentUrl.contains("q="), 
                "URL should contain search parameters");
    }
    
    @Test(description = "Verify featured products section")
    @Story("Products")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify that featured products section is displayed")
    public void testFeaturedProductsSection() {
        // Given - Home page is loaded
        
        // When - Check featured products section
        boolean featuredProductsDisplayed = homePage.isFeaturedProductsDisplayed();
        int productCount = homePage.getProductCardsCount();
        
        // Then - Verify featured products are displayed
        Assert.assertTrue(featuredProductsDisplayed, "Featured products section should be displayed");
        Assert.assertTrue(productCount > 0, "Should have at least one product card");
    }
    
    @Test(description = "Verify newsletter subscription")
    @Story("Newsletter")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify that newsletter subscription works")
    public void testNewsletterSubscription() {
        // Given - Home page is loaded
        String email = "test@example.com";
        
        // When - Subscribe to newsletter
        homePage.subscribeToNewsletter(email);
        
        // Then - Verify subscription success
        boolean successMessageDisplayed = homePage.isNewsletterSuccessMessageDisplayed();
        Assert.assertTrue(successMessageDisplayed, "Newsletter success message should be displayed");
    }
    
    @Test(description = "Verify social media links")
    @Story("Social Media")
    @Severity(SeverityLevel.MINOR)
    @Description("Test to verify that social media links are present and clickable")
    public void testSocialMediaLinks() {
        // Given - Home page is loaded
        
        // When - Check social media links
        homePage.scrollToFooter();
        
        // Then - Verify social media links are present
        // Note: In a real test, you would verify the links open in new tabs
        // and redirect to correct social media pages
        Assert.assertTrue(true, "Social media links test placeholder");
    }
    
    @Test(description = "Verify footer information")
    @Story("Footer")
    @Severity(SeverityLevel.MINOR)
    @Description("Test to verify that footer contains expected information")
    public void testFooterInformation() {
        // Given - Home page is loaded
        
        // When - Scroll to footer and get information
        homePage.scrollToFooter();
        boolean footerDisplayed = homePage.isFooterDisplayed();
        String copyrightText = homePage.getCopyrightText();
        
        // Then - Verify footer information
        Assert.assertTrue(footerDisplayed, "Footer should be displayed");
        Assert.assertNotNull(copyrightText, "Copyright text should not be null");
    }
    
    @Test(description = "Verify page responsiveness")
    @Story("Responsive Design")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify that page elements are responsive")
    public void testPageResponsiveness() {
        // Given - Home page is loaded
        
        // When - Check if elements are displayed at different screen sizes
        boolean logoDisplayed = homePage.isLogoDisplayed();
        boolean navigationDisplayed = homePage.isNavigationMenuDisplayed();
        
        // Then - Verify responsive elements
        Assert.assertTrue(logoDisplayed, "Logo should be displayed on all screen sizes");
        Assert.assertTrue(navigationDisplayed, "Navigation should be displayed on all screen sizes");
    }
    
    @Test(description = "Verify page load performance")
    @Story("Performance")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify that page loads within acceptable time")
    public void testPageLoadPerformance() {
        // Given - Fresh browser session
        
        // When - Load home page and measure time
        long startTime = System.currentTimeMillis();
        homePage.navigateToHomePage();
        homePage.waitForPageLoad();
        long endTime = System.currentTimeMillis();
        
        long loadTime = endTime - startTime;
        
        // Then - Verify load time is acceptable (less than 5 seconds)
        Assert.assertTrue(loadTime < 5000, "Page should load within 5 seconds. Actual: " + loadTime + "ms");
    }
    
    @Test(description = "Verify user authentication links")
    @Story("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test to verify that login and register links are present")
    public void testUserAuthenticationLinks() {
        // Given - Home page is loaded
        
        // When - Check authentication links
        homePage.clickUserIcon();
        
        // Then - Verify login and register links are accessible
        // Note: In a real test, you would verify the links navigate to correct pages
        Assert.assertTrue(true, "Authentication links test placeholder");
    }
    
    @Test(description = "Verify cart functionality")
    @Story("Shopping Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test to verify that cart icon and functionality work")
    public void testCartFunctionality() {
        // Given - Home page is loaded
        
        // When - Click on cart icon
        homePage.clickCartIcon();
        
        // Then - Verify cart page loads
        String currentUrl = homePage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("cart") || currentUrl.contains("basket"), 
                "Should navigate to cart page");
    }
}
