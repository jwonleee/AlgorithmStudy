package chap03_1;

import java.util.Arrays;
import java.util.Scanner;

// 어떤 값을 갖는 배열 안의 모든 요소를 다른 배열에 복사함
public class Quiz3 {

	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int count = 0;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] == key) {
				idx[i] = i; //혹은 idx[count++]=i;
				count++;		
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("요솟수: "); int num = scan.nextInt();
		int[] a = new int[num]; //요솟수 num인 배열인 a
		int[] b = new int[num]; //요솟수 num인 배열인 b = idx가 들어갈 배열
		
		for(int i = 0; i < num; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = scan.nextInt();
		}
		System.out.println(Arrays.toString(a));
		
		//찾는 key
		System.out.print("찾는값: ");
		int ky = scan.nextInt();
		
		int result = searchIdx(a, num, ky, b); //idx에는 b배열 들어감
		
		System.out.println("요솟수 개수: " + result);
		
		//답에서는 조건으로 0이면, 요소가 없고, 있으면 넣어줌
		if(result == 0)
			System.out.println("그 값의 요소가 없습니다.");
		else
			for(int i = 0; i < result; i++) {
				System.out.println("그 값은 " + "b[" + b[i] + "]에 있습니다.");
			}
	}
}
