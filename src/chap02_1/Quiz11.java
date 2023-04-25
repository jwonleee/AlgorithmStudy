package chap02_1;

import java.util.Scanner;

public class Quiz11 {

	class YMD2 {
		int y;
		int m;
		int d;
		
		// 각 달의 일수
		static int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
								 { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 윤년
		};
		
		//평년, 윤년 확인
		static int isLeap(int year) {
			return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
		}

		//생성자
		public YMD2(int y, int m, int d) {
			super();
			this.y = y;
			this.m = m;
			this.d = d;
		}

		//n일 뒤의 날짜
//		static YMD after(int n) {
//			
//			return 0;
//		}

		//n일 전의 날짜
//		static YMD before(int n) {
//
//			return 0;
//		}

	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("날짜를 입력하세요.\n");
		System.out.print("년：");
		int y = scan.nextInt();
		System.out.print("월：");
		int m = scan.nextInt();
		System.out.print("일：");
		int d = scan.nextInt();
		
//		YMD2 date = new YMD2(y, m, d); //적어준 날짜로 현재 날짜 입력

		System.out.print("몇 일 앞/뒤의 날짜를 구할까요?：");
		int n = scan.nextInt();

		
		//System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일입니다.\n", );

		
		//System.out.printf("%d일 앞의 날짜는 %d년 %d월 %d일입니다.\n", );
	}
	
}
