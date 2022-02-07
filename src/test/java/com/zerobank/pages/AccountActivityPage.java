package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{


    @FindBy(css ="#aa_accountId")
    public WebElement accountDropdown;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> transactionsTable;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactions;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDates;

    @FindBy(id = "aa_toDate")
    public WebElement toDates;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement findButton;

    public String getAccountSelected(){
        Select select = new Select(accountDropdown);
        String actualResult = select.getFirstSelectedOption().getText();
        return actualResult;
    }


}
