package chap03_1;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz5 {

	//이진 검색으로 맨 앞의 요소를 찾는 메서드
	static int binSearchX(int[] a, int n, int key) {
		int pl = 0; //처음 인덱스
		int pr = n-1; //맨 뒤 인덱스
		
		while(pl <= pr) {
			int pc = (pl + pr) / 2; //중앙 인덱스
			
			if(a[pc] == key) { //1. 검색 성공했을 때
				for(int i = pc; i >= 0; i--) { //2.그 위치부터 맨 앞으로 이동하면서 
					if(a[i] == a[pc]) { //3. 가장 앞쪽의 인덱스 찾기, 같은 값이 있으면
						pc = i; //4. 그 인덱스 값을 pc에 넣고
					}
				}
				return pc; //맨 앞쪽까지 다 확인 후 pc 반환
			} else if(a[pc] < key) {
				pl = pc + 1;
			} else if(a[pc] > key) {
				pr = pc - 1;
			}
		}
		
		return -1; //검색 실패
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("요솟수: ");
		int num = scan.nextInt();
		int[] a = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("a[" + i + "] =");
			a[i] = scan.nextInt();
		}
		Arrays.sort(a); //오름차순 정렬
		
		System.out.print("찾는값: ");
		int ky = scan.nextInt();
		
		int result = binSearchX(a, num, ky);
		
		if(result == -1)
			System.out.println("찾는값이 없습니다.");
		else
			System.out.println(ky + " 는 a[" + result + "]에 있습니다.");
	}
}
