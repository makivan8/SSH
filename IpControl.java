import java.io.*;
  
public class IpControl {  
 	public static void Block(String IP){  

		System.out.println("sudo iptables -A INPUT -s " + IP + " -j DROP");
	
/*		Process p =null;	
		String cmd ="sudo iptables -A INPUT -s " + IP +" -j DROP";

		try {
		 	p = Runtime.getRuntime().exec(cmd);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));  
			String line = null;  
			while ((line = input.readLine()) != null) {  
				System.out.println(line);  
			}  
		} catch (IOException e) {  
			e.printStackTrace();  
		}	*/
	} 

	public static void Unblock(String IP){

		System.out.println("sudo iptables -D INPUT -s " + IP +" -j DROP"); 
	
/*		Process p =null;
		String cmd ="sudo iptables -D INPUT -s " + IP +" -j DROP";
	
		try {  
		 	p = Runtime.getRuntime().exec(cmd);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));  
			String line = null;  
			while ((line = input.readLine()) != null) {  
				System.out.println(line);  
			}  
		} catch (IOException e) {  
			e.printStackTrace();  
		}	*/
	} 
}
