package perissinotto.com.it.controller;

import perissinotto.com.it.model.Connector;
import perissinotto.com.it.model.Converter;
import perissinotto.com.it.model.Log;
import perissinotto.com.it.model.Message;
import perissinotto.com.it.model.Processor;

/* Conexão de Negociação:
 * Server : IAC DO TN3270E
 * Client : IAC WON'T TN3270E
 * Server : IAC DO TERMINAL-TYPE
 * Client : IAC WILL TERMINAL-TYPE
 * Server : IAC SB TERMINAL-TYPE SEND IAC SE
 * Client : IAC SB TERMINAL-TYPE IS <terminal type> IAC SE
 */

public class TestaCarga {

	public static void main(String[] args) {
		Converter conversor = new Converter();
		Connector conexaoMainframe = new Connector("159.8.102.103", 23);
		Log logger = new Log();
		Message[] messageReceived = new Message[500];
		Message[] messageSended = new Message[500];

		int timeout = 10000;
		int messageRecIndex = 0;
		int messageSndIndex = 0;

		if (conexaoMainframe.Connect()) {
			while (true) {
				messageReceived[messageRecIndex] = conexaoMainframe.Receive(timeout);
				if (messageReceived[messageRecIndex] != null) {
					logger.toSysout(
							"RECEIVE: " + conversor.toHexString(messageReceived[messageRecIndex].getMessageContent(), 0,
									messageReceived[messageRecIndex].getMessageLength()));
					messageRecIndex++;
				} else {
					logger.toSysout("Nada a receber");
				}
			}
		}
	}
}
