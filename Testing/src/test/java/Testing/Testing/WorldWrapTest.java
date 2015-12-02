package Testing.Testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldWrapTest {

	public static int LINE_LENGTH = 5;

	@Test
	public void lineShoudWrapIdOverLineLength() {
		String result = WordWrap.wrap("The Sleepy", LINE_LENGTH);
		assertEquals("The S\nleepy", result);
	}

	@Test
	public void shortLinesShouldNotWrap() {
		String result = WordWrap.wrap("The", LINE_LENGTH);
		assertEquals("The", result);
	}
	
	@Test
	public void longerLineShouldWrapTwice() {
		String result = WordWrap.wrap("The Sleepy Brow", LINE_LENGTH);
		assertEquals("The S\nleepy\n Brow", result);
	}
	
	@Test
	public void evenlongerLinesShouldWrapThrice() {
		String result = WordWrap.wrap("The Sleepy Brown Fox", LINE_LENGTH);
		assertEquals("The S\nleepy\n Brow\nn Fox", result);
	}
	
	@Test
	public void longlinesDonthaveToBeAMultipleOfLineLength() {
		String result = WordWrap.wrap("The Sleepy Brown Fox", LINE_LENGTH);
		assertEquals("The S\nleepy\n Brow\nn Fox\n.", result);
	}
}
