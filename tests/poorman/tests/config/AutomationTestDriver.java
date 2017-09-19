package poorman.tests.config;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import poorman.tests.sorting.SortingTestSuite;

public class AutomationTestDriver {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(SortingTestSuite.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());

		}

		if (result.wasSuccessful()) {
			System.out.println("All " + result.getRunCount() + " tests were successful");
		}
	}

}
