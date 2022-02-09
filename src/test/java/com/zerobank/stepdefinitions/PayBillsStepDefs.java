package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @When("the user select payee and accounts and enters value for amount, date, and description")
    public void the_user_select_payee_and_accounts_and_enters_value_for_amount_date_and_description() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        payBillsPage.dateSavedPayee.sendKeys(currentDate);
        payBillsPage.amountSavedPayee.sendKeys("100");
        payBillsPage.descriptionSavedPayee.sendKeys("Natural Gas");
    }

    @When("clicks on pay button")
    public void clicks_on_pay_button() {
        payBillsPage.paySavedPayee.click();
    }

    @Then("warning message {string} should be displayed")
    public void warning_message_should_be_displayed(String expectedMessage) {
        String actualMessage = payBillsPage.warningMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals("messages NOT matched",expectedMessage,actualMessage);
    }
}
