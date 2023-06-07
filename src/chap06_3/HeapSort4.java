package chap06_3;

public class HeapSort4 {
	
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	// 힙을 출력
	static void heapSort(int a[], int size) {
		/*
		 * 부모노드와 heapify 과정에서 음수가 발생하면 잘못된 참조가 일어나기 때문에
		 * 원소가 1개 혹은 0개 일때는 함수 종료
		 */
		if(size < 2) return;
		
		/*
		 * parent 인덱스 = a[ (index - 1) / 2 ]
		 * left 인덱스 = a[ index * 2 + 1 ] 
		 * right 인덱스 = a[ index * 2 + 2 ] 
		 */
		int lastParentIdx = (size - 1) / 2; //가장 마지막 요소의 부모 인덱스
		
		//최대 힙
		for(int i = lastParentIdx; i >= 0; i--) {
			heapify(a, i, size-1);
		}
		
		/*
		 *  root인 0번째 인덱스와 i번째 인덱스의 값을 교환해준 뒤
		 *  0 ~ (i-1) 까지의 부분트리에 대해 최대힙을 만족하도록 반복
		 */
		for(int i = size - 1; i > 0; i--) {
			swap(a, 0, i);
			heapify(a, 0, i-1);
		}
	}
	
	static void heapify(int[] a, int parentIdx, int lastIdx) {
		int left;
		int right;
		int largestIdx;
		
		/*
	     * (현재 부모 인덱스의) 자식 노드 인덱스가 마지막 인덱스를 넘지 않을 때 까지 반복
	     * 왼쪽 자식 노드를 기준으로 해야 함
	     * 오른쪽 자식 노드를 기준으로 범위를 검사하게 되면 마지막 부모 인덱스가 왼쪽 자식만 갖고 있을 경우 왼쪽 자식노드와는 비교 및 교환 불가
	     */
		
		while((parentIdx * 2 + 1) <= lastIdx) {
			left = (parentIdx * 2) + 1;
			right = (parentIdx * 2) + 2;
			largestIdx = parentIdx;
			
			if(a[left] > a[largestIdx]) largestIdx = left; //while문에서 비교함
			
			if(right <= lastIdx && a[right] > a[largestIdx]) largestIdx = right;
			
			if(largestIdx != parentIdx) {
				swap(a, parentIdx, largestIdx);
				parentIdx = largestIdx;
			} else {
				return;
			}
		}
		
	}
	
	public static void main(String[] args) {
//		int[] data = {10, 1, 5, 6, 3, 2, 4, 7, 9, 8};
		int[] data = {22, 5, 11, 32, 120, 68, 70};

		heapSort(data, data.length);
		
		for(int i = 0; i < data.length; i++) {			
			System.out.println("data[" + i + "] = " + data[i]);
		}
	}
}
