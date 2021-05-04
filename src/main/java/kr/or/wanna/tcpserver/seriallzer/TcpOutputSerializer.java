package kr.or.wanna.tcpserver.seriallzer;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.core.serializer.Serializer;

import kr.or.wanna.tcpserver.dto.DefaultSpec;

/**
 * Serializer로 하면 못 알아 먹을까봐 output이라고 함..
 * @author wan
 *
 */
public class TcpOutputSerializer implements Serializer<DefaultSpec> {

	@Override
	public void serialize(DefaultSpec object, OutputStream outputStream) throws IOException {
		
		outputStream.write(object.toString().getBytes());
		outputStream.write("\r\n".getBytes());
		outputStream.flush();
	}

}
