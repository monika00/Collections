package trackingServiceTest;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@IncludeCategory(GoodTestCategory.class)
@Suite.SuiteClasses({
	HelloJUnitTest.class, 
	TrackingServiceTest.class})

public class GoodTestsSuite {

}
