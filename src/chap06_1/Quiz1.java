package chap06_1;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz1 {
	//값 바꾸기
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	//버블 정렬
	static void bubbleSort(int[] a, int n) { //n = 배열의 길이
		for(int i = 0; i < n-1; i++) { //전체 루프 도는 부분
			
			for(int j = 0; j < n-i-1; j++) { //n-1-i 확정된 맨 마지막 자리는 확인할 필요 없음, i는 위치가 확정된 숫자의 개수 
				if(a[j] > a[j+1]) { //앞의 숫자가 더 크면 자리 바꾸기
					swap(a, j, j+1); //자리 바꾸기
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("버블 정렬(ver 2)");
		System.out.print("요솟수: "); int nx = scan.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] = ");
			x[i] = scan.nextInt();
		}
		
		bubbleSort(x, nx);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < nx; i++) { //정렬 확인
			System.out.println("x[" + i + "] = " + x[i]);
		}
		System.out.println(Arrays.toString(x));
	}
}
