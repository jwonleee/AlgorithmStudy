package chap02_1;

import java.util.Scanner;

public class Quiz8 {

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
	
	//while문 사용하여 메서드 구현
	static int dayOfYear(int y, int m, int d) {
		while(--m != 0) { //--m; + m != 0; m에서 하나뺀 값이 0이 아닐때까지 반복, ex) 2월, 1월 
			d += mdays[isLeap(y)][m-1];
		}
		return d;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int retry;
		
		System.out.println("그 해 경과 일수를 구하자");

		do { //한번은 무조건 실행
			System.out.print("년: "); int year = scan.nextInt();
			System.out.print("월: "); int month = scan.nextInt();
			System.out.print("일: "); int day = scan.nextInt();

			System.out.printf("그 해 %d일째입니다. \n", dayOfYear(year, month, day) );

			System.out.println("한 번 더 할까요? (1: 예, 0: 아니오)");
			retry = scan.nextInt();

		} while (retry == 1); //true이면 다시 반복
	}
}
