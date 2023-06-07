package chap06_4;

import java.util.Scanner;

public class MergeSort2 {

	static int[] temp; //작업용 배열
	
	static void __mergeSort(int[] a, int left, int right) {
		if(left < right) {
			int i; //a의 뒷부분을 사용할 인덱스
			int mid = (left + right) / 2;
			int p = 0; //p는 앞부분을 a에 복사하면서 복사 안된 인덱스의 첫번째가 되어야 함
			int j = 0; //temp에 복사한 앞부분 a의 인덱스
			int k = left; //최종으로 넣는 a인덱스
			
			__mergeSort(a, left, mid); //배열의 앞부분 병합 정렬
			__mergeSort(a, mid+1, right); //배열의 뒷부분 병합 정렬
			
			//정렬을 마친 앞부분, 뒷부분 병합
			//1. 배열 a의 앞부분을 temp에 복사
			for(i = left; i <= mid; i++) {
				temp[p++] = a[i];
			}
			//2. 배열 a의 뒷부분을 temp에 병합
			while(i <= right && j < p) //a[5]까지 복사되면 p = 6
				a[k++] = (temp[j] <= a[i]) ? temp[j++] : a[i++];
			//3. 확정 정렬이 안 된 temp의 나머지 요소를 배열 a에 복사
			while(j < p)
				a[k++] = temp[j++];
		}
	}
	
	//병합 정렬
	static void mergeSort(int[] a, int n) {
		temp = new int[n]; //작업용 배열 생성
		
		__mergeSort(a, 0, n-1); //배열 전체 병합
		
		temp = null; //작업용 배열 해제
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("병합 정렬");
		System.out.print("요솟수: "); int nx = scan.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] = ");
			x[i] = scan.nextInt();
		}
		
		mergeSort(x, nx); //배열 x를 병합
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}
