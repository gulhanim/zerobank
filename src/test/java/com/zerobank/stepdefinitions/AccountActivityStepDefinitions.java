package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityStepDefinitions {
 AccountActivityPage accountActivityPage= new AccountActivityPage();
 LoginPage loginPage = new LoginPage();

    @Then("user navigates to {string} page")
    public void user_navigates_to_page(String accountActivityElm) {
        loginPage.navigateTo(accountActivityElm);

    }

    @When("Account dropdown should have {string} selected")
    public void Account_dropdown_should_have_selected(String defaultValuee) {
        Assert.assertTrue(accountActivityPage.isSelected(defaultValuee));
            }
    @Then("user verifies that dropdown menu has the following options")
    public void user_verifies_that_dropdown_menu_has_the_following_options(List<String> dataTable) {
        List<String> listOfOptions = new ArrayList<>();
        for (int i=1; i<=dataTable.size(); i++){
            listOfOptions.add((BrowserUtils.ListOfString(accountActivityPage.dropDownOptions).get(i)));
        }
      Assert.assertEquals(dataTable, listOfOptions);

    }

    @Then("user verifies that transactions table column names are")
    public void user_verifies_that_transactions_table_column_names_are(List<String> dataTable) {
       BrowserUtils.waitForVisibility(Driver.get().findElement(By.cssSelector("#all_transactions_for_account")), 5);
        List<String> columnNames = BrowserUtils.ListOfString(accountActivityPage.columnNames);
        Assert.assertEquals(dataTable, columnNames);
        System.out.println(columnNames);
    }
    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed_tab_order_number(String expected ) {
   Assert.assertEquals(expected, accountActivityPage.accountActivityModule.getText());
    }

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
       accountActivityPage.findTransactions.click();
    }

//    #================================#//


    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String until) {
        BrowserUtils.wait(3);
        accountActivityPage.datesFrom.clear();
        accountActivityPage.datesFrom.sendKeys(from);
        accountActivityPage.untilDate.clear();
        accountActivityPage.untilDate.sendKeys(until);
        BrowserUtils.wait(3);
    }

    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.wait(1);
    accountActivityPage.findButton.click();

    }

    @Then("results should only show transactions dates between {string} to {string}")
    public void results_should_only_show_transactions_dates_between_to(String from, String until) {
       for (WebElement each : accountActivityPage.datesFromResultTable) {
           System.out.println(each.getText());
           Assert.assertTrue(each.getText().compareTo(from)>=0);
           Assert.assertTrue(each.getText().compareTo(until)<=0);
       }
    }

    @Then("the result should be sorted by most recent date")
    public void the_result_should_be_sorted_by_most_recent_date() {
        List<String> list =BrowserUtils.ListOfString(accountActivityPage.datesFromResultTable);
        for(int i=0; i<list.size()-1; i++ ){
            Assert.assertTrue(list.get(i).compareTo(list.get(i+1))>=0); // this will compare if the list is sorted by date

        }
        System.out.println(list);
    }

    @Then("the result table should only not contain transaction dated {string}")
    public void the_result_table_should_only_not_contain_transaction_dated(String except) {
        List<String> list =BrowserUtils.ListOfString(accountActivityPage.datesFromResultTable);
        Assert.assertFalse(list.contains(except));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        BrowserUtils.waitForVisibility(accountActivityPage.findDescriptionBox, 5);
   accountActivityPage.findDescriptionBox.clear();

          description = description.toUpperCase();
         accountActivityPage.findDescriptionBox.sendKeys(description);
    }

    @Then("the result table should only show descriptions containing {string}")
    public void the_result_table_should_only_show_descriptions_containing(String result) {
        List<String> list;


        //    BrowserUtils.waitForVisibility(accountActivityPage.descriptionColumn, 5);
           BrowserUtils.wait(1);
            list = BrowserUtils.ListOfString(accountActivityPage.descriptionsResultList);
            System.out.println(list);
            for (String each : list) {
                Assert.assertTrue(each.contains(result));
            }
    }

//
//    //###############################3
//    @Then("result table should only show descriptions containing {string}")
//    public void result_table_should_only_show_descriptions_containing(String result) {
//
//        List<String> list2;
//
//           //   BrowserUtils.waitForVisibility(accountActivityPage.descriptionColumn, 5);
//            BrowserUtils.wait(1);
//            list2 = BrowserUtils.ListOfString(accountActivityPage.descriptionsResultList);
//            System.out.println(list2);
//            for (String each : list2) {
//                Assert.assertTrue(each.contains(result));
//            }
//        }



    //##############################

    @Then("result table should not show description containing {string}")
    public void result_table_should_not_show_description_containing(String result) {
    List<String> results = BrowserUtils.ListOfString(accountActivityPage.descriptionsResultList);
    for (String each : results){
        Assert.assertFalse(each.contains(result));
    }
    }

    @Then("result table should show at least one result under {string}")
    public void result_table_should_show_at_least_one_result_under(String string) {
        List<String> list;
        List<String> list2;

        switch (string) {
            case "Deposit":
                BrowserUtils.wait(1);
                list = BrowserUtils.ListOfString(accountActivityPage.depositTable);
                Assert.assertTrue(list.size() > 0);
                break;
            case "Withdrawal":
                BrowserUtils.wait(1);
                list2 = BrowserUtils.ListOfString(accountActivityPage.withdrawalTable);
                Assert.assertTrue(list2.size() > 0);
                break;


        }
    }





    @When("user selects type{string}")
    public void user_selects_type(String slctValue) {
        Select select = new Select(accountActivityPage.selectElement);
        BrowserUtils.waitForVisibility(accountActivityPage.selectElement, 5);
       switch (slctValue) {
           case "Deposit":

               select.selectByVisibleText("Deposit");
               BrowserUtils.wait(1);
               break;
           case  "Withdrawal":

               select.selectByVisibleText("Withdrawal");
               BrowserUtils.wait(1);
               break;

       }

    }
    @Then("result table should not show result under Withdrawal")
    public void result_table_should_not_show_result_under_Withdrawal() {

            List<String> list2 = new ArrayList<>();
            BrowserUtils.wait(1);
            for (WebElement each : accountActivityPage.withdrawalTable) {
                list2.add(each.getText().trim());
            }
            Assert.assertFalse(list2.isEmpty());
        System.out.println(list2);
    }
    @Then("result table should not show result under Deposit")
    public void result_table_should_not_show_result_under_Deposit() {
        List<String> list = new ArrayList<>();
        BrowserUtils.wait(1);
        for (WebElement each : accountActivityPage.depositTable) {
            list.add(each.getText().trim());
        }
        Assert.assertFalse(list.isEmpty());
        System.out.println(list);

    }


    }


