package boundaries.network;


import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {

	public static JSONObject constructHello() {
		JSONObject obj = new JSONObject();
		try {
			obj.put(MessageConstants.ATT_TYPE, MessageConstants.TYPE_HELLO);
			obj.put(MessageConstants.ATT_USERNAME, "I am Frédéric Yolo");
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		return obj;
	}
	
	public static JSONObject byteToJson(byte [] buffer){
		JSONObject obj = null;
		try {
			obj = new JSONObject(new String(buffer));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	
}
