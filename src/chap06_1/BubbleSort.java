package chap06_1;

import java.util.Scanner;

//버블 정렬 ver.1
public class BubbleSort {
	//a[idx 1]와 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; //임의의 변수 t생성해서 차례로 집어 넣어서 바꿈
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	//버블 정렬
	static void bubbleSort(int[] a, int n) {
		for(int i = 0; i < n-1; i++) { //고정 인덱스-1만큼 반복 (맨 앞의 0, 1번째 인덱스는 정렬이 끝난 상태이므로)
			
			//아래 세 줄이 패스
			for(int j = n-1; j > i; j--) { //비교하는 인덱스 값, 확정맨 맨 앞의 i보다 큰 만큼만 확인
				if(a[j-1] > a[j]) //앞의 값이 뒤의 값보다 크면
					swap(a, j-1, j); //두개의 자리 바꾸기
			}		
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
