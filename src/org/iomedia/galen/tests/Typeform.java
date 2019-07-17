package org.iomedia.galen.tests;

import org.iomedia.framework.Driver;
import org.iomedia.galen.pages.TypeformPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;

@CucumberOptions(plugin = "json:target/cucumber-report-feature-composite.json", format = "pretty", features = {"features/typeform.feature"}, glue = {"org.iomedia.galen.steps"}, monochrome = true, strict = true)	
public class Typeform extends Driver {
	
	boolean enable_typeform = false;
	TypeformPage typeformpage;
	
	@BeforeMethod(alwaysRun=true)
	public void init() {
		typeformpage = new TypeformPage(driverFactory, Dictionary, Environment, Reporter, Assert, SoftAssert, sTestDetails);
		if(!enable_typeform) {
			enable_typeform = typeformpage.enableTypeForm();
		}
	}
	
	@Test(groups={"smoke","regression","typeform"}, priority = 1)
	public void verifytypeform() throws Throwable {
		runScenario(Dictionary.get("SCENARIO"));
	}
}