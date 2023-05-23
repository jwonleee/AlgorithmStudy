package chap05_1;

import java.util.Scanner;

public class EuclidGCD {

	static int gcd(int x, int y) {
		if(y == 0) //더는 나누어 떨어지지 않을 때
			return x;
		else
			return gcd(y, x%y);
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
