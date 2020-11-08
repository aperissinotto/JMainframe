package perissinotto.com.it.controller;

import perissinotto.com.it.model.Connector;
import perissinotto.com.it.model.Converter;
import perissinotto.com.it.model.Message;
import perissinotto.com.it.model.Processor;

public class TestaCarga {

	public static void main(String[] args) {
		Converter conversor = new Converter();
		Connector conexaoMainframe = new Connector("159.8.102.103", 23);

		if (conexaoMainframe.Connect()) {
			Message msgrec1 = conexaoMainframe.Receive();
			if (msgrec1 != null) {
				System.out.println("RECEIVE: "
						+ conversor.toHexString(msgrec1.getMessageContent(), 0, msgrec1.getMessageLength()));
			}

			byte[] bufaux = new byte[3];
			bufaux[0] = (byte) 0xFF;
			bufaux[1] = (byte) 0xFC;
			bufaux[2] = (byte) 0x28;
			Message msgsnd1 = new Message(bufaux, bufaux.length);
			System.out.println(
					"SEND: " + conversor.toHexString(msgsnd1.getMessageContent(), 0, msgsnd1.getMessageLength()));
			conexaoMainframe.Send(msgsnd1);

			Message msgrec2 = conexaoMainframe.Receive();
			if (msgrec2 != null) {
				System.out.println("RECEIVE: "
						+ conversor.toHexString(msgrec2.getMessageContent(), 0, msgrec2.getMessageLength()));
			}
		}
	}
}
