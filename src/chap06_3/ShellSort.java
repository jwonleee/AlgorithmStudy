package chap06_3;

import java.util.Scanner;

//shell정렬 (ver1)
public class ShellSort {

	static int shellSort(int[] a, int n) { //n = 배열의 길이
		int count = 0;
		for(int h = n/2; h > 0; h /= 2) { //{8, 1, 4, 2, 7, 6, 3, 5} 일 때 h = 4, 2, 1 ▶ h-정렬 나타냄
			for(int i = h; i < n; i++) { //급간부터 끝까지 돌려가면서 실행
				int tmp = a[i];
				int j;
				for(j = i - h; j >= 0 && tmp < a[j]; j = j-h) { //8과0(8-8), 9와 1(9-8), 10과 2(10-8)... 비교, 극간이 4일때 8과 4일때, j = 4-4 = 0인데 조건에 j>=0이므로 0까지 감
					a[j + h] = a[j]; //앞이 더 크면 바꿔줌
				}
				a[j+h] = tmp; //조건문을 빠져나온 j는 이미 j-h 연산이 끝났으므로 다시 +h 해야함 (ex) 0-8 = -8이니까 +8해서 0으로 만들어줌)
				count++;
			}	
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("셸 정렬(버전 1)");
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
