package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "#account_summary_tab")
    public WebElement accountSummary;

    @FindBy(css = "#account_activity_tab")
    public WebElement accountActivity;

    @FindBy(linkText = "Pay Bills")
    public WebElement payBills;


}
