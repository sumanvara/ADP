package junitRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (features = "main/features"
					,glue = {"stepDefinitions"}
					,monochrome = true		
				 )

public class RunFeatures {

}
