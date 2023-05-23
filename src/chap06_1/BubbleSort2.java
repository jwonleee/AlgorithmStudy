package chap06_1;

import java.util.Scanner;

public class BubbleSort2 {
	//swap 메서드
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	//bubbleSort 메서드
	static void bubbleSort(int[] a, int n) {
		int ecount = 0; //교환 횟수
		for(int i = 0; i < n-1; i++) { //outer loop
			for(int j = n-1; j > i; j--) { //inner loop
				if(a[j-1] > a[j]) {
					swap(a, j-1, j);
					ecount++;
				}
			}
			if(ecount == 0) break; //inner loop가 돌고, 교환이 이루어지지 않으면 종료
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("버블 정렬(ver 1)");
		System.out.print("요솟수: "); int nx = scan.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i < nx; i++) { //배열에 값 넣기
			System.out.print("x[" + i + "] :");
			x[i] = scan.nextInt();
		}
		
		bubbleSort(x, nx); //버블정렬
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < nx; i++) { //정렬 확인
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}
