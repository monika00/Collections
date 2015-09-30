package Test2;

import static org.junit.Assert.assertEquals;  
import org.junit.After;  
import org.junit.AfterClass;  
import org.junit.Before;  
import org.junit.BeforeClass;  
import org.junit.Test;  
import Calculation.Calculation;  

public class Test2 {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		System.out.println("before class"); 
	}
	
	@Before
	public void setUp() throws Exception{
		System.out.println("before");
	}
	
	@Test
	public void testFindMax(){
		System.out.println("test case find max");
		assertEquals(4, Calculation.findMax(new int[]{1,3,4,2}));
		assertEquals(-2, Calculation.findMax(new int[] {-12,-3,-4,-2}));
	}
	
	
	@Test
	public void testCube(){
		System.out.println("test case cube");
		assertEquals(27, Calculation.cube(3));
	}
	
	@Test
	public void testReverseWord(){
		System.out.println("test case reverse word");
		assertEquals("as df fagghhh", Calculation.reverseWord("hhhggaf fd sa"));
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("after");
	}
	
	@AfterClass
	public static void tearDownAfterClass(){
		System.out.println("after Class");
	}

}
