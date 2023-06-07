package chap06_4;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz19 {

	static void countingSort(int[] arr, int n, int min, int max) {
		
		int[] counting = new int[max - min + 1];	// min ~ max개, 기존에는 max + 1 로 누적도수 배열 만듦
		
		System.out.println(Arrays.toString(counting));
		System.out.println(Arrays.toString(arr));
		System.out.println("최솟값:" + min);
		System.out.println("최댓값:" + max);
		//25 - 16 + 2 = 11인 크기 배열
		
		//1. counting 배열 만들기
		for(int i = 0; i < n; i++) {
			counting[arr[i] - min]++;
		}
		
		//2. 누적 합 만들기
		for(int i = 1; i < max - min + 1; i++) { //i는 1부터 시작
			counting[i] += counting[i-1];
		}
		
		//3. i 원소를 인덱스로 하는 counting 배열의 값을 1 감소, counting 배열의 값을 인덱스로 result에 value 값을 저장
		int[] result = new int[n]; //기존에는 밖에 었는데 매개값으로 result가 안 들어오니까 여기서 만듦
		
		for(int i = n-1; i >= 0; i--) {
			int value = arr[i];
			counting[value - min]--;
			result[counting[value - min]] = value;
		}
		
		//4. 결과 배열을 기존 배열에 복사
        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }
        
        System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("요소의 개수 : "); int nx = scan.nextInt();
		int[] x = new int[nx];
		
		for(int i = 0; i < x.length; i++) {
			x[i] = (int)(Math.random()*21);	// 0 ~ 20
		}
		
		int max = x[0];
		for(int i = 0; i < nx; i++) {
			if(x[i] > max)
				max = x[i];
		}
		
		int min = x[0];
		for(int i = 0; i < nx; i++) {
			if(x[i] < min)
				min = x[i];
		}
		
		countingSort(x, nx, min, max);

	}
	
	
}
