package chap01_2;

import java.util.Scanner;

public class Quiz14 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		
		System.out.println("사각형을 출력합니다.");
		System.out.print("단 수: "); num = scan.nextInt();
		
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= num; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
