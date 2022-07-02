package com.cg.Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features="Resources",
		glue="com.cg.Definition")
public class Runner {

}
