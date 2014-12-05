package boundaries.network;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPReceiver extends Thread {
	
    private final Socket socket;
    int bytesRead ; 
	public TCPReceiver(Socket socket){
		System.out.println("Received file");
		this.socket =socket;
	}
	@Override
	public void run() {
		InputStream in;
		try {
			in = socket.getInputStream();
			DataInputStream data = new DataInputStream(in);
			String filename = data.readUTF();
			String path = (new File ("")).getAbsolutePath();
			System.out.println(path);
			OutputStream output = new FileOutputStream(path+"/"+filename);
			long size = data.readLong();       
	        byte[] buffer = new byte[1024];       
	        ChatNI.getInstance().notifyFileReceiving(socket.getInetAddress(), filename);
	        while (size > 0 && (bytesRead = data.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1)       
	        {       
	            output.write(buffer, 0, bytesRead);       
	            size -= bytesRead;       
	        }    
	            
	        // Closing the FileOutputStream handle  
	        in.close();  
	        data.close();  
	        output.close(); 
	        System.out.println("FILE RECEIVED");
	        ChatNI.getInstance().notifyFileReceived(socket.getInetAddress(), filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}