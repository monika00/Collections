package trackingServiceTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import trackingService.InvalidGoalException;
import trackingService.TrackingService;

public class TrackingServiceTest {
	
	private static TrackingService service;
	
	@BeforeClass
	public static void before(){
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void after(){
		System.out.println("AfterClass");
	}
	
	@Before
	public void setUp(){
		System.out.println("Before");
		service = new TrackingService();
	}
	
	@After
	public void tearDown(){
		System.out.println("After");
	}

	@Test
	@Category(GoodTestCategory.class)
	public void NewTrackingServiceTotalIsZero(){
		
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	@Test
	@Category(GoodTestCategory.class)
	public void WhenAddingProteinTotalIncreasedByAmount(){
		
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
	}
	
	@Test
	@Category(GoodTestCategory.class)
	public void WhenRemovingProteinTotalRemainsZero(){
		
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
	
	@Test(expected = InvalidGoalException.class)
	public void whenGoalIsSetLessThanZeroExceptionIsThrown() throws InvalidGoalException{
		service.setGoal(-1);
	}
	
	@Test(timeout=200)
	public void badTest(){
		for(int i=0;i<10;i++){
			service.addProtein(1);
		}
	}
}
