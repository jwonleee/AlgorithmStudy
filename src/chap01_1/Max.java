package chap01_1;

import java.util.Scanner;

public class Max {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("세 정수의 최댓값 구하기");
		System.out.print("a의 값: ");
		int a = scan.nextInt(); //a 값을 입력받음
		System.out.print("b의 값: ");
		int b = scan.nextInt(); //b 값을 입력받음
		System.out.print("c의 값: ");
		int c = scan.nextInt(); //c 값을 입력받음
		
		int max = a; //a를 max라는 변수에 넣음
		if(b > max) max = b;
		if(c > max) max = c;
		
		System.out.println("최댓값은 " + max + "입니다.");
	}
	
	
	
}
