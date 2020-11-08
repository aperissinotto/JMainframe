package perissinotto.com.it.controller;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import perissinotto.com.it.model.Connector;
import perissinotto.com.it.model.Message;

public class BuscaMainframe {
	public static void main(String[] args) {
		
		
		for(short ip1 = 1 ; ip1 < 256 ; ip1++) {
			for(short ip2 = 1 ; ip2 < 256 ; ip2++) {
				for(short ip3 = 1 ; ip3 < 256 ; ip3++) {
					for(short ip4 = 1 ; ip4 < 256 ; ip4++) {
						String ipfinal = new String(ip1 + "." + ip2 + "." + ip3 + "." + ip4);
						Connector conexaoMainframe = new Connector(ipfinal, 23);
						if (conexaoMainframe.Connect()) {
							Message msgrec1 = conexaoMainframe.Receive();
							System.out.println(ipfinal + " ok");
						} else {
							System.out.println(ipfinal + " erro");
						}
					}
				}
			}
		}
	}
}
