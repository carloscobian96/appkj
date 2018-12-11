package iconix.appkademyj.test;

import java.net.*; 
import java.io.*; 

public class DateServer 
{ 
	public static void main(String[] args) { 
	   try { 
		//make connection to server socket
	 	ServerSocket sock= new ServerSocket(6013);

 		InputStream in= sock.getinputStream(); 
		BufferedReader bin = new
			BufferedReader(new InputStreamReader(in)); 
		// read the date from the socket 
		String line; 
		while ( (line = bin.readLine()) !=null) 
			System.out.println(line); 

		// close the socket connection 
		sock.close(); 
		}
		catch (IOException ioe) {
			System.err.println(ioe);		
		}
	}
}