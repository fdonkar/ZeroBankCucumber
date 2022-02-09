package com.zerobank.stepdefinitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccountSummaryStepDefs {

    @Then("Account summary page should be displayed and have the title {string}")
    public void account_summary_page_should_be_displayed_and_have_the_title(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals("actual title is NOT as expected", expectedTitle,actualTitle);
    }
}
