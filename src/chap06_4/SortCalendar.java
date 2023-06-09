package chap06_4;

import java.util.GregorianCalendar;
import static java.util.GregorianCalendar.*;

import java.util.Arrays;

public class SortCalendar {

	public static void main(String[] args) {
		GregorianCalendar[] x = {
				new GregorianCalendar(2023, NOVEMBER, 1),
				new GregorianCalendar(2018, OCTOBER, 18),
				new GregorianCalendar(1995, APRIL, 5),
		};
		
		Arrays.sort(x);
		
		for(int i = 0; i < x.length; i++) {
			System.out.printf("%04d년 %02d월 %02d일\n"
								, x[i].get(YEAR)
								, x[i].get(MONTH)
								, x[i].get(DATE)
			);
		}
	}
}
