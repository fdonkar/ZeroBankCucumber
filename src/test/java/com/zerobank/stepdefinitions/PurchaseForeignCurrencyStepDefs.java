package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
}
