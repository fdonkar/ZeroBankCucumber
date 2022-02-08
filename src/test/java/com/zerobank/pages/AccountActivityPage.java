package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[1]")
    public List<WebElement> transactionsDates;

    public String getAccountSelected(){
        Select select = new Select(accountDropdown);
        String actualResult = select.getFirstSelectedOption().getText();
        return actualResult;
    }

    public boolean isRangeBetween(String fromDateStr, String toDateStr) throws ParseException {
        datesFromPage = new ArrayList<>();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = dateFormat.parse(fromDateStr);
        Date toDate = dateFormat.parse(toDateStr);
        boolean flag = true;
        for (Date each : datesFromPage) {
            if (each.before(fromDate)){
                flag = false;
                break;
            }

            if (each.after(toDate)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean isDatesSorted() throws ParseException {
        datesFromPage = new ArrayList<>();
        boolean flag = true;
        for (int i=0;i<datesFromPage.size()-1;i++) {
            if(datesFromPage.get(i).before(datesFromPage.get(i+1))){
                flag = false;
                break;
            }
        }
        return flag;
    }

    List<Date> datesFromPage;
    public List<Date> getTransactionsDates() throws ParseException {
        datesFromPage = new ArrayList<>();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

        for (WebElement each : transactionsDates) {
            datesFromPage.add(dateFormat.parse(each.getText()));
        }

        return datesFromPage;
    }

}
