package chap02_1;

import java.util.Scanner;

//그 해의 경과 일 수를 구함
public class DayOfYear {

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
	
	//서기 y년 m월 d일의 그 해 경과 일 수 구하는 메서드
	static int dayOfYear(int y, int m, int d) {
		int days = d; //일 수 먼저 넣고
		
		for(int i = 1; i < m; i++) { //1월 ~ (m-1)월의 일 수를 더하기 ********i는 1부터 시작해야 [0]부터 나옴
			days += mdays[isLeap(y)][i-1]; //isLeap로 평년이면 0, 윤년이면 1을 넣어서 행 구해주고, 열은 m-1이니까 i-1해서 일수 days에 넣기
		}
		return days;
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int retry; //다시 한 번?
		
		System.out.println("그 해 경과 일수를 구하자");
		
		do { //한번은 무조건 실행
			System.out.print("년: "); int year = scan.nextInt();
			System.out.print("월: "); int month = scan.nextInt();
			System.out.print("일: "); int day = scan.nextInt();
			
			System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day) );
			
			System.out.println("한 번 더 할까요? (1: 예, 0: 아니오)");
			retry = scan.nextInt();
			
		} while (retry == 1); //true이면 다시 반복
	}
}
