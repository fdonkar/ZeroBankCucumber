package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("Account summary page should be displayed and have the title {string}")
    public void account_summary_page_should_be_displayed_and_have_the_title(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals("actual title is NOT as expected", expectedTitle,actualTitle);
    }

    @Then("Account summary page should have following account types")
    public void account_summary_page_should_have_following_account_types(List<String> expectedAccountTypes) {

        List<String> actualAccountTypes = BrowserUtils.getElementsText(accountSummaryPage.accountTypes);
        System.out.println("actualAccountTypes = " + actualAccountTypes);
        Assert.assertEquals("account types NOT matched", expectedAccountTypes,actualAccountTypes);
    }

    @Then("Credit Accounts table should have following columns")
    public void credit_Accounts_table_should_have_following_columns(List<String> expectedColumnNames) {
        List<String> actualColumnNames = BrowserUtils.getElementsText(accountSummaryPage.columnsOfCreditAccountTable);
        System.out.println("actualColumnNames = " + actualColumnNames);
        Assert.assertEquals("column names NOT matched",expectedColumnNames,actualColumnNames);
    }
}
