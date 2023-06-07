package chap06_4;

import java.util.Scanner;

public class MergeArray {

	static void merge(int[] a, int na, int[] b, int nb, int[] temp) {
		int pa = 0;
		int pb = 0;
		int tempIdx = 0;
		
		while(pa < na && pb < nb) //작은 값을 저장
			temp[tempIdx++] = (a[pa] <= b[pb] ? a[pa++] : b[pb++]);
		
		//위에서 비교가 다 끝나고 남은 요소들 처리
		while(pa < na) //a에 남아있는 요소를 복사
			temp[tempIdx++] = a[pa++];
		
		while(pb < nb) //b에 남아있는 요소를 복사
			temp[tempIdx++] = b[pb++];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = {2, 4, 6, 8, 11, 13};
		int[] b = {1, 2, 3, 4, 9, 16, 21};
		int[] temp = new int[13];
		
		System.out.println("두 배열의 병합");
		merge(a, a.length, b, b.length, temp); //a와 b를 병합하여 temp에 저장
		
		System.out.println("배열 a: ");
		for(int i = 0; i < a.length; i++) {			
			System.out.println("a[" + i + "] = " + a[i]);
		}
		
		System.out.println("배열 b: ");
		for(int i = 0; i < b.length; i++) {			
			System.out.println("b[" + i + "] = " + b[i]);
		}
		
		System.out.println("배열 temp: ");
		for(int i = 0; i < temp.length; i++) {			
			System.out.println("temp[" + i + "] = " + temp[i]);
		}
	}
}
