package Testing.Testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeapYearTest {

	@Test
	public void leapYearsAreDivisibleByFour() {
		assertTrue(LeapYear.isLeapYear(2016));
	}

	@Test
	public void normalYearsAreNotDivisibleBYFour() {
		assertFalse(LeapYear.isLeapYear(3));
	}
	
	@Test
	public void leapYearsAreNotDivisibleByOneHundred(){
		assertFalse(LeapYear.isLeapYear(900));
	}
	
	@Test
	public void leapYearsAreDivisibleByFpourHundred(){
		assertTrue(LeapYear.isLeapYear(2000));
	}
	

}
