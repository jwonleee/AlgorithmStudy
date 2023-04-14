package chap01_2;

import java.util.Scanner;

public class Quiz10_answer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a;
		int b = 0;
		
		System.out.print("a의 값: "); a = scan.nextInt();
		while(true) {			
			System.out.print("b의 값: "); b = scan.nextInt();
			
			//1. 첫번째 방법
			if(a >= b) {
				System.out.println("a보다 큰 값을 입력하세요");
			} else {
				break;
			}
			//2. 두번째 방법
//			if (b > a)
//				break;
//			System.out.println("a보다 큰 값을 입력하세요");
		}
	
		System.out.println("b - a는 " + (b-a) + "입니다");
	}
}
