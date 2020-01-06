package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class PayBillsStepDefinitions {
    PayBillsPage payBillsPage = new PayBillsPage();
    int a;
    @Then("user enter payment amount{string} dollars and date:{string} and clicks pay button")
    public void user_enter_payment_amount_dollars_and_date_and_clicks_pay_button(String money, String date) {
            payBillsPage.Fill_PaySavedPayee(money, date,"");


    }

    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String message) {
        BrowserUtils.wait(1);
      Assert.assertEquals(message,payBillsPage.paymentSuccessMessage.getText());
    }

    @Then("user verifies {string} alert is displayed")
    public void user_verifies_alert_is_displayed(String errorMessage) {
        payBillsPage.payButton.click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.get();
        String locator;
        if(a==1){
            locator = "sp_amount";
        } else {
            locator = "sp_date";
        }
        String actual = (String) javascriptExecutor.executeScript("return JSON.stringify(document.getElementById('"+locator+"').validationMessage);");
        Assert.assertEquals("\""+errorMessage+"\"", actual);
    }

}
