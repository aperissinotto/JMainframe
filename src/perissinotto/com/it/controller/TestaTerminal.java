package perissinotto.com.it.controller;

import perissinotto.com.it.model.Converter;
import perissinotto.com.it.model.Log;
import perissinotto.com.it.model.Message;
import perissinotto.com.it.model.Processor;
import perissinotto.com.it.model.TerminalAlreadyConnected;
import perissinotto.com.it.model.TerminalIBM3270;
import perissinotto.com.it.model.TerminalNotConnected;

public class TestaTerminal {

	public static void main(String[] args) {
		TerminalIBM3270 terminal = new TerminalIBM3270("IBM-3278-2-E", "159.8.102.103", 23, 24, 80, "Terminal.txt", 10000);
		Log logger = new Log();
		Processor processadorTN3270E = new Processor();
		Message messageRec[] = new Message[10];
		int recMsg = 0;
		Message messageSnd[] = new Message[10];
		int sndMsg = 0;
		Converter conversor = new Converter();
		
		try {
			terminal.Connect();
		} catch (TerminalAlreadyConnected e) {
			logger.toSysout(e.getMessage());
		}
		
		
		try {
			while (true) {
				messageRec[recMsg] = terminal.Receive();
				if (messageRec[recMsg] != null) {
					logger.toSysout("Received: " + conversor.toHexString(messageRec[recMsg].getMessageContent(), 0, messageRec[recMsg].getMessageLength()));
					messageSnd[sndMsg] = processadorTN3270E.ProcessMessage(messageRec[recMsg], terminal);
					recMsg++;
					if (messageSnd[sndMsg] != null) {
						logger.toSysout("Sended: " + conversor.toHexString(messageSnd[sndMsg].getMessageContent(), 0, messageSnd[sndMsg].getMessageLength()));
						terminal.Send(messageSnd[sndMsg]);
						sndMsg++;
					}
				}
			}
		} catch (TerminalNotConnected e1) {
			logger.toSysout(e1.getMessage());
		}
	}
}
