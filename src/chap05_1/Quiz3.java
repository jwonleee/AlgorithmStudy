package chap05_1;

import java.util.Scanner;

public class Quiz3 {

	static int gcd(int x, int y) {
		if(y == 0) {
			return x;
		} else {
			return gcd(y, x % y);
		}
	}
	
	static int gcdArray(int[] a) {
		int z = gcd(a[0], a[1]);
		for(int i = 2; i < a.length; i++) { //처음부터 끝까지 반복
			z = gcd(z, a[i]); //첫번째에 10나옴
		}
		return z;
	}
	
	public static void main(String[] args) {
//		int[] array = { 5, 10, 15, 20 };
		int[] array = { 14, 10, 15, 34 };
		
		System.out.println("배열의 최대공약수를 구합니다.");

		System.out.println("배열의 최대공약수는 " + gcdArray(array) + "입니다.");
	}
}
