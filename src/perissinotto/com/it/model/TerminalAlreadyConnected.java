package perissinotto.com.it.model;

public class TerminalAlreadyConnected extends Exception {
	private static final long serialVersionUID = 1L;
	public TerminalAlreadyConnected(String errorMessage) {
		super(errorMessage);
	}
}