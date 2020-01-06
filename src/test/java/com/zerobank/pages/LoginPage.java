package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    @FindBy(id = "signin_button")
    public WebElement signInButton;

    @FindBy(id = "user_login")
    public WebElement userNameInput;

    @FindBy(id = "user_password")
    public WebElement passWordInput;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;

    @FindBy(name = "submit")
    public WebElement loginButton;

    @FindBy(linkText = "Account Summary")
    public WebElement AccountSummarySubModule;

    @FindBy(linkText = "Account Activity")
    public  WebElement accountActivityElement;

    @FindBy(linkText = "Pay Bills")
    public  WebElement payBillsElement;

    @FindBy(linkText = "Transfer Funds")
    public  WebElement transferFunds;


    @FindBy(css = "[class='span12'] li:nth-of-type(n)>a")
    public List<WebElement> subModuleElements;


   public LoginPage(){
       PageFactory.initElements(Driver.get(),this);
    }



    public void login(String userName, String passWord){
        BrowserUtils.waitForVisibility(signInButton, 10);
      signInButton.click();
        BrowserUtils.waitForVisibility(userNameInput, 10);
       userNameInput.sendKeys(userName);
       passWordInput.sendKeys(passWord);

       BrowserUtils.waitForClickablity(loginButton, 10);
       loginButton.click();
    }

    public String SubModuleNames(){
    return AccountSummarySubModule.getText();
    }
    public String InvalidMessage(){
       return warningMessage.getText();
    }

    public void navigateTo(String subAccount){
        switch (subAccount){
            case "Account Summary":
             AccountSummarySubModule.click();
             break;
            case "Account Activity":
                accountActivityElement.click();
                break;
            case "Pay Bills":
                payBillsElement.click();
                break;
            case "Transfer Funds":
                transferFunds.click();
                break;
        }
    }
}
