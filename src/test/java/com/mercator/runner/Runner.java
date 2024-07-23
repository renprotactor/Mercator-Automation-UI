package com.mercator.runner;

import com.mercator.utils.Driver;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@test",
        glue = {"com.mercator.steps"},
        features = {"src/test/java/com/mercator/features"},
        plugin = {"pretty",
                "html:target/cucumber-reports/html-report.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true)

public class Runner {

    @BeforeClass
    public static void setUp() {
        // Ensure the cucumber-reports directory is created
        File reportDir = new File("target/cucumber-reports");
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

    }

    @AfterClass
    public static void quitDriver() {
        Driver.stopDriver();

    }
}

