package model;

import static org.junit.Assert.assertTrue;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class TestUser {

	@Test
	public void testHashCode() {
		User user1 = null;
		try {
			user1 = new User("AAA", InetAddress.getByName("localhost"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user1.hashCode());
		User user2 = null;
		try {
			user2 = new User("AAA", InetAddress.getByName("localhost"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user2.hashCode());
		assertTrue("Hashcode must be equal", user1.hashCode() == user2.hashCode());
		
	}
}
