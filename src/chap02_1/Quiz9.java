package chap02_1;

import java.util.Scanner;

public class Quiz9 {

	//각 달의 일수
	static int[][] mdays = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년 i=[0]
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //윤년 i=[1]
	};

	//서기 year년은 윤년인가? (윤년 = 1, 평년 = 0)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
		//4년에 한번은 윤년 &&  !(year%100 == 0 && year%400 != 0) 이 조건이 아닐 때 윤년
	}
	
	static int leftDayOfYear(int y, int m, int d) {
		while(--m != 0) {
			d += mdays[isLeap(y)][m-1];
		} //그 년에서 지난 일 수 구해서
		int result = 365 - d; //365일에서 빼기
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int retry;
		
		System.out.println("그 해 남은 일 수를 구하자");
		
		do {
			System.out.print("년 :"); int year = scan.nextInt();
			System.out.print("월 :"); int month = scan.nextInt();
			System.out.print("일 :"); int day = scan.nextInt();
			
			System.out.printf("%d일 남았습니다.\n", leftDayOfYear(year, month, day));
			
			System.out.print("한 번 더 할까요? (1: 예, 0: 아니오)");
			retry = scan.nextInt();
			
		} while (retry == 1);
	}
}
