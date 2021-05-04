package kr.or.wanna.utils;

import org.springframework.util.ObjectUtils;

/**
 * 그냥..아무런 이름이나..
 * @author wan
 *
 */
public class TcpServerEncoding {
	private static ThreadLocal<String> THREAD_LOCAL_ENCODING = new ThreadLocal<>();
	
	public static String getEncoding() {
		if (THREAD_LOCAL_ENCODING == null) {
			return "utf-8";
		}
		if (ObjectUtils.isEmpty(THREAD_LOCAL_ENCODING)) {
			return "utf-8";
		}
		return THREAD_LOCAL_ENCODING.get();
	}
	public static void setEncoding(String encoding) {
		THREAD_LOCAL_ENCODING.set(encoding);
	}
}
