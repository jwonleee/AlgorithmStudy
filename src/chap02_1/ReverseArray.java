package chap02_1;

import java.util.Scanner;

public class ReverseArray {

	//배열 요소 a[a], a[b]의 값을 바꿈
	static void swap(int[] a, int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}
	
	//배열 a의 요소를 역순으로 정렬
	static void reverse(int[] a) {
		for(int i = 0; i < a.length / 2; i++) {
			swap(a, i, a.length-i-1); //a.length-i-1 오른쪽에서 올 경우 인덱스값임
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("요솟수: ");
		int num = scan.nextInt();
		
		int[] x = new int[num]; //길이가 num인 배열 선언
		
		for(int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] = ");
			x[i] = scan.nextInt(); //scan으로 받아서 값 넣기
		}
		
		reverse(x); //배열 a의 요소를 역순으로 정렬
		
		for(int i = 0; i < num; i++) {
			System.out.println("x[" + i + "] = " + x[i]); //출력
		}
	}
}
