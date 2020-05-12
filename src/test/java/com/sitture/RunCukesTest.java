package com.sitture;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        tags = {},
        snippets = SnippetType.CAMELCASE,
        plugin = {"html:output/html-report", "com.sitture.ExtentFormatter:output/extent-report/index.html"}
)
public class RunCukesTest {

    @BeforeClass
    public static void before() {
        ExtentReporter.setConfig("src/test/resources/config.xml");
    }
    
    @AfterClass
    public static void setup() {
   
    }

}
