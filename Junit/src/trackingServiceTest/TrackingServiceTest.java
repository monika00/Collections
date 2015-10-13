package trackingServiceTest;

import static org.junit.Assert.*;

import org.junit.Test;

import trackingService.TrackingService;

public class TrackingServiceTest {
	
	@Test
	public void NewTrackingServiceTotalIsZero(){
		
		TrackingService service = new TrackingService();
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	@Test
	public void WhenAddingProteinTotalIncreasedByAmount(){
		
		TrackingService service = new TrackingService();
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
	}

}
