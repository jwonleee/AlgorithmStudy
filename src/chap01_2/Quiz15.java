package chap01_2;

import java.util.Scanner;

public class Quiz15 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		
		System.out.println("이등변 삼각형을 출력하세요");
		do {
			System.out.print("몇 단 입니까?");
			num = scan.nextInt();
		} while (num <= 0);
			triangleLB(num);
			triangleLU(num);
			triangleRU(num);
			triangleRB(num);
	}
	
	//왼쪽 아래
	static void triangleLB(int n) {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//왼쪽 위
	static void triangleLU(int n) {
		/*
		 * for(int i = 1; i <= n; i++) {
		 * 		for(int j = i; j <= n; j++) {
		 * 			System.out.print("*");
		 * 		}
		 * 		System.out.println();
		 * }
		 */
		for(int i = n; i >= 1; i--) {
			for(int j = i; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//오른쪽 위
	static void triangleRU(int n) {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i-1; j++) {				
				System.out.print(" ");
			}
			for(int j = n-1; j >= i-1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
		
	//오른쪽 아래
	static void triangleRB(int n) {
		for(int i = 1; i <= n; i++) {
			for(int j = i; j <= n-1; j++) {
				System.out.print(" ");
			}
			for(int j = i-1; j >= 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
