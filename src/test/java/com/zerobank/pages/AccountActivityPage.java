package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{


    @FindBy(css ="#aa_accountId")
    public WebElement accountDropdown;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> transactionsTable;

    public String getAccountSelected(){
        Select select = new Select(accountDropdown);
        String actualResult = select.getFirstSelectedOption().getText();
        return actualResult;
    }

}
