package chap02_1;

import java.util.Scanner;

public class MaxOfArray {

	static int maxOf(int[] a) { //배열 a의 최댓값을 구하여 반환
		int max = a[0]; //맨 처음 max값을 배열의 첫번째 값
		
		for(int i = 1; i < a.length; i++) {	//배열의 길이만큼 반복	
			if(a[i] > max) { //현재 max값보가 a[i] 인덱스의 값이 더 클 때
				max = a[i]; //max값에 a[i] 값 넣기
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구함");
		System.out.print("사람 수: ");
		int num = scan.nextInt(); //배열의 요솟수를 입력 받음 = 배열의 길이
		
		int[] heigth = new int[num]; //길이가 num인 int형 배열 height 생성
		
		for(int i = 0; i < num; i++) { //배열의 값 넣어줘야 하므로 배열만큼 반복
			System.out.print("height[" + i + "] = ");
			heigth[i] = scan.nextInt(); //배열[인덱스값]에 scan.nextInt();로 값 넣어주기
		}
		
		//반복이 끝나면
		System.out.println("최댓값은 " + maxOf(heigth) + "입니다."); //maxOf() 메서드 안에 height 배열 넣어서 최댓값 반환		
	}
}
