package chap06_2;

import java.util.Scanner;

public class Quiz7 {

	static void insertionSort(int[] a, int n) {
		for (int i = 2; i < n; i++) {
			int tmp = a[0] = a[i];
			int j = i;
			for (; a[j - 1] > tmp; j--)
				a[j] = a[j - 1];
			if (j > 0)
				a[j] = tmp;
		}
	}
	
	// 단순 삽입 정렬 & 보초법
	static void insertion(int a[], int n) {
	    int i, j;

	    for (i = 1; i < n; i++) {
	        int tmp = a[0] = a[i];
	        for (j = i; a[j - 1] > tmp; j--) {
	            a[j] = a[j - 1];
	        }
	        a[j] = tmp; // 설명에 if(j)로 감싸져있었는데, j가 0인 경우는 실행되는 없으므(j=1일때 a[0] > tmp가 성립이 안되므로 무조건 탈출)로 쓸데없는 것 같아서 지움.
	    }
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("단순 삽입 정렬(보초법)");
		System.out.print("요솟수: "); int nx = scan.nextInt();
		int[] x = new int[nx + 1];
//		x[0] = -1;
		
		for (int i = 1; i <= nx; i++) { // x[1]~x[nx]에 읽어 들임
			System.out.print("x[" + i + "]：");
			x[i] = scan.nextInt();
		}
		
//		insertionSort(x, nx);
		insertion(x, nx);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 1; i <= nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
		
		System.out.println(x[0]);
	}
	
}
