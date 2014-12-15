package boundaries.network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
/**
 * Use to Send File
 * Extends Thread in order to send File and Use THe ChatSystem at the same time.
 * 
 * @author Arthur & Hai An
 *
 */
public class TCPSender extends Thread {
	private final String filePath;
    private Socket socket;

    TCPSender(String filePath, InetAddress remoteIp, int destPort) {
        this.filePath = filePath;
        System.out.println("TCPSender : New TCP Sender created");

        //creates the socket
        try {
            System.out.println("TCPSender : creating socket with remoteIP = " + remoteIp.toString() + " port : " + destPort);
            socket = new Socket(remoteIp, destPort);
            System.out.println("TCPSender : success. Ready to send file.");
        } catch (IOException ex) {
            System.out.println("TCPSender : Creation of the sending socket failed");
        }
    }
    
    public  void run(){
    	FileInputStream fis = null;

		try {
			System.out.println("DébutSendFile");
			File fichier = new File(filePath);
	    	byte[] bytefichier = new byte[(int) fichier.length()];
			fis = new FileInputStream(fichier);
			BufferedInputStream bis = new BufferedInputStream(fis);
	        DataInputStream dis = new DataInputStream(bis);
	        dis.readFully(bytefichier, 0, bytefichier.length);
	        OutputStream os = socket.getOutputStream();
	        
	        DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(fichier.getName());
            dos.writeLong(bytefichier.length);
            dos.write(bytefichier, 0, bytefichier.length);
            dos.flush();
            
           // os.write(bytefichier, 0, bytefichier.length);
            //os.flush();
            //Closing socket
           // os.close();
            dos.close();
            try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            socket.close();
            dis.close();
            System.out.println("FinSendFile");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    }
    
    
}
