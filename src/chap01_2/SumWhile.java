package chap01_2;

import java.util.Scanner;

public class SumWhile {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합");
		System.out.print("n의 값: ");
		int n = scan.nextInt();
		
		int sum = 0; //합
		int i = 1; //1부터 시작
		
		while(i <= n) { //i가 1부터~n까지 반복
			sum += i; //합계에 i담기
			i++; //i를 1만큼 증가
			System.out.println(i); //마지막 i의 값은 n이 아니라 n+1
		}
		System.out.println("최종 합은 " + sum);
	}
}
