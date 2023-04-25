package chap02_1;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {

	//max값 구하는 메서드
	static int maxOf(int[] a) {
		int max = a[0];
		for(int i = 1; i < a.length; i++) { //a[0]은 이미 max에 들어가있으니까 1부터
			if(max < a[i]) max = a[i];
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		int ran = ((int)Math.random() * 90 ) + 1;
		Random ran = new Random(); //Random 클래스형의 변수(ran) 선언 
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수: ");
		int num = scan.nextInt();
		
		int[] heigth = new int[num];
		
		System.out.println("키 값을 아해와 같습니다.");
		for(int i = 0; i < num; i++) {
			heigth[i] = 100 + ran.nextInt(90); //0 <= nextInt(n) < n 이므로 0~89까지의 난수 생성
			System.out.println("heigth[" + i + "] = " + heigth[i]);
		}
		
		System.out.println("최댓값은 " + maxOf(heigth) + "입니다.");
	}
}
