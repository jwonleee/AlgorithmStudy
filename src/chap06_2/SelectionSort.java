package chap06_2;

import java.util.Scanner;

public class SelectionSort {

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; //임의의 변수 t생성해서 차례로 집어 넣어서 바꿈
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void selectionSort(int[] a, int n) {
		for(int i = 0; i < n - 1; i++) {
			int min = i; //min의 기준은 a[0]부터 확인
			for(int j = i + 1; j < n; j++) { //a[1]부터 확인, j는 n보다 작음, j는 인덱스임!!		
				if(a[j] < a[min]) //min 작은 요소가 더 크면
					min = j; //min에 j 인덱스 넣기
			}
			swap(a, i, min); //정렬되지 않은 부분의 첫 요소와 가장 작은 요소 교환
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("단순 선택 정렬");
		System.out.print("요솟수: "); int nx = scan.nextInt();
		int[] x = new int[nx]; //적은 크기의 배열 만들기
		
		for(int i = 0; i < nx; i++) { //배열에 값 넣기
			System.out.print("x[" + i + "] :");
			x[i] = scan.nextInt();
		}
		
		selectionSort(x, nx); //버블정렬
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < nx; i++) { //정렬 확인
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
	
}
