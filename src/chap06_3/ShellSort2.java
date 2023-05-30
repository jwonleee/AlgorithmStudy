package chap06_3;

import java.util.Scanner;

//shell정렬 (ver2)
public class ShellSort2 {

	static int shellSort(int[] a, int n) {
		int count = 0; //이동 횟수
		int h;
		for(h = 1; h < n / 9; h = h*3+1) { //h의 초깃값: n/9를 넘지 않는 가장 큰 값
		}
		
		for( ; h > 0; h /= 3) { //h가 변하는 방법, h를 3으로 나눠서 마지막에는 1이 됨
			//여기부터는 같음
			for(int i = h; i < n; i++) {
				int tmp = a[i];
				int j;
				for(j = i - h; j >= 0 && tmp < a[j]; j = i-h) {
					a[j+h] = a[j];
					count++;
				}
				a[j+h] = tmp;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("셸 정렬(버전 2)");
		System.out.print("요솟수: "); int nx = scan.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "] = ");
			x[i] = scan.nextInt();
		}
		
		int count = shellSort(x, nx);
		
		System.out.println("오름차순으로 정리했습니다.");
		for(int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]=" + x[i]);
		}
		System.out.println("이동 횟수: " + count);
	}
}
