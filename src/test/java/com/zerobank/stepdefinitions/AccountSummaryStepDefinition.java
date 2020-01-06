package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccounSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class AccountSummaryStepDefinition {

    AccounSummaryPage accounSummaryPage = new AccounSummaryPage();


    @Then("user verifies that page title is {string}")
    public void user_verifies_that_page_title_is(String title) {
    Assert.assertEquals(title, Driver.get().getTitle());


    }

    @Then("user verifies that SubAccounts Displayed")
    public void user_verifies_that_SubAccounts_Displayed()  {
        for (WebElement each : accounSummaryPage.subAccountsElements){
            BrowserUtils.waitForVisibility(each, 5);
            Assert.assertTrue(each.isDisplayed());
            System.out.println(each.getText());

        }
    }

    @Then("user verifies that Credit account's sub Accounts are displayed")
    public void user_verifies_that_Credit_account_s_sub_Accounts_are_displayed()  {
     for (WebElement each : accounSummaryPage.CreditSubAccountsElement){
        BrowserUtils.waitForVisibility(each, 5);
         Assert.assertTrue(each.isDisplayed());
         System.out.println(each.getText());

     }
    }



    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        switch (link){
            case "Savings":  accounSummaryPage.savings.click(); break;
            case "Brokerage":  accounSummaryPage.brokerage.click(); break;
            case "Checking":  accounSummaryPage.checking.click(); break;
            case "Credit card": accounSummaryPage.creditCard.click(); break;
            case "Loan":  accounSummaryPage.loan.click(); break;

        }
    }

}
