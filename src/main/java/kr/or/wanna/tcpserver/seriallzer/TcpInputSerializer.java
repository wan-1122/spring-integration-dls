package kr.or.wanna.tcpserver.seriallzer;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.serializer.Deserializer;

import kr.or.wanna.tcpserver.dto.DefaultSpec;

/**
 * Deserializer로 하면 못 알아 먹을까봐 input이라고 함..
 * @author wan
 *
 */
public class TcpInputSerializer implements Deserializer<DefaultSpec> {

	@Override
	public DefaultSpec deserialize(InputStream in) throws IOException {
		int len = in.available();
		if (len < 1) {
			return new DefaultSpec();
		}
		byte[] b = new byte[len];
		in.read(b);
		
		DefaultSpec defaultSpec = new DefaultSpec();
		defaultSpec.bind(b);
		
		/**
		 * TODO: THREAD별로 인코딩 분기
		 */
//		TcpServerEncoding.setEncoding("utf-8");
		return defaultSpec;
	}

}
