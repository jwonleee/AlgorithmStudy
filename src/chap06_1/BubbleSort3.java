package chap06_1;

import java.util.Scanner;

public class BubbleSort3 {

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; //임의의 변수 t생성해서 차례로 집어 넣어서 바꿈
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	//버블 정렬
	static void bubbleSort(int[] a, int n) {
		int k = 0; //a[k]보다 앞쪽은 정렬을 마친 상태, 0으로 초기화하는 이유는 첫번째 패스에서는 모든 요소를 검사해야 하기 때문
		while(k < n - 1) {
			int last = n - 1; //마지막 요소를 교환한 위치, 마지막으로 교환한 두 요소 가운데 오른쪽 요소의 인덱스 a[j]
			
			for(int j = n - 1; j > k; j--) { //패스 = inner loop
				if(a[j-1] > a[j]) {
					swap(a, j-1, j);
					last = j; 
				}
				k = last; //패스를 마칠 때 다음에 수행할 패스의 범위 제한
			}
			//다음 패스에서 마지막으로 비교할 두 요소는 a[k]와 a[k+1]이 됨
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("버블 정렬(ver 1)");
		System.out.print("요솟수: "); int nx = scan.nextInt();
		int[] x = new int[nx]; //적은 크기의 배열 만들기
		
		for(int i = 0; i < nx; i++) { //배열에 값 넣기
			System.out.print("x[" + i + "] :");
			x[i] = scan.nextInt();
		}
		
		bubbleSort(x, nx); //버블정렬
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < nx; i++) { //정렬 확인
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}
