package chap05_2;

import java.util.Scanner;

public class Recur {
	
	//재귀 함수
	static void recur(int n) {
		if(n > 0) {
			recur(n-1); //n보다 1작은 수
			System.out.println(n); //n 그대로 반환
			recur(n-2); //n보다 2작은 수
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int x = scan.nextInt();
		
		recur(x);
	}
}
