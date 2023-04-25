package chap01_2;

import java.util.Scanner;

public class Quiz17 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		
		do {
			System.out.print("n단의 숫자 피라미드: ");
			n = scan.nextInt();
		} while (n <= 0);
		npria(n);
	}
	
	static void npria(int n) {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n-i; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= (i-1)*2+1; j++) {
				System.out.print(i%10);
			}
			System.out.println();
		}
	}
}
