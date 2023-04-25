package chap02_1;

import java.util.Random;

public class Quiz1 {

	//max값 구하는 메서드
	static int maxOf(int[] a) {
		int max = a[0];
		for(int i = 1; i < a.length; i++) {
			if(max < a[i]) max = a[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
		Random ran = new Random();
		
		int length = ran.nextInt(20)+1; //0~20
		
		int[] heigth = new int[length];
		System.out.println(heigth.length); //배열의 길이 확인
		
		for(int i = 0; i < length; i++) {
			heigth[i] = 100 + ran.nextInt(90); //0~89까지 난수 생성
			System.out.println("heigth[" + i + "] = " + heigth[i]);
		}
		
		System.out.println("최댓값은 " + maxOf(heigth) + " 입니다.");
	}
}
