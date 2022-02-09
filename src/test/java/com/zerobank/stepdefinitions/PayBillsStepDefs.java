package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBillsStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @When("the user clicks on Pay Bills Page")
    public void the_user_clicks_on_Pay_Bills_Page() {
        payBillsPage.payBills.click();
    }

    @Then("Pay Bills page should be displayed and have the title {string}")
    public void pay_Bills_page_should_be_displayed_and_have_the_title(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals("titles NOT matched",expectedTitle,actualTitle);
    }
}
