package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    //locators List

    private By username = By.xpath("//input[@id='user-name']");
    private By password = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='login-button']");
    private By navigationPanel = By.xpath("//button[@id='react-burger-menu-btn']");
    private By logoutButton = By.xpath("//a[contains(text(),'Logout')]");

    // Constructor when we create instance this auto calls
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements //encapsulation used here
    public WebElement getUsernameField() {
        return driver.findElement(username);
    }

    public WebElement getPasswordField() {
        return driver.findElement(password);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public WebElement navigationButt(){
        return driver.findElement(navigationPanel);
    }
    public WebElement logoutButt(){
        return driver.findElement(logoutButton);
    }

    // Method to log in
    public void login(String user, String pass) {
        getUsernameField().sendKeys(user);
        getPasswordField().sendKeys(pass);
        getLoginButton().click();
    }

    public void logout() throws InterruptedException {
        navigationButt().click();
        Thread.sleep(2000);
        logoutButt().click();
    }






}
