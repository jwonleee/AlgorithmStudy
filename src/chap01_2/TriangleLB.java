package chap01_2;

import java.util.Scanner;

public class TriangleLB {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		
		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
		
		do {
			System.out.print("몇 단 삼각형입니까? ");
			n = scan.nextInt();
		} while (n <= 0); //n이 0보다 큰 정수가 아니면 계속 반복
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
