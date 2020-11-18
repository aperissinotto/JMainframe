package perissinotto.com.it.model;

public class TerminalNotConnected extends Exception {
	private static final long serialVersionUID = 1L;
	public TerminalNotConnected(String errorMessage) {
		super(errorMessage);
	}
}
