package com.qa.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\QA\\CucumberWorkSpace\\BDDCucumberPOM\\src\\main\\java\\com\\qa\\features\\freecrm.feature",
		glue= {"com/qa/stepDefinitions"},
	    plugin = {"pretty","html:html_output/test-output.html","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},
	    monochrome=true,
	    dryRun = false
	   // tags = "@SmokeTest or @RegressionTest"
		)


public class TestRunner {
	



}
