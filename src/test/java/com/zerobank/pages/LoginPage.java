package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement firstSignIn;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement secondSignIn;

    @FindBy(xpath = "//button[@id='details-button']")
    public WebElement advancedButton;

    @FindBy(xpath = "//a[@id='proceed-link']")
    public WebElement proceedButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement warningMessage;

    @FindBy(css = "#onlineBankingMenu>div>strong")
    public WebElement onlineBanking;

    @FindBy(id = "account_summary_link")
    public WebElement accountSummary;

    public void login(){
        firstSignIn.click();
        usernameInput.sendKeys(ConfigurationReader.get("username"));
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        secondSignIn.click();
        Driver.get().navigate().back();
        onlineBanking.click();
        accountSummary.click();
    }

}
