package chap06_3;
import java.util.Scanner;

public class Quiz12 {
	
		//swap 메서드
		static void swap(int[] a, int idx1, int idx2) {
			int tmp = a[idx1];
			a[idx1] = a[idx2];
			a[idx2] = tmp;
		}
		
		static void quickSort(int[] a, int left, int right) {
			int first = left;
			int last = right;
			int pivot = a[(left + right) / 2];
			
			while(first <= last) {
				while(a[first] < pivot) first++;
				while(a[last] > pivot) last--;
				if(first <= last) swap(a, first++, last--);
			}
			
			//이거 조건 생각 잘 하기
			if(left < last) quickSort(a, left, last);
			if(first < right) quickSort(a, first, right);
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
