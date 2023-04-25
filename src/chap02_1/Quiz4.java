package chap02_1;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz4 {

	static void copy(int[] a, int[] b) {
		if(a.length != b.length) System.out.println("두 배열의 길이가 같지 않습니다.");
		for(int i = 0; i < a.length; i++) {
			a[i] = b[i];
		}
	}
	
	// 배열 b의 모든 요소를 배열 a에 복사 ▶ 여기서는 길이가 같은지는 중요하지 않음
	//static void copy(int[] a, int[] b) {
	//	int num = a.length <= b.length ? a.length : b.length; //a길이가 작으면 a만큼만, b가 작으면 b만큼만
	//	for (int i = 0; i < num; i++)
	//		a[i] = b[i];
	//}
	
	// 역순 복사
	//a[i] = b[b.length - i - 1];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("a의 요솟수는 ：");
		int num1 = scan.nextInt();
		int[] a = new int[num1];
		for (int i = 0; i < num1; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = scan.nextInt();
		}

		System.out.print("b의 요솟수는 ：");
		int num2 = scan.nextInt();
		int[] b = new int[num2];
		for (int i = 0; i < num2; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = scan.nextInt();
		}
		
		copy(a, b);
		
		System.out.println("a배열 = " + Arrays.toString(a));
		System.out.println("b배열 = " + Arrays.toString(b));
	}
	
}
