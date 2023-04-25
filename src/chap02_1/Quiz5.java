package chap02_1;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz5 {

	static void rcopy(int[] a, int[] b) {	
		int num = a.length <= b.length ? a.length : b.length ;
		for(int i = 0; i < num; i++) {
			a[i] = b[b.length-i-1]; //단순 복사
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("a의 요솟값: ");
		int num1 = scan.nextInt();
		int[] a = new int[num1]; 
		
		for(int i = 0; i < a.length; i++) {
			a[i] = scan.nextInt();
		}
		
		System.out.print("b의 요솟값: ");
		int num2 = scan.nextInt();
		int[] b = new int[num2]; 
		
		for(int i = 0; i < b.length; i++) {
			b[i] = scan.nextInt();
		}
		
		rcopy(a, b);
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}
