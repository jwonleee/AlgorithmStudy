package chap01_2;

import java.util.Scanner;

public class Quiz9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("a 값: ");
		int a = scan.nextInt();
		System.out.print("b 값: ");
		int b = scan.nextInt();
		
		int result = sumof(a, b);
		System.out.println(result);
	}
	

	static int sumof(int a, int b) {
		
		if(a+b % 2 == 0) { //a+b가 짝수이면
			if(a > b) { //a가 클 때라는 가정으로 같은 식을 반복하므로 효율이 떨어짐
				return (a+b)*(a-b)/2;				
			} else {
				return (a+b)*(b-a)/2;
			}
		} 
		else { //a+b가 홀수이면
			if(a > b) {				
				return (a+b)*(a-b+1)/2;
			}else {
				return (a+b)*(b-a+1)/2;
			}
		}

	}
}
