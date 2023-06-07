package chap06_3;

import java.util.Scanner;

//매개변수가 요소의 갯수만 있을 때 퀵 정렬
public class Quiz10_2 {

	//swap 메서드
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	static void quickSort(int[] a, int n) {
		for(int p = 0; p < a.length; p++) {
			System.out.printf("%d ", a[p]);
		}
		System.out.printf("\n");
		
		int first = 0;
		int last = n-1;
		int pivot = a[n/2];
		
		while(first <= last) {
			while(a[first] < pivot) first++;
			while(a[last] > pivot) last--;
			if(first <= last) swap(a, first++, last--);
		}
		
		//여기 조건 잘 생각해보기
		if(0 < last) quickSort(a, first);
		if(first < n-1) quickSort(a, last-1);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("요솟수: ");
		int nx = scan.nextInt();
		int[] x = new int[nx]; //배열 생성
		
		for(int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] = ");
			x[i] = scan.nextInt();
		}
		
		quickSort(x, nx); //퀵 정렬
		
		System.out.println("\n오름차순 정렬 했습니다.");
		for(int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}
