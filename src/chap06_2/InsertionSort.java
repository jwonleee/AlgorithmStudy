package chap06_2;

import java.util.Scanner;

public class InsertionSort {
	//단순 삽입 정렬
	
	//for - for 사용
//	static void insertionSort (int[] a, int n) {
//		for(int i = 1 ; i < n; i++) { //size = 2부터 시작, a[0]은 정렬되어 있다고 가정
//			int j;
//			int tmp = a[i]; //tmp에 정렬되지 않은 맨 앞의 인덱스를 넣어줌
//			for(j = i; j > 0 && a[j-1] > tmp; j--) { //inner loop, j=1부터 확인, a[0] > tmp 이면 오른쪽으로 밀면서 넣어줌, 계속 반복
//				a[j] = a[j-1];
//			}
//			a[j] = tmp; //조건이 성립하지 않아 for문이 끝나면 inner loop 돌기전 저장했더 tmp를 비교한 오른쪽 인덱스에 넣어줌
//		}
//	}
	
	//for - while 사용
	static void insertionSort (int[] a, int n) {
		for(int i = 1; i < n; i++) { //0번 인덱스는 이미 정렬이 되어있다고 가정, 1번부터 삽입될 값임
			int key = a[i]; //key값에다가 정렬되지 않은 맨 앞의 인덱스를 넣어줌
			
			int j = i; //j는 정렬된 inner loop에서 사용
			//여기서 계속 오른쪽으로 밀어내면서 확인하게 됨
			while(j > 0 && a[j-1] > key) { //앞에 있는 정렬된 a[j-1]가 정렬되지 않은 뒤의 key값보다 크면 inner loop로 들어감
				a[j] = a[j-1];
				j--;
			}
			
			a[j] = key;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("단순 삽입 정렬");
		System.out.print("요솟수: "); int nx = scan.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] = ");
			x[i] = scan.nextInt();
		}
		insertionSort(x, nx); //배열 x를 단순 삽입 정렬
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
	
}
