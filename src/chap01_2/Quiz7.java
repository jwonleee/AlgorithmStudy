package chap01_2;

import java.util.Scanner;

public class Quiz7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("n의 값: ");
		int n = scan.nextInt();
		
		int sum = 0; //합계
		
		for(int i = 1; i <= n; i++) { //반복문
			if(i < n) //i가 n보다 작으면
				System.out.print(i + "+"); //i에 + 붙임
			else //i가 n이면
				System.out.print(i); //마지막으로 i 붙임
			
			sum += i; //sum에 i를 더함
		}
		System.out.print(" = " + sum); //최종 sum 적기
	}
}
