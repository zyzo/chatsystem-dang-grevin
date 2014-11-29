package model;

import java.net.InetAddress;
import java.net.UnknownHostException;


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

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode() + ip.hashCode();
	}

}
