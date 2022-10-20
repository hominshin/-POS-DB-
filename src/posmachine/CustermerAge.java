package posmachine;

import java.util.Calendar;

public class CustermerAge {
	
	public int getAge(int birthYear, int birthMonth, int birthDay) {
		Calendar current = Calendar.getInstance();
		int currentYear = current.get(Calendar.YEAR);
		int currentMonth = current.get(Calendar.MONTH);
		int currentDay = current.get(Calendar.DAY_OF_MONTH);
		
		int age = currentYear - birthYear;
		
		if(birthMonth* 100 + birthDay > currentMonth * 100 + currentDay) {
			age--;
		}
		
		return age;
	}

}