package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage {


    @FindBy(css = "#aa_accountId")
    public WebElement  accountDropDown;

    @FindBy(css = "[id='aa_accountId'] option")
    public List<WebElement> dropDownOptions;

    @FindBy(css = "#all_transactions_for_account th")
    public List<WebElement> columnNames;

    @FindBy(css = "[class='span12'] li:nth-of-type(2)>a")
    public WebElement accountActivityModule;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactions;

    @FindBy(css = "#aa_fromDate")
    public WebElement datesFrom;

    @FindBy(css = "#aa_toDate")
    public WebElement untilDate;

    @FindBy(css = "[type='submit']")
    public WebElement findButton;

    @FindBy(css = "[id^='filtered'] tbody td:nth-of-type(1)")
    public List<WebElement> datesFromResultTable;

    @FindBy(css = "#aa_description")
    public WebElement findDescriptionBox;

    @FindBy(css = "[id^='filtered'] td:nth-of-type(2)")
    public List<WebElement> descriptionsResultList;

    @FindBy(css = "[id^='filtered'] tr:nth-of-type(1)>th:nth-of-type(2)")
    public WebElement descriptionColumn;

    @FindBy(css = "[id^='filtered'] tbody td:nth-of-type(3)")
    public List<WebElement> depositTable;

    @FindBy(css = "[id^='filtered'] tbody td:nth-of-type(4)")
    public List<WebElement> withdrawalTable;

    @FindBy(css = "[id='aa_type']")
    public WebElement selectElement;

    @FindBy(css = "#aa_type [value='DEPOSIT']")
    public WebElement depositDropDown;

    @FindBy(css = "#aa_type [value='WITHDRAWAL']")
    public WebElement withdrawalDropDown;

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public boolean isSelected(String accountType){
        Select select = new Select(accountDropDown);
        return select.getFirstSelectedOption().getText().equals(accountType);
    }
}
