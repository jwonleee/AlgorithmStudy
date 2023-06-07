package chap06_3;

import java.util.Scanner;

public class Quiz11 {

	//swap 메서드
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	static void quickSort(int[] a, int left, int right) { //stack 사용
		//스택의 생성
		IntStack lstack = new IntStack(right - left + 1);
		IntStack rstack = new IntStack(right - left + 1);
		
		lstack.push(left);
		rstack.push(right);
		System.out.printf("a[%d] ~ a[%d]를 분석하는 문제를 스택에 푸시합니다.\n", left, right);
		System.out.print("Lstack: ");
		lstack.dump(); //스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력
		System.out.print("Rstack: ");
		rstack.dump();
		
		while(!lstack.isEmpty()) { //스택이 비어지지 않을 때까지 반복
			int first = left = lstack.pop(); //왼쪽
			int last = right = rstack.pop(); //오른쪽
			int pivot = a[(left + right)/2]; //중앙
			System.out.printf("스택에서 분할하는 문제를 꺼냈습니다. a[%d] ~ a[%d]를 분할합니다.\n", left, right);
		
			do {
				while(a[first] < pivot) first++;
				while(a[last] > pivot) last--;
				if(first <= last) swap(a, first++, last--);
			} while (first <= last);
		
			if(left < last) {
				lstack.push(left); // 머리쪽 그룹의 범위
				rstack.push(last); // (index)를 푸시
				System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, last);
				System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
			}
			
			if (first < right) {
				lstack.push(first); // 꼬리쪽그룹의 범위
				rstack.push(right); // (index)를 푸시
				System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", first, right);
				System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
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
