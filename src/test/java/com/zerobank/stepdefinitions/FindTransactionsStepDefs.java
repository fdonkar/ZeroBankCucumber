package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
        accountActivityPage.fromDates.sendKeys(fromDates);
        accountActivityPage.toDates.sendKeys(toDates);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the results should be sorted by most recent day")
    public void the_results_should_be_sorted_by_most_recent_day() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @And("clicks find")
    public void clicksFind() {
        accountActivityPage.findButton.click();
    }
}
