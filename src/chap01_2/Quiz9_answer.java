package chap01_2;

import java.util.Scanner;

public class Quiz9_answer {

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
		
		int min; //a, b 중 작은 값
		int max; //a, b 중 큰 값

		if(a > b) {	//애초에 조건식으로 큰값, 작은값을 나누고
			min = b;
			max = a;
		} else {
			min = a;
			max = b;
		}
		
		int sum = 0; //합계
		for(int i = min; i <= max; i++) { //하나씩 더해가면서 합계를 구함
			sum += i;
		}
		
		return sum;
	}
}
