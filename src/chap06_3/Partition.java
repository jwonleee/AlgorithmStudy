package chap06_3;

import java.util.Scanner;

//파티셔닝, 정렬x
//do ~ while에서 그룹을 나눔
public class Partition {

	//swap 메서드
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	static void partition(int[] a, int n) {
		int first = 0; //첫번째
		int last = n - 1; //마지막
		int pivot = a[n / 2]; //피벗 = 가운데 위치
		
		do {
			while(a[first] < pivot) first++;
			while(a[last] > pivot) last--;
			if(first <= last) swap(a, first++, last--);
		} while (first <= last); //겹치기 전까지 반복
		
		System.out.println("pivot : " + pivot);
		
		System.out.println("피벗 이하의 그룹");
		for(int i = 0; i <= first-1; i++) //a[0] ~ a[first-1]
			System.out.print(a[i] + " ");
		System.out.println();
		
		if(first > last + 1) { //이 조건 확인
			System.out.println("피벗과 일치하는 그룹");
			for(int i = last + 1; i <= first -1; i++) //a[last+1] ~ a[first-1]
				System.out.print(a[i] + " ");
			System.out.println();
		}
		
		System.out.println("피벗 이상의 그룹");
		for(int i = last+1; i < n; i++) //a[last+1] ~ a[n-1]
			System.out.print(a[i] + " ");
		System.out.println();
		
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
		
		partition(x, nx); //파티셔닝

	}
	
}
