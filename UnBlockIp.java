import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class UnBlockIp{

	static LinkedList lList = new LinkedList();

	public static void IpList(String IP, String Time) {
         	
		UnblockTime UnBlockIpTime = new UnblockTime();
		String UTime = UnBlockIpTime.Time(Time);

		// add elements to UnBlockIp
		lList.add(IP,UTime);
		// write in a file
		Write_Block_IpFile W_file = new Write_Block_IpFile();
		W_file.Blk_ip(IP, Time, UTime);
		
   	}

	public static void Run(){
		
		SystemTime st = new SystemTime();
		String Stime = st.Time();

		try {
			while(UnblockTime.TimeCheck(lList.getTime(),Stime)){
				IpControl unblock = new IpControl();
				unblock.Unblock(lList.getIP());
				lList.remove();
			}				
		} catch(Exception e) {

		}    
	}

}
