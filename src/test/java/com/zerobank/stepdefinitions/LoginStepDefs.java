package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("zerobank.url"));
        loginPage.firstSignIn.click();
    }

    @When("the user enters the valid username and password")
    public void the_user_enters_the_valid_username_and_password() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password"));
        loginPage.secondSignIn.click();
        Driver.get().navigate().back();
        loginPage.onlineBanking.click();
        loginPage.accountSummary.click();
    }

    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        String expectedPage = "Zero - Account Summary";
        String actualPage = Driver.get().getTitle();
        System.out.println("actualPage = " + actualPage);
        Assert.assertEquals("the user is NOT on the account summary page", expectedPage,actualPage);
    }

    @When("the user enters the invalid username and valid password")
    public void theUserEntersTheInvalidUsernameAndValidPassword() {
        loginPage.usernameInput.sendKeys("user");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("password"));
        loginPage.secondSignIn.click();
    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = loginPage.warningMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals("Warning message is NOT as expected", expectedMessage,actualMessage);
    }

    @When("the user enters the valid username and invalid password")
    public void theUserEntersTheValidUsernameAndInvalidPassword() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("username"));
        loginPage.passwordInput.sendKeys("pass");
        loginPage.secondSignIn.click();

    }
}
