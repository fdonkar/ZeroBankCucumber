package com.zerobank.stepdefinitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccountActivityStepDefs {

    @Then("Account activity page should be displayed and have the title {string}")
    public void account_activity_page_should_be_displayed_and_have_the_title(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals("titles NOT match",expectedTitle,actualTitle);
    }
}
