package com.zerobank.stepdefinitions;

import com.zerobank.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {

    @Before
    public void setup(){
        System.out.println("Test setup");
    }
    @After
    public void teardown(Scenario scenario){
        if (scenario.isFailed()){
            System.out.println("Test Failed");
            byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }else{
            System.out.println("CleanUp!");
            System.out.println("Test completed");
        }
        Driver.close();

    }

}
