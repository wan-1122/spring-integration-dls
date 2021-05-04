package kr.or.wanna.tcpserver.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.or.wanna.tcpserver.dto.DefaultSpec;
import kr.or.wanna.tcpserver.server.TestServer;

@Component
public class CommandHandler {
	
	@Autowired
	public TestServer testServer;
	
	public DefaultSpec exec(DefaultSpec defaultSpec) {
		try {
			String version = defaultSpec.getVersion();
			String command = defaultSpec.getCommand();
			/**
			 * TODO: version, command에 따라 분기.. factory만들면 된다~
			 */
			byte[] b = defaultSpec.getBodyDate();
			/**
			 * TODO: DB 연동..
			 */
			;
			System.out.println(testServer.findAll().size());
			defaultSpec.setBodyDate(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defaultSpec;
	} 
}
