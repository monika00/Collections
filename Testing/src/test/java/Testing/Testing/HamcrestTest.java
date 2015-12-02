package Testing.Testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

public class HamcrestTest {
	
	@Test
	public void mapShoudContainValue(){
		Map<String, Integer> values = getValues();
		
		assertThat(values, Matchers.hasKey("B"));
	}
	
	private Map<String, Integer> getValues(){
		final HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		return map;
	}
	
	@Test
	public void listOrderingIsIrrelevant(){
		List<Integer> numbers = getNumbers();
		
		assertThat(numbers, Matchers.hasItem(5));
	}
	
	private List<Integer> getNumbers(){
		
		return Arrays.asList(1, 2, 3, 4, 5);
	}

}
