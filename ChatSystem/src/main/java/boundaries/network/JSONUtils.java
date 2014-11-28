package boundaries.network;


import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {

	public static JSONObject constructHello() {
		JSONObject obj = new JSONObject();
		try {
			obj.put(MessageConstants.ATT_TYPE, MessageConstants.TYPE_HELLO);
			// TODO : get username from model
			obj.put(MessageConstants.ATT_USERNAME, "Frédéric Yolo");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static JSONObject constructHelloAck() {
		JSONObject obj = new JSONObject();
		try {
			obj.put(MessageConstants.ATT_TYPE, MessageConstants.TYPE_HELLO_ACK);
			// TODO : get username from model
			obj.put(MessageConstants.ATT_USERNAME, "Frédéric Yolo");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static JSONObject byteToJson(byte [] buffer){
		JSONObject obj = null;
		try {
			obj = new JSONObject(new String(buffer));
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	
}
