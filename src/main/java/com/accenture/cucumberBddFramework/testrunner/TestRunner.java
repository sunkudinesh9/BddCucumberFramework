package com.accenture.cucumberBddFramework.testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "F:\\java ide photon\\BddCucumberFramework\\src\\main\\java\\com\\accenture\\cucumber\\BddCucumberFramework\\feature\\login.feature", glue = {
		"com.accenture.cucumberBddFramework.defination" },
		dryRun=false,
		strict=false,
		format= {"pretty", "html:html_output", "json:json_output/cucumber.json"},
		monochrome = true)
public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass
	public void setUp() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "cucumber feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeatureWrapper) {
		testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass
	public void tearDownClss() {
		testNGCucumberRunner.finish();
	}
}
