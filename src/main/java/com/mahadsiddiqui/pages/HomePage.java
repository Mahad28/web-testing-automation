package com.mahadsiddiqui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Home page object class
 * Contains elements and methods for the home page
 */
public class HomePage extends BasePage {
    
    // Page elements
    private static final By LOGO = By.cssSelector(".logo");
    private static final By NAVIGATION_MENU = By.cssSelector(".navbar-nav");
    private static final By SEARCH_BOX = By.id("search");
    private static final By SEARCH_BUTTON = By.cssSelector(".search-button");
    private static final By CART_ICON = By.cssSelector(".cart-icon");
    private static final By USER_ICON = By.cssSelector(".user-icon");
    private static final By LOGIN_LINK = By.linkText("Login");
    private static final By REGISTER_LINK = By.linkText("Register");
    private static final By CONTACT_LINK = By.linkText("Contact");
    private static final By ABOUT_LINK = By.linkText("About");
    private static final By PRODUCTS_LINK = By.linkText("Products");
    private static final By CART_LINK = By.linkText("Cart");
    private static final By WISHLIST_LINK = By.linkText("Wishlist");
    private static final By FOOTER = By.cssSelector(".footer");
    private static final By COPYRIGHT = By.cssSelector(".copyright");
    
    // Featured products section
    private static final By FEATURED_PRODUCTS = By.cssSelector(".featured-products");
    private static final By PRODUCT_CARDS = By.cssSelector(".product-card");
    private static final By ADD_TO_CART_BUTTON = By.cssSelector(".add-to-cart");
    private static final By ADD_TO_WISHLIST_BUTTON = By.cssSelector(".add-to-wishlist");
    
    // Newsletter section
    private static final By NEWSLETTER_EMAIL = By.id("newsletter-email");
    private static final By NEWSLETTER_SUBSCRIBE_BUTTON = By.id("newsletter-subscribe");
    private static final By NEWSLETTER_SUCCESS_MESSAGE = By.cssSelector(".newsletter-success");
    
    // Social media links
    private static final By FACEBOOK_LINK = By.cssSelector(".social-facebook");
    private static final By TWITTER_LINK = By.cssSelector(".social-twitter");
    private static final By INSTAGRAM_LINK = By.cssSelector(".social-instagram");
    private static final By LINKEDIN_LINK = By.cssSelector(".social-linkedin");
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Navigate to home page
     */
    public void navigateToHomePage() {
        navigateTo(WebDriverConfig.getBaseUrl());
    }
    
    /**
     * Check if logo is displayed
     */
    public boolean isLogoDisplayed() {
        return isElementDisplayed(LOGO);
    }
    
    /**
     * Get logo text
     */
    public String getLogoText() {
        return getText(LOGO);
    }
    
    /**
     * Search for a product
     */
    public void searchProduct(String productName) {
        sendKeys(SEARCH_BOX, productName);
        click(SEARCH_BUTTON);
    }
    
    /**
     * Get search box placeholder text
     */
    public String getSearchBoxPlaceholder() {
        return getAttribute(SEARCH_BOX, "placeholder");
    }
    
    /**
     * Click on cart icon
     */
    public void clickCartIcon() {
        click(CART_ICON);
    }
    
    /**
     * Click on user icon
     */
    public void clickUserIcon() {
        click(USER_ICON);
    }
    
    /**
     * Click on login link
     */
    public void clickLoginLink() {
        click(LOGIN_LINK);
    }
    
    /**
     * Click on register link
     */
    public void clickRegisterLink() {
        click(REGISTER_LINK);
    }
    
    /**
     * Click on contact link
     */
    public void clickContactLink() {
        click(CONTACT_LINK);
    }
    
    /**
     * Click on about link
     */
    public void clickAboutLink() {
        click(ABOUT_LINK);
    }
    
    /**
     * Click on products link
     */
    public void clickProductsLink() {
        click(PRODUCTS_LINK);
    }
    
    /**
     * Click on cart link
     */
    public void clickCartLink() {
        click(CART_LINK);
    }
    
    /**
     * Click on wishlist link
     */
    public void clickWishlistLink() {
        click(WISHLIST_LINK);
    }
    
    /**
     * Check if navigation menu is displayed
     */
    public boolean isNavigationMenuDisplayed() {
        return isElementDisplayed(NAVIGATION_MENU);
    }
    
    /**
     * Get navigation menu text
     */
    public String getNavigationMenuText() {
        return getText(NAVIGATION_MENU);
    }
    
    /**
     * Check if featured products section is displayed
     */
    public boolean isFeaturedProductsDisplayed() {
        return isElementDisplayed(FEATURED_PRODUCTS);
    }
    
    /**
     * Get number of product cards
     */
    public int getProductCardsCount() {
        return driver.findElements(PRODUCT_CARDS).size();
    }
    
    /**
     * Click on first product's add to cart button
     */
    public void clickFirstProductAddToCart() {
        click(ADD_TO_CART_BUTTON);
    }
    
    /**
     * Click on first product's add to wishlist button
     */
    public void clickFirstProductAddToWishlist() {
        click(ADD_TO_WISHLIST_BUTTON);
    }
    
    /**
     * Subscribe to newsletter
     */
    public void subscribeToNewsletter(String email) {
        sendKeys(NEWSLETTER_EMAIL, email);
        click(NEWSLETTER_SUBSCRIBE_BUTTON);
    }
    
    /**
     * Check if newsletter success message is displayed
     */
    public boolean isNewsletterSuccessMessageDisplayed() {
        return isElementDisplayed(NEWSLETTER_SUCCESS_MESSAGE);
    }
    
    /**
     * Get newsletter success message text
     */
    public String getNewsletterSuccessMessage() {
        return getText(NEWSLETTER_SUCCESS_MESSAGE);
    }
    
    /**
     * Click on Facebook social link
     */
    public void clickFacebookLink() {
        click(FACEBOOK_LINK);
    }
    
    /**
     * Click on Twitter social link
     */
    public void clickTwitterLink() {
        click(TWITTER_LINK);
    }
    
    /**
     * Click on Instagram social link
     */
    public void clickInstagramLink() {
        click(INSTAGRAM_LINK);
    }
    
    /**
     * Click on LinkedIn social link
     */
    public void clickLinkedInLink() {
        click(LINKEDIN_LINK);
    }
    
    /**
     * Check if footer is displayed
     */
    public boolean isFooterDisplayed() {
        return isElementDisplayed(FOOTER);
    }
    
    /**
     * Get footer text
     */
    public String getFooterText() {
        return getText(FOOTER);
    }
    
    /**
     * Get copyright text
     */
    public String getCopyrightText() {
        return getText(COPYRIGHT);
    }
    
    /**
     * Scroll to footer
     */
    public void scrollToFooter() {
        scrollToElement(FOOTER);
    }
    
    /**
     * Scroll to featured products
     */
    public void scrollToFeaturedProducts() {
        scrollToElement(FEATURED_PRODUCTS);
    }
    
    /**
     * Get page title
     */
    public String getHomePageTitle() {
        return getPageTitle();
    }
    
    /**
     * Wait for page to load completely
     */
    public void waitForPageLoad() {
        waitForElementVisible(LOGO);
        waitForElementVisible(NAVIGATION_MENU);
    }
}
