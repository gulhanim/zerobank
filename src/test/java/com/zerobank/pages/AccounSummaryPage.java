package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AccounSummaryPage {
    @FindBy(css = "[class='span12']>div>h2")
    public List<WebElement> subAccountsElements;

    @FindBy(css = "[class='board']:nth-of-type(3) table th")
    public List<WebElement> CreditSubAccountsElement;

    @FindBy(css = "[class='board']:nth-of-type(1) tbody>tr:nth-of-type(1) a")
   public WebElement savings;

    @FindBy(css = "[class='board']:nth-of-type(2) tbody>tr:nth-of-type(1) a")
    public WebElement brokerage;
    @FindBy(css = "[class='board']:nth-of-type(3) tbody>tr:nth-of-type(1) a")
    public WebElement checking;

    @FindBy(css = "[class='board']:nth-of-type(3) tbody>tr:nth-of-type(2) a")
    public WebElement creditCard;

    @FindBy(css = "[class='board']:nth-of-type(4) tbody>tr:nth-of-type(1) a")
    public WebElement loan
            ;
    public AccounSummaryPage(){ // constructor for Driver.Get() to find the elements
        PageFactory.initElements(Driver.get(),this);
    }

    public List<String> SubAcoountsList(){
        return BrowserUtils.ListOfString(subAccountsElements);
    }

    public void CreditSubAccounts(){

    }
}
