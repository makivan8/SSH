import java.io.*;  
       
public class Write_Block_IpFile {  

	public void writing(String IP, String B, String U) {
    	
		File file = new File("BlockIp.txt");  
    		try{   
        		PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));  
        		pw.println("IP Address: " + IP + "  Block Time: " + B + "  Unblock Time: " + U);  
        		pw.flush();  
        		pw.close();  
    		}catch(IOException ex){  
        		ex.printStackTrace();  
    		}  
        }  

	// write in Block_ip text
	public static void Blk_ip(String IP, String B, String U) {
	
		Write_Block_IpFile write = new Write_Block_IpFile();
		write.writing(IP, B, U);
	}
}
