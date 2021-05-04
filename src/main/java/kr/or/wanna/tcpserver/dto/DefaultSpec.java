package kr.or.wanna.tcpserver.dto;

import java.nio.ByteBuffer;

/**
 * header, body로 구분해도 된다~ 하고 싶은대로..
 * @author wan
 *
 */
public class DefaultSpec {
	private String length;
	private String version;
	private String command;
	private byte[] bodyDate;
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public void setBodyDate(byte[] bodyDate) {
		this.bodyDate = bodyDate;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLength() {
		return length;
	}
	public String getVersion() {
		return version;
	}
	public byte[] getBodyDate() {
		return bodyDate;
	}
	public void bind(byte[] b) {
		if (b == null || b.length < 1) {
			return;
		}
		try {
			ByteBuffer buffer = ByteBuffer.allocate(b.length);
			buffer.put(b);
			buffer.position(0);
			
			/**
			 * TODO: util 필요.
			 */
			byte[] input = new byte[4];
			buffer.get(input);
			
			this.length = new String(input, "utf-8");
			
			byte[] body = new byte[buffer.remaining()];
			buffer.get(body);
			this.bodyDate = body;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
