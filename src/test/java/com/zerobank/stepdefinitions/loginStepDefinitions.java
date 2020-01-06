package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class loginStepDefinitions {
LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("env"));
    }

    @Then("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
      String username = ConfigurationReader.getProperty("username");
      String password = ConfigurationReader.getProperty("password");

      loginPage.login(username, password);
    }

    @Then("user verifies that {string} page is displayed")
    public void user_verifies_that_page_is_displayed(String pageSubTitle) {
    Assert.assertEquals(pageSubTitle, loginPage.SubModuleNames());
        System.out.println(loginPage.SubModuleNames());
    }

    @Then("user enters invalid {string} and {string} credentials and verifies {string} message")
    public void user_enters_invalid_and_credentials_and_verifies_message(String username, String password, String message) {

        loginPage.login(username,password);
        Assert.assertEquals(message, loginPage.InvalidMessage());
        System.out.println(loginPage.InvalidMessage());
    }

}
