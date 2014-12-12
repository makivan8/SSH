import static org.junit.Assert.*;

import org.junit.Test;


public class GoogleMapTest {

	@Test
	public void GoogleMaptest() {
		String ip1="192.22.1.1";
		String ip2="110.22.1.1";
		double[] point1={42.4645,-83.3763};
		double[] point2={-37.8167,145.1};
		assertEquals(point1.toString(),GoogleMap.Main(ip1));
		assertEquals(point2.toString(),GoogleMap.Main(ip2));
		
		assertNotEquals(point1.toString(),GoogleMap.Main(ip2));
		
	}

}
