package chap01_1;

import java.util.Scanner;

public class JudgeSign {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요: ");
		int n = scan.nextInt();
		
		if(n > 0) 
			System.out.println("양수입니다.");
		else if(n < 0)
			System.out.println("음수입니다.");
		else
			System.out.println("0입니다.");
	}
	
}
