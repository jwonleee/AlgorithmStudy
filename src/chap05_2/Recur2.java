package chap05_2;

import java.util.Scanner;

public class Recur2 {
	
	static void recur2(int n) {
		if(n > 0) {
			recur2(n-2);
			System.out.println(n);
			recur2(n-1);
		}
		
		//꼬리 재귀를 버리면 상향식과 같이 나옴
//		while(n>0) {
//	       recur2(n-2);
//	       System.out.println(n);
//	       n=n-1;
//	    }
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int x = scan.nextInt();
		
		recur2(x);
	}
}
