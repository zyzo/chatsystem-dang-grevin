package boundaries.network;


import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {

	public static JSONObject constructHello(String nickname) {
		JSONObject obj = new JSONObject();
		try {
			obj.put(MessageConstants.ATT_TYPE, MessageConstants.TYPE_HELLO);
			// TODO : get username from model
			obj.put(MessageConstants.ATT_USERNAME, nickname);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static JSONObject constructHelloAck(String nickname) {
		JSONObject obj = new JSONObject();
		try {
			obj.put(MessageConstants.ATT_TYPE, MessageConstants.TYPE_HELLO_ACK);
			// TODO : get username from model
			obj.put(MessageConstants.ATT_USERNAME, nickname);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static JSONObject constructGoodBye(String nickname){
		JSONObject obj = new JSONObject();
		try {
			obj.put(MessageConstants.ATT_TYPE, MessageConstants.TYPE_GOOD_BYE);
		
			obj.put(MessageConstants.ATT_USERNAME, nickname);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
	public static JSONObject constructMessage (String message){
		JSONObject obj = new JSONObject();

		try {
			obj.put(MessageConstants.ATT_TYPE, MessageConstants.TYPE_MESSAGE);
			obj.put(MessageConstants.ATT_MESSAGE_DATA, message);
			obj.put(MessageConstants.ATT_MESSAGE_NUMBER, 1);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static JSONObject constructMessageAck(int seq){
		JSONObject obj = new JSONObject();
		try {
			obj.put(MessageConstants.ATT_TYPE, MessageConstants.ATT_MESSAGE_NUMBER);
			obj.put(MessageConstants.ATT_MESSAGE_NUMBER, seq);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
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
