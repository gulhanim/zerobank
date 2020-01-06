package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillsPage {

    @FindBy(linkText = "Pay Saved Payee")
    public WebElement savedPayee;

    @FindBy(css = "[id='sp_amount']")
    public WebElement amountInputBox;

    @FindBy(css = "#sp_date")
    public WebElement dateInputBox;

    @FindBy(css = "#sp_description")
    public WebElement descriptionInputBox;

    @FindBy(css = "#pay_saved_payees")
    public WebElement payButton;

    @FindBy(css = "#alert_content>span")
    public WebElement paymentSuccessMessage;

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayee;

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }



    public void Fill_PaySavedPayee(String money, String date, String description){


      if (!savedPayee.isSelected()){
          savedPayee.click();
      }
        BrowserUtils.wait(1);
        amountInputBox.sendKeys(money);

        dateInputBox.sendKeys(date);
        descriptionInputBox.sendKeys(description);
        payButton.click();

    }



}
