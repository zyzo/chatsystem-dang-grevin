package boundaries.network;

import org.junit.Test;

public class JSONUtilsTest {

	@Test
	public void testConstructHello() {
		System.out.println(new String(JSONUtils.constructHello()));
	}
}
