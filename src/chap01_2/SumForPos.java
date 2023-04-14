package chap01_2;

import java.util.Scanner;

public class SumForPos {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n; //반복문 밖에서도 계속 사용해야하므로
		
		System.out.println("1부터 n까지의 합");
		
		do {
			System.out.print("n의 값: ");
			n = scan.nextInt();
		} while (n <= 0); //n이 0, 또는 음수이면 계속 반복
		
		int sum = 0;
		
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		
		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
		
	}
}
