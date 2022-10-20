package posmachine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemLife {
	
	public static boolean IsDate(String itemLife) throws ParseException{
		
		boolean result = false;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		
		Date currentTime = new Date();
		
		String today = format.format(currentTime);
		
		
		Date startDate = format.parse(today);
		
		Date endDate = format.parse(itemLife);
		
		int compare1 = startDate.compareTo(endDate);
		
		if(compare1 <= 0) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
