package chap01_1;

import java.util.Scanner;

public class Quiz4 {

	static int med(int a, int b, int c) {
		if(a >= b) //a가 b보다 크고
			if(b >= c) //b가 c보다 크면
				return b; //중앙값 b
			else if(a <= c)
				return a;
			else
				return c;
		
		else if(a > c) //a<b && a>c
			return a;
		
		else if(b > c) //a<b && a<=c && b>c
			return c;
		
		else
			return b;
	}	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("세 정수의 중앙값을 구합니다."); 
		
		System.out.print("a의 값: "); int a = scan.nextInt();
		System.out.print("b의 값: "); int b = scan.nextInt();
		System.out.print("c의 값: "); int c = scan.nextInt();
		
		int med = med(a, b, c);
		System.out.println("중앙값은 " + med + "입니다.");
	}
}
