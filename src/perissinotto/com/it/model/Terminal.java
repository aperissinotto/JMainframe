package perissinotto.com.it.model;

public interface Terminal {
	public abstract void Connect() throws TerminalAlreadyConnected;
	public abstract void Disconnect() throws TerminalNotConnected;
	public abstract void Send(Message message) throws TerminalNotConnected;
	public abstract Message Receive() throws TerminalNotConnected;
}
