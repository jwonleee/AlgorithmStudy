package chap01_1;

import java.util.Scanner;

public class Quiz3 {

	static int min4(int a, int b, int c, int d) { //최솟값 구하는 메서드
		int min = a;
		if(b < min) min = b;
		if(c < min) min = c;
		if(d < min) min = d;
		
		return min;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //scan으로 입력 받음
		
		System.out.print("a의 값: "); int a = scan.nextInt();
		System.out.print("b의 값: "); int b = scan.nextInt();
		System.out.print("c의 값: "); int c = scan.nextInt();
		System.out.print("d의 값: "); int d = scan.nextInt();
		
		int min = min4(a, b, c, d); //위에서 입력 받은 숫자를 min4메서드 안에 넣고 min 변수에 담아줌
		System.out.println("네 값 중 최솟값은: " + min); //min 출력
	}
}
