package chap03_1;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("요솟수: ");
		int num = scan.nextInt();
		int[] x = new int[num];
		
		System.out.println("오름차순으로 입력하세요");
		
		System.out.print("x[0] : "); //배열의 첫번째 인덱스 값 입력
		x[0] = scan.nextInt();
		
		for(int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] = ");
				x[i] = scan.nextInt();
			} while (x[i] < x[i-1]); //바로 앞의 요소보다 작으면 다시 입력하게끔
		}
		
		System.out.print("찾을값: ");
		int ky = scan.nextInt();
		
		int result = Arrays.binarySearch(x, ky); //메서드 사용하여 인덱스값 찾기
		
		if(result < 0) {
			int point = -result -1; //삽입포인트
			System.out.printf("삽입포인트는 %d입니다\n", point);
		}
		else
			System.out.println(ky + "은(는) x[" + result + "]에 있습니다.");
	}
}
