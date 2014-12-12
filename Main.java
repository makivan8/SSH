import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Main class
public class Main{
	
	public static String line;

	public static void main(String args[]) throws InterruptedException {

		try {
			File file = new File("auth.log");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();

			Hashtable<String, Integer> countMap = new Hashtable<String, Integer>();

			while(true){
				if((line = bufferedReader.readLine()) == null){
					try{
						Thread.sleep(1000);
						UnBlockIp.Run();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}else{
					Pattern pattern = Pattern.compile("\\berror\\s\\bfor\\s\\billegal\\s\\buser\\s\\badmin\\s\\bfrom\\s(.*?)$"); 
					Matcher matcher = pattern.matcher(line);
				 
					Pattern pattern1 = Pattern.compile("\\berror\\s\\bfor\\s\\billegal\\s\\buser\\s\\bsupport\\s\\bfrom\\s(.*?)$"); 
					Matcher matcher1 = pattern1.matcher(line);
				 
					Pattern pattern2 = Pattern.compile("\\berror\\s\\bfor\\s\\billegal\\s\\buser\\s\\btest\\s\\bfrom\\s(.*?)$"); 
					Matcher matcher2 = pattern2.matcher(line);

					try{
						if(matcher.find() | matcher1.find() | matcher2.find()){
							String [] s = line.split(" ");
							
					 		if (!countMap.containsKey(s[15])) {
						  		countMap.put(s[15], 1);
						    	} else {
								Integer count = countMap.get(s[15]);
								count = count + 1;
								countMap.put(s[15], count);
							}
						   			
						   	int c = countMap.get(s[15]);
							if(c > 4){
						   		IpControl block = new IpControl();
								block.Block(s[15]);
								countMap.put(s[15], 0);
								
								UnBlockIp unblockIp = new UnBlockIp();
								unblockIp.IpList(s[15], s[3]);
    							}
							UnBlockIp.Run();
						}
					}catch(Exception e){
					
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}	
}
