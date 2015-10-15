package trackingServiceTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import trackingService.HistoryItem;
import trackingService.InvalidGoalException;
import trackingService.NotifierStub;
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
		service = new TrackingService(new NotifierStub());
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
		assertThat(service.getTotal(), is(10));
		
		assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class)));
	}
	
	@Test
	@Category(GoodTestCategory.class)
	public void WhenRemovingProteinTotalRemainsZero(){
		
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
	
	@Test
	public void whenGoalIsMetHistoryIsUpadated() throws InvalidGoalException{
		service.setGoal(5);
		service.addProtein(6);
		
		HistoryItem result = service.getHistory().get(1);
		assertEquals("sent:goal met", result.getOperation());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test(expected = InvalidGoalException.class)
	public void whenGoalIsSetLessThanZeroExceptionIsThrown() throws InvalidGoalException{
		thrown.expect(InvalidGoalException.class);
		thrown.expectMessage("Goal was less than zero");
		service.setGoal(-5);
	}
	
	@Rule
	public Timeout timeout = new Timeout(20);
	
	@Test
	public void badTest(){
		for(int i=0;i<10;i++){
			service.addProtein(1);
		}
	}
}
