package perissinotto.com.it.model;

public class Converter {

	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

	public char[] toHex(byte[] input, int length) {
		char[] hexChars = new char[length * 2];

		for (int j = 0; j < length; j++) {
			int v = input[j] & 0xFF;
			hexChars[j * 2] = HEX_ARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		
		return hexChars;
	}

}
