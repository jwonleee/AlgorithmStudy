package chap01_2;

import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합");
		System.out.print("n의 값: ");
		int n = scan.nextInt();
		
		//int sum = (1 + n) * (n / 2); //짝수일 때는 맞음
		int sum = (n + 1) * (n / 2) + (n%2 == 1? (n+1)/2 : 0); //n이 홀수이면 (n+1)/2을 더함, 짝수이면 그대로
		System.out.println(sum);
		
	}
}
