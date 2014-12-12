public class UnblockTime{
	public static String Time(String B_Time){

		String [] s = B_Time.split(":");
		String unblocktime;

		int h = Integer.parseInt(s[0]);
			if(h < 20){
				h = h + 5;
			}else{
				h = h - 19;
			}
		if(h<10){
			unblocktime = "0" + h + ":" + s[1] + ":" + s[2];
		}else{
			unblocktime = h + ":" + s[1] + ":" + s[2];
		}
		return unblocktime;
	}

	public static boolean TimeCheck(String t1, String t2){
		
		String [] T1 = t1.split(":");
		String [] T2 = t2.split(":");
		
		int H1 = Integer.parseInt(T1[0]);
		int H2 = Integer.parseInt(T2[0]);
		int M1 = Integer.parseInt(T1[1]);
		int M2 = Integer.parseInt(T2[1]);
		int S1 = Integer.parseInt(T1[2]);
		int S2 = Integer.parseInt(T2[2]);

		if((H1<H2) || ((H1<=H2) && (M1<M2)) || ((H1<=H2) && (M1<=M2) && (S1<=S2))){
			return true;
		}else{	
			return false;
		}
	}
}
