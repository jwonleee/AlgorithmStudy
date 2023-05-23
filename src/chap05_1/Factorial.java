package chap05_1;

import java.util.Scanner;

//양의 정수 n의 팩토리얼
public class Factorial {

	static int factorial(int n) {
		if(n > 0) {
			return n * factorial(n-1); //n * (n-1)!
		} else {
			return 1; // 0! = 1			
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.err.print("정수를 입력: ");
		int x = scan.nextInt();
		
		System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
	}
}
