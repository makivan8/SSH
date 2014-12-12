import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SystemTime {
	public static String Time() {
       	//getting current date and time using Date class
       	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    		Date dateobj = new Date();

		String [] s = df.format(dateobj).split(" ");
   		return s[1];
    	}
}
