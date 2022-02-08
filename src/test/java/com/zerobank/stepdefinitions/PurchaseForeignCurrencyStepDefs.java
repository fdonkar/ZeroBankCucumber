package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.cs.Ale;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @When("the user accesses the Purchase Foreign Currency tab")
    public void the_user_accesses_the_Purchase_Foreign_Currency_tab() {
       payBillsPage.purchaseForeignCurrencyTab.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedResult) {
        Select select = new Select(payBillsPage.currencyDropdown);
        List<String> actualResult = BrowserUtils.getElementsText(select.getOptions());
        actualResult.remove(0);
        System.out.println("actualResult = " + actualResult);
        Assert.assertTrue(actualResult.containsAll(expectedResult));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        Select select = new Select(payBillsPage.currencyDropdown);
        String selectedOption = select.getFirstSelectedOption().getText();
        System.out.println("selectedOption = " + selectedOption);
        payBillsPage.amountOfCurrency.sendKeys("17");
        payBillsPage.calculateCosts.click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.get().switchTo().alert();
        String alertText = alert.getText();
        System.out.println("alertText = " + alertText);
        String expectedMessage = "Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(expectedMessage,alertText);
    }

    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        Select select = new Select(payBillsPage.currencyDropdown);
        select.selectByValue("EUR");
        String selectedOption = select.getFirstSelectedOption().getText();
        System.out.println("selectedOption = " + selectedOption);
        payBillsPage.calculateCosts.click();
    }
}
