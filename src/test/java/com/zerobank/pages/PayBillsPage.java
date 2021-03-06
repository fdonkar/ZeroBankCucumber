package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage{

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayee;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    public WebElement account;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id = "alert_content")
    public WebElement message;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropdown;

    @FindBy(id = "pc_amount")
    public WebElement amountOfCurrency;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCosts;

    @FindBy(id = "sp_amount")
    public WebElement amountSavedPayee;

    @FindBy(id = "sp_date")
    public WebElement dateSavedPayee;

    @FindBy(id = "sp_description")
    public WebElement descriptionSavedPayee;

    @FindBy(id = "pay_saved_payees")
    public WebElement paySavedPayee;

    @FindBy(id = "alert_content")
    public WebElement warningMessage;

    @FindBy(xpath = "//div[@id='alert_content']")
    public List<WebElement> messageForVerifyingAmount;



}
