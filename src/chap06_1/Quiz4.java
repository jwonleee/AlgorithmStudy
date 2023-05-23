package chap06_1;

import java.util.Scanner;

public class Quiz4 {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void bubbleSort(int[] a, int n) { //n = 배열의 길이
		int ccount = 0; //비교 횟수
		int ecount = 0; //교환 횟수
	
		int i = 0; //while문으로 돌리니까 정의 해주기
		int k = 0; //a[k]보다 앞은 이미 정렬 마친 상태, 첫번째 패스에서는 모든 요소를 검사해야 하기 때문
		while(k < n - 1) { //outer 루프
			System.out.println("패스" + (i++) + ": ");
			int last = n - 1; //마지막 요소를 교환한 위치
			for(int j = n - 1; j > k; j--) { //inner 루프 (조건 확인)
				
				if(a[j-1] > a[j]) { //앞이 더 크면
					for(int num : a) {
						System.out.printf("%2c %d", (num != a[j])? ' ' : '+', num); //조건: num이랑 현재 a[j]값이랑 같지 않으면 공백
					}
					System.out.println();
					
					ccount++; //비교 카운트
					ecount++; //교환 카운트
					swap(a, j-1, j); //자리 교체
					last = j;
					
				} else if(a[j-1] < a[j]) { //뒤가 더 크면
					for(int num : a) {
						System.out.printf("%2c %d", (num != a[j]) ? ' ' : '-', num);
					}
					ccount++; //비교 카운트
					System.out.println();
				}
			}
			k = last;
			
			//마지막 현재 한 줄
			for(int j = 0; j < n; j++) {
				System.out.printf("%4d", a[j]);
			}
			System.out.println();
		}
		
		System.out.println("비교를 " + ccount + "번 했습니다.");
		System.out.println("교환을 " + ecount + "번 했습니다.");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("버블 정렬(확인)");
		System.out.print("요솟수: "); int nx = scan.nextInt();
		int[] x = new int[nx]; //배열 설정
		
		for(int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] = ");
			x[i] = scan.nextInt();
		} //배열에 값 넣기
		
		bubbleSort(x, nx);
	}
}
