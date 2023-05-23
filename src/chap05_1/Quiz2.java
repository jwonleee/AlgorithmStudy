package chap05_1;

import java.util.Scanner;

public class Quiz2 {

	static int gcd(int x, int y) {
		while(y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("두 수의 최대공약수를 구합니다.");
		
		System.out.print("정수를 입력하세요: ");
		int x = scan.nextInt();
		System.out.print("정수를 입력하세요: ");
		int y = scan.nextInt();
		
		System.out.println(x + "와 " + y + "의 최대공약수는 " + gcd(x, y) + "입니다.");
	}
}
