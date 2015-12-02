package Testing.Testing;

public class WordWrap {

	public static String wrap(String inputLine, int lineLength) {
		StringBuilder sb = new StringBuilder();
		final int length = inputLine.length();

		sb.append(inputLine, 0, Math.min(length, lineLength));
		
		int split = lineLength;
		while (length > split) {
			sb.append('\n');
			sb.append(inputLine, split, Math.min(split + lineLength, length));
			split += lineLength;
		}
		
		return sb.toString();
	}

}
