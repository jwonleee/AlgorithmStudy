package chap06_4;
public class FSort2 {

	static void countingSort(int[] arr, int[] cnt, int[] result) {
		//1. counting 배열 만들기
		for(int i = 0; i < arr.length; i++) {
			cnt[arr[i]]++;
		}
		
		//2. 누적 합 만들기
		for(int i = 1; i < cnt.length; i++) { //i는 1부터 시작
			cnt[i] += cnt[i-1];
		}
		
		//3. i 원소를 인덱스로 하는 counting 배열의 값을 1 감소, counting 배열의 값을 인덱스로 result에 value 값을 저장
		for(int i = arr.length-1; i >= 0; i--) {
			int value = arr[i];
			cnt[value]--;
			result[cnt[value]] = value;
		}
	}
	
	public static void main(String[] args) {
		
		int[] array = new int[100];		// 100개
		int[] counting = new int[31];	// 0 ~ 30개
		int[] result = new int[100];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * 31); // 0 ~ 30 랜덤수
		}
		
		for(int a : array) {
			System.out.print(a + " ");
		}
		
		countingSort(array, counting, result);
		
		for(int i = 0; i < result.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(result[i] + "\t");
		}
		System.out.println();
	}
 
}