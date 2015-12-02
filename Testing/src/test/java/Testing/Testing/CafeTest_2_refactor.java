package Testing.Testing;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CafeTest_2_refactor {
	
	public static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();
	public static final int NO_MILK = 0;
	public static final int NO_BEANS = 0;
	
	private Cafe cafe;
	
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("before class");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("after class");
	}
	
	@Before
	public void beforeMethods(){
		cafe = new Cafe();
	}
	
	@Test
	public void canBrewEspresso(){
		withBeans();
		Coffee coffee = cafe.brew(CoffeeType.Espresso);
		
		Assert.assertEquals("Wrong Coffee type",CoffeeType.Espresso, coffee.getType());
		Assert.assertEquals("Wrong amount of milk",NO_MILK, coffee.getMilk());
		Assert.assertEquals("Wrong number of beans",ESPRESSO_BEANS, coffee.getBeans());
	}
	
	@Test
	public void brewingEspressoConsumesBeans(){
		withBeans();
		Coffee coffee = cafe.brew(CoffeeType.Espresso);
		
		Assert.assertEquals(NO_BEANS, cafe.getBeansInStock());	
	}
	
	@Test(expected = IllegalStateException.class)
	public void latteRequiresMilk(){
		withBeans();
		cafe.brew(CoffeeType.Latte);
		
	}
	
	private void withBeans(){
		cafe.restockBeans(7);
	}
}
