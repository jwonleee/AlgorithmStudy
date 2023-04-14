package chap01_2;

import java.util.Scanner;

public class Quiz10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a;
		int b;
		
		System.out.print("a의 값: "); a = scan.nextInt();
		do {
			System.out.print("b의 값: "); b = scan.nextInt();
		} while (a >= b);
		
		System.out.println("b - a는 " + (b-a) + "입니다");
	}
}
