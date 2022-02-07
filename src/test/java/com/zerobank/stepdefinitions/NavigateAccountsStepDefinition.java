package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class NavigateAccountsStepDefinition {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("zerobank.url"));
        new LoginPage().login();
    }


    @Then("the {string} page should be displayed")
    public void thePageShouldBeDisplayed(String page) {
        BrowserUtils.waitFor(1);
        Assert.assertEquals(page + " page is NOT displayed","Zero - " + page,Driver.get().getTitle());
    }

    @And("Account	drop down should have {string} selected")
    public void accountDropDownShouldHaveSelected(String expectedResult) {
        Assert.assertEquals(expectedResult + " is NOT selected", expectedResult, new AccountActivityPage().getAccountSelected());
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void theUserClicksOnLinkOnTheAccountSummaryPage(String link) {
        new AccountSummaryPage().linkTextLocator(link).click();
    }
}
