package boundaries.network;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class JSONUtilsTest {

	@Test
	public void testConstructHello() {
		System.out.println(JSONUtils.constructHello());
	}
	
	@Test
	public void testConstructHelloAck() {
		System.out.println(JSONUtils.constructHelloAck());
	}
	
	@Test
	public void testConvertByteToJONObject() throws JSONException {
		byte[] s = "{type : abc}".getBytes();
		System.out.println(JSONUtils.byteToJson(s));
	}
}
