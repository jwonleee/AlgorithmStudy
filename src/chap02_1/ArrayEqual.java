package chap02_1;

import java.util.Scanner;

public class ArrayEqual {

	static boolean equal(int[] a, int[] b) {
		if(a.length != b.length) { //길이 확인
			return false;
		}
		
		for(int i = 0; i < a.length; i++) { //내용물 확인
			if(a[i] != b[i]) {
				return false;
			}
		}
		
		return true; //두 조건이 다 true이면 결과적으로 같은 배열임
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("a 배열의 요솟수: ");
		int num1 = scan.nextInt();
		int[] a = new int[num1];
		
		for(int i = 0; i < num1; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = scan.nextInt();
		}
		
		System.out.print("b 배열의 요솟수: ");
		int num2 = scan.nextInt();
		int[] b = new int[num2];
		
		for(int i = 0; i < num2; i++) {
			System.out.print("b[" + i + "] = ");
			b[i] = scan.nextInt();
		}
		
		//3항 연산자 사용
		System.out.println("배열 a와 b는 " + (equal(a, b)? "같습니다." : "같지 않습니다"));
		
	}
}
