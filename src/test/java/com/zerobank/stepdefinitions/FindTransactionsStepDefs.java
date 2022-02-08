package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.ParseException;
import java.util.List;

public class FindTransactionsStepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user clicks on Account Activity Page")
    public void the_user_clicks_on_Account_Activity_Page() {
        new AccountSummaryPage().accountActivity.click();
    }

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        accountActivityPage.findTransactions.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDates, String toDates) {
        accountActivityPage.fromDates.clear();
        accountActivityPage.toDates.clear();
        accountActivityPage.fromDates.sendKeys(fromDates);
        accountActivityPage.toDates.sendKeys(toDates);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {
        Assert.assertTrue("dates are OUT of range", accountActivityPage.isRangeBetween(fromDate,toDate));
    }

    @Then("the results should be sorted by most recent day")
    public void the_results_should_be_sorted_by_most_recent_day() throws ParseException {
        Assert.assertTrue("dates is NOT sorted",accountActivityPage.isDatesSorted());

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        List<String> elementsText = BrowserUtils.getElementsText(accountActivityPage.transactionsDates);
        System.out.println(elementsText);
        Assert.assertFalse(elementsText.contains(date));

    }

    @And("clicks find")
    public void clicksFind() {
        accountActivityPage.findButton.click();
        BrowserUtils.waitFor(1);
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        accountActivityPage.description.clear();
        accountActivityPage.description.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        Assert.assertTrue("results NOT contain " + description,accountActivityPage.isContains(description));

    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String excludeDescription) {
        List<String> descriptionsText = BrowserUtils.getElementsText(accountActivityPage.transactionsDescription);
        for (String each : descriptionsText) {
            Assert.assertFalse(each.contains(excludeDescription));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String type) {
        Assert.assertTrue("list is EMPTY",accountActivityPage.atLeastOneResult(type));
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String type) {
        Assert.assertTrue("list is NOT empty", accountActivityPage.isEmptyResult(type));
    }

    @When("user selects type {string}")
    public void user_selects_type(String option) {
        accountActivityPage.selectType(option);
    }




}
