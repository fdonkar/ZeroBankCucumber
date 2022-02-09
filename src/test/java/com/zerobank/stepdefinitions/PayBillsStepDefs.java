package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.cs.Ale;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PayBillsStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();

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

    @When("the user select payee and accounts and enters value for date and description only")
    public void the_user_select_payee_and_accounts_and_enters_value_for_date_and_description_only() {
        String currentDate = dateFormat.format(date);
        payBillsPage.dateSavedPayee.sendKeys(currentDate);
        payBillsPage.descriptionSavedPayee.sendKeys("Natural Gas");
    }

    @Then("the user should not be able to pay and {string} should be displayed")
    public void the_user_should_not_be_able_to_pay_and_should_be_displayed(String expectedMessage) {

    }

    @When("the user select payee and accounts and enters value for amount and description only")
    public void theUserSelectPayeeAndAccountsAndEntersValueForAmountAndDescriptionOnly() {
        payBillsPage.amountSavedPayee.sendKeys("100");
        payBillsPage.descriptionSavedPayee.sendKeys("Natural Gas");
    }

    @Then("the user should not be able to pay and {string} should be displayed for amount")
    public void theUserShouldNotBeAbleToPayAndShouldBeDisplayedForAmount(String expectedMessage) {
        String actualMessage = payBillsPage.amountSavedPayee.getAttribute("validationMessage");
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals("messages NOT matched", expectedMessage,actualMessage);
    }

    @Then("the user should not be able to pay and {string} should be displayed for date")
    public void theUserShouldNotBeAbleToPayAndShouldBeDisplayedForDate(String expectedMessage) {
        String actualMessage = payBillsPage.dateSavedPayee.getAttribute("validationMessage");
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals("messages NOT matched", expectedMessage,actualMessage);
    }

    @When("the user enters alphabetical or special character {string} into the amount field")
    public void theUserEntersAlphabeticalOrSpecialCharacterIntoTheAmountField(String character) {
        payBillsPage.amountSavedPayee.sendKeys(character);
    }

    @Then("amount field should not accept alphabetical or special characters")
    public void amountFieldShouldNotAcceptAlphabeticalOrSpecialCharacters() {
        String expectedText = "";
        String actualText = payBillsPage.amountSavedPayee.getAttribute("value");
        System.out.println("actualText = " + actualText);
        Assert.assertEquals("Amount field accept alphabetical or special character",expectedText,actualText);
    }
}
