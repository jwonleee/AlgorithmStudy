package chap06_2;

import java.util.Scanner;

import chap03_1.BinarySearchTester;
import chap03_1.binarySearch;

public class BinaryInsertionSort {

	static void binaryInsertionSort(int a[], int n) {
		
		for(int i = 1; i < n; i++) {
			int tmp = a[i];
			
			int point = binarySearch(a, 0, i, tmp);
			
			int j = i - 1;
			while(j >= point) {
				a[j + 1] = a[j];
				j--;
			}
			
			a[point] = tmp;
		}
		
	}
	
	private static int binarySearch(int[] a, int i, int i2, int tmp) {
		return 0;

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("단순 삽입 정렬(보초법)");
		System.out.print("요솟수: "); int nx = scan.nextInt();
		int[] x = new int[nx + 1];
		
		for (int i = 1; i <= nx; i++) { // x[1]~x[nx]에 읽어 들임
			System.out.print("x[" + i + "]：");
			x[i] = scan.nextInt();
		}
		
		binaryInsertionSort(x, nx);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 1; i <= nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
		
		System.out.println(x[0]);
	}
	
}
