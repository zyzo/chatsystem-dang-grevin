package model;

import java.net.InetAddress;
/**
 * Class User with nickname and address ip<br>
 * @author Arthur & Hai An
 *
 */

public class User {

    private String name;
    private InetAddress ip;

    public User(String name, InetAddress ip) {
        this.setName(name);
        this.ip = ip;
    }
    
    public User(String name){
    	this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

	public InetAddress getIp() {
		return ip;
	}

	public void setIp(InetAddress ip) {
		this.ip = ip;
	}


}
