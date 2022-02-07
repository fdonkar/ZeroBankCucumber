package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummaryPage extends BasePage{

    @FindBy(linkText = "Savings")
    public WebElement savings;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerage;

    public WebElement linkTextLocator(String str){
        return Driver.get().findElement(By.linkText(str));
    }

}
