package boundaries.network;


import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {

	public static JSONObject constructHello() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("type", "hello");
			obj.put("userName", "I am Frédéric Yolo");
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		return obj;
	}
	
	
}
