package chap01_2;

import java.util.Scanner;

public class Quiz16 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		
		do {
			System.out.print("n단의 피라미드: ");
			n = scan.nextInt();			
		} while (n <= 0);
		spira(n);
	}
	
	static void spira(int n) {
		for(int i = 1; i <= n; i++) {
			for(int j = i-1; j <= n-2; j++) { //앞 부분 띄우기, int j = 1; j <= n - i + 1; j++ 이렇게 해도 됨
				System.out.print(" ");
			}
			for(int j = 1; j <= (i-1)*2 +1; j++) {
				System.out.print("*");
			}
			System.out.println(); //한 줄 쓰면 다음줄로 이동
		}
	}
}
