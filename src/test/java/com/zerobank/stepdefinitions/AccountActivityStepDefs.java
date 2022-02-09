package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("Account activity page should be displayed and have the title {string}")
    public void account_activity_page_should_be_displayed_and_have_the_title(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals("titles NOT match",expectedTitle,actualTitle);
    }

    @And("Account dropdown should have following options")
    public void accountDropdownShouldHaveFollowingOptions(List<String> expectedOptions) {

        Select select = new Select(accountActivityPage.accountDropdown);
        List<String> actualOptions = BrowserUtils.getElementsText(select.getOptions());
        System.out.println("actualOptions = " + actualOptions);
        Assert.assertEquals("options NOT matched", expectedOptions,actualOptions);
    }

    @And("Transactions table should have following columns")
    public void transactionsTableShouldHaveFollowingColumns(List<String> expectedColumns) {

        List<String> actualColumns = BrowserUtils.getElementsText(accountActivityPage.transactionsColumns);
        System.out.println("actualColumns = " + actualColumns);
        Assert.assertEquals("column names NOT matched", expectedColumns, actualColumns);

    }
}
