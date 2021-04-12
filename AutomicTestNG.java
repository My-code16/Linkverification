package automicgrp;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class AutomicTestNG {

	public static void main(String[] args) {
		TestNG testngmain = new TestNG();
		List<String> suites = new ArrayList<String>();
		suites.add("/automicgrp/testngmain.xml");
		testngmain.setTestSuites(suites);
		testngmain.setTestClasses(new Class[] { Abnautomation_run.class });
		testngmain.run();
	}

}
