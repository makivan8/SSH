import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GoogleMap{

	public static double [] Main(String ip){

		GoogleMap iptodecimal = new GoogleMap();
		long value = iptodecimal.Decimal(ip);

		GoogleMap ipcode = new GoogleMap();
		int code = ipcode.Code(value);
		
		GoogleMap iplocation = new GoogleMap();
		double [] points = iplocation.Location(code);

		GoogleMap googlemap = new GoogleMap();
		googlemap.map(points);

		return points;
	}

	public static long Decimal(String ipAddress) {
 
		String[] ipAddressInArray = ipAddress.split("\\.");
		long result = 0;

		for (int i = 0; i < ipAddressInArray.length; i++) {
			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);
			result += ip * Math.pow(256, power);
		}
		return result;

	}

	public static int Code(long value){

		int code = 0;
		try {
			File file = new File("GeoLiteCity-Blocks.csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				String [] s = line.split("\"");

				long min_val = Long.parseLong(s[1]);
				long max_val = Long.parseLong(s[3]);
				
				if((value >= min_val) && (value <= max_val)){
					code = Integer.parseInt(s[5]);
					break;
				}
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code;

	}

	public static double [] Location(int code){

		double [] Array = new double[2];
		try {
			File file = new File("GeoLiteCity-Location.csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				String [] s = line.split(",");
				
				int index = Integer.parseInt(s[0]);

				if(code == index){
					Array[0] = Double.parseDouble(s[5]);
					Array[1] = Double.parseDouble(s[6]);
					break;	
				}
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Array;

	}

	public static void map(double [] args){
    
		try {
         		String url = "http:www.google.lk/maps/place//@" + args[0] + "," + args[1] + ",10z/data=!4m2!3m1!/s0x0:0x0";
         		java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
       	} catch (java.io.IOException e) {
           	System.out.println(e.getMessage());
       	}

	}  

}
