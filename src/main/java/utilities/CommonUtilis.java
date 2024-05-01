package utilities;

import java.time.Duration;
import java.util.Date;

public class CommonUtilis {

	public static final int PAGE_LOAD_TIMEOUT=30;
	public static final int IMPLICITY_WAIT=20;
	public static final int EXPLICITY_WAIT=20;

	public static String getTimeStamp() {
		Date date=new Date();
    	return "Naru_"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";	
	}
	
	public static void main(String[] args) {
		System.out.println(CommonUtilis.getTimeStamp());//using 
	}
}
