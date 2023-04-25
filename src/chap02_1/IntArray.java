package chap02_1;

import java.util.Arrays;

public class IntArray {

	public static void main(String[] args) {
		int[] a = new int[5]; //크기가 5인 int형 배열 선언
		
		a[1] = 37;
		a[2] = 51;
		a[4] = 74;
		
		System.out.println(Arrays.toString(a));
		for(int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
	}
}
