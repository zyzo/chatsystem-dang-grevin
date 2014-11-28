package boundaries.network;


import model.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

	public static byte[] constructHello() {
		User me = new User("AéA");
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsBytes(me);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
