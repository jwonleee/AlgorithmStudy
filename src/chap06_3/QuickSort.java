package chap06_3;

import java.util.Scanner;

//재귀 사용 퀵 정렬
public class QuickSort {

	//swap 메서드
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	//퀵 정렬 메서드
	static void quickSort(int[] a, int first, int last) {
		System.out.printf("\n\n**first %d, last %d\n", first, last);
		for(int p = 0; p < a.length; p++) {
			System.out.printf("%d ", a[p]);
		}
		System.out.printf("\n");
		
		if(first >= last) return; //재귀함수의 종료 조건
		
		int pivot = first; //피봇(맨 처음 인덱스)
		int i = first+1; //첫번째 인덱스의 다음 인덱스
		int j = last; //마지막 인덱스
		
		System.out.printf("\npivot = %d \n", a[pivot]); //피봇 확인 출력문
		
		while(i <= j) { //i와 j가 교차될 때까지
			while(a[i] <= a[pivot]) i++; //i가 마지막까지, 피봇보다 작으면 i인덱스 증가
			while(a[j] >= a[pivot]) j--; //j가 첫번째까지, 피봇보다 크면 j 인덱스 감소
				if(i > j) { //i와 j가 교차될 때
					swap(a, pivot, j); //j를 기준으로 피봇과 swap
				} else { //i <= j 일 때(정상적일 때 멈춰있다면)
					swap(a, i, j); //i와 j swap
				}
				System.out.printf("swap result\n"); //swap 결과 확인
				for(int p = 0; p < a.length; p++) {
					System.out.printf("%d ", a[p]);
				}
				System.out.printf("\n");
		}
		
		System.out.printf("pivot result\n"); //pivot 결과 확인
		for(int p = 0; p < a.length; p++) {
			System.out.printf("%d ", a[p]);
		}
		System.out.printf("\n");
		
		//피봇 기준으로 재귀함수로 왼쪽 오른쪽도 반복
		quickSort(a, first, j-1);
		quickSort(a, j+1, last);		
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
		
		quickSort(x, 0, nx-1); //퀵 정렬
		
		System.out.println("\n오름차순 정렬 했습니다.");
		for(int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}
