package poorman.algorithms.tests.config;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import poorman.algorithms.tests.BogoSortTest;
import poorman.algorithms.tests.BubbleSortTest;
import poorman.algorithms.tests.BucketSortTest;
import poorman.algorithms.tests.InsertionSortTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   BogoSortTest.class,
   BubbleSortTest.class,
   BucketSortTest.class,
   InsertionSortTest.class
})

public class JunitTestSuite {


}
