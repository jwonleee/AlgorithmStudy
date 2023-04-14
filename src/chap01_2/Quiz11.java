package chap01_2;

import java.util.Scanner;

public class Quiz11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		int count = 0; //자리수 하나씩 세기
		
		do {
			System.out.print("양의 정수 입력: ");
			n = scan.nextInt();
		} while (n <= 0);
		
		while(n > 0) {
			n = n/10; //n을 10으로 나누고 다시 n에 넣음
			count++; //count 하나씩 증가
		} //n이 0보다 작거나 같으면 끝남
		
		System.out.println("자릿수는 "  + count + "입니다.");
	}
}
