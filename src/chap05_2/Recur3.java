package chap05_2;

import java.util.Scanner;

public class Recur3 {

	static void recur3(int n) {
//		if( n > 0 ) { //실행 조건
//			recur3(n - 1); //recur3(2) - recur3(1) - n=1 - n=2
//			recur3(n - 2); //recur3(1) - n=1
//			System.out.println(n); //n=3 마지막 끝나는 조건
//		}
		
		//스택 사용
		IntStack s = new IntStack(n);
		
		while(true) {
			if(n > 0) {
				s.push(n); 
				n = n-1;
				continue;
			}
			
			if(s.isEmpty() != true) { //스택이 비어있지 않다
				n = s.pop();
				System.out.println(n);
				n = n - 2;
				continue;
			}
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int n = scan.nextInt();
		
		recur3(n); //1 2 1 3
	}
}
