package chap05_1;

import java.util.Scanner;

public class Quiz1 {

	static int factorial(int n) {
		int answer = 1;
		
		while(n != 0) {
			answer *= n;
			n = n-1;
			//한줄로 쓰면 answer *= n--;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.err.print("정수를 입력: ");
		int x = scan.nextInt();
		
		System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
	}
}
