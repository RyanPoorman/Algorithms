package poorman.algorithms.tests.config;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class AutomationTestDriver {

   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(JunitTestSuite.class);
      
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      if(result.wasSuccessful()){
		System.out.println("All " + result.getRunCount() + " tests were successful");
	  }
   }
 

}
