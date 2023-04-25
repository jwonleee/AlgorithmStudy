package chap02_1;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz2 {
	
	//두 자리 바꾸기
	static void swap(int[] x, int a, int b) {
		int t = x[a];
		x[a] = x[b];
		x[b] = t;
	}
	
	//배열 x의 요소를 역순 정렬
	static void reverse(int[] x) {
		for(int i = 0; i < x.length/2; i++) {
			swap(x, i, x.length-i-1);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] x = new int[5];
		
		for(int i = 0; i < 5; i++) {
			x[i] = scan.nextInt();
		}
		
		System.out.println(Arrays.toString(x));
		
		
		for(int i = 0; i < 5; i++) {
			System.out.println("a[" + i + "]과(와) a[" + (x.length-i-1) + "]를 교환합니다.");
			reverse(x);
			System.out.println(Arrays.toString(x));
		}
		System.out.println("역순 정렬을 마쳤습니다");
	}
}
