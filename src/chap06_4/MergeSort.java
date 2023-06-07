package chap06_4;

public class MergeSort {

	static void merge(int[] data, int[] temp, int first, int last) {
		if(first < last) { //원소가 1개면 비교를 못하니까 들어온 인덱스의 값이 last가 클 때만 비교함 (재귀 종료조건과 같음)
			int mid = (first + last) / 2;  //전체원소/2
			
			//계속 분할 해야하는데 mid값을 기준으로 fisrt~mid, mid+1~last 재귀함수 사용
			merge(data, temp, first, mid);
			merge(data, temp, mid+1, last);
			
			//왼쪽, 오른쪽 부분 집합의 인덱스로 사용하기 위해서 left와 right로 설정
			int left = first; //왼쪽의 첫번째 인덱스
			int right = mid + 1; //오른쪽의 첫번째 인덱스
			int tempIndex = left;
			
			while(left <= mid || right <= last) { //비교하는 작업의 조건
				if(right > last || (left <= mid && data[left] < data[right])) //데이터가 정상적으로 남아있는 경우(right > last || left <= mid), 왼쪽, 오른쪽의 값을 병합하려고 비교하는 것
					temp[tempIndex++] = data[left++];
				else temp[tempIndex++] = data[right++]; //오른쪽이 더 작으면 오른쪽에 있는 인덱스를 넣어줌
			}
				
			System.out.printf("\n\n**** 부분 정렬 결과 ****\n");
			for(int i = 0; i <= temp.length-1; i++) {
				System.out.print(temp[i] + " ");
			}
				
			for(int i = first; i <= last; i++) {
				data[i] = temp[i];
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("병합 정렬 프로그램");
		int[] data = new int[]{30, 50, 7, 40, 88, 15, 44, 55, 22, 33, 77, 99, 11, 66, 1, 85};
		int[] temp = new int[data.length];
		
		System.out.printf("\n**** 병합 정렬 전 데이터 ****\n");
		for(int i = 0; i <= data.length-1; i++) {
			System.out.print(data[i] + " ");
		}
		
		merge(data, temp, 0, data.length-1);
		
		System.out.printf("\n\n**** 병합 정렬 후 데이터 ****\n");
		for(int i = 0; i <= data.length-1; i++) {
			System.out.print(data[i] + " ");
		}
		
	}
}

