package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("the user accesses Pay Bills page")
    public void the_user_accesses_Pay_Bills_page() {
        payBillsPage.payBills.click();
    }

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        payBillsPage.addNewPayee.click();
    }

    @When("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {

        payBillsPage.payeeName.sendKeys(dataTable.get("Payee Name"));
        payBillsPage.payeeAddress.sendKeys(dataTable.get("Payee Address"));
        payBillsPage.account.sendKeys(dataTable.get("Account"));
        payBillsPage.payeeDetails.sendKeys(dataTable.get("Payee Details"));
        payBillsPage.addButton.click();

    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        String expectedMessage = "The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        String actualMessage = payBillsPage.message.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals("message NOT matched", expectedMessage,actualMessage);
    }

}
