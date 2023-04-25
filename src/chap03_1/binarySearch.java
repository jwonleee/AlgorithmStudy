package chap03_1;

import java.util.Arrays;

public class binarySearch {

	public static void main(String[] args) {
		int[] x = {1, 2, 6, 32, 3};
		//binarySearch 메서드는 오름차순 정렬을 가정하므로 sort 필요
		Arrays.sort(x); //[1, 2, 3, 6, 32]
		
		int result = Arrays.binarySearch(x, 3);
		System.out.println(result); //인덱스 값: 2 반환
	}
}
