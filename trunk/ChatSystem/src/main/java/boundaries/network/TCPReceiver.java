package boundaries.network;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TCPReceiver extends Thread {
	
    private final Socket socket;
    int bytesRead ; 
	public TCPReceiver(Socket socket){
		this.socket =socket;
	}
	@Override
	public void run() {
		InputStream in;
		try {
			in = socket.getInputStream();
			DataInputStream data = new DataInputStream(in);
			String filename = data.readUTF();
			OutputStream output = new FileOutputStream(filename);
			long size = data.readLong();       
	        byte[] buffer = new byte[1024];       
	        while (size > 0 && (bytesRead = data.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1)       
	        {       
	            output.write(buffer, 0, bytesRead);       
	            size -= bytesRead;       
	        }    
	            
	        // Closing the FileOutputStream handle  
	        in.close();  
	        data.close();  
	        output.close(); 
	        System.out.println("FILE RECEIVE");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
