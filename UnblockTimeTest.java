import static org.junit.Assert.*;

import org.junit.Test;


public class UnblockTimeTest {

	@Test
	public void Timetest() {
		String time1="06:51:54";
		assertEquals("11:51:54",UnblockTime.Time(time1));
		assertNotEquals("01:51:54",UnblockTime.Time(time1));
		
		String time2="13:51:00";
		assertEquals("18:51:00",UnblockTime.Time(time2));
		assertNotEquals("01:51:54",UnblockTime.Time(time2));
		
		
		
	}
	@Test
	public void test() {
		String time1="06:51:54";
		String time2="01:51:54";
		assertFalse(UnblockTime.TimeCheck(time1,time2));
		
		String time3="13:01:54";
		String time4="01:51:24";
		assertFalse(UnblockTime.TimeCheck(time3,time4));
		
		String time5="13:51:04";
		String time6="18:51:54";
		assertTrue(UnblockTime.TimeCheck(time5,time6));
		
		
	}

	

}
