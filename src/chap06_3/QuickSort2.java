package chap06_3;

import java.util.Scanner;

//비재귀적 quickSort
public class QuickSort2 {

	//swap 메서드
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	static void quickSort(int[] a, int left, int right) {
		//스택의 생성
		IntStack lstack = new IntStack(right - left + 1);
		IntStack rstack = new IntStack(right - left + 1);
		
		lstack.push(left); //첫 lstack = 0
		rstack.push(right); //첫 rstack = 마지막 인덱스
		
		while(!lstack.isEmpty()) { //스택이 비워질 때까지 반복
			int first = left = lstack.pop(); //처음, 왼쪽
			int last = right = rstack.pop(); //마지막, 오른쪽
			int pivot = a[(left + right) / 2]; //피벗
		
		do {
			while(a[first] < pivot) first++;
			while(a[last] > pivot) last--;
			if(first <= last)
				swap(a, first++, last--);
		} while (first <= right);
		
		//왼쪽 그룹과 오른쪽 그룹으로 나뉨 a[left] ~ a[right]
		//pivot 보다 작은 구간 push
			if(left < last) { //a[0] ~ a[4]
				lstack.push(left);
				rstack.push(last);
			}
		//pivot 보다 큰 구간 push
			if(first < right) { //a[5] ~ a[8]
				lstack.push(first);
				rstack.push(right);
			}
		}
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
