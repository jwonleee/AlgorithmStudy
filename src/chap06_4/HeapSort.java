package chap06_4;

public class HeapSort {

	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	//a[left] ~ a[right]를 힙으로 만듦
	//루트를 없애고 힙 상태로 만듦
	static void downHeap(int[] a, int left, int right) {
		int tmp = a[left]; //루트
		int child; //큰 값을 가진 노드
		int parent; //부모
		
		for(parent = left; parent < (right + 1) / 2; parent = child) {
			int cl = parent * 2 + 1; //왼쪽 자식
			int cr = cl + 1; //오른쪽 자식
			child = (cr <= right && a[cr] > a[cl]) ? cr : cl; //큰 값을 가진 노드를 자식에 대입
			if(tmp >= a[child])
				break;
			a[parent] = a[child];
		}
		a[parent] = tmp;
	}
	
	//힙 정렬
	static void heapSort(int[] a, int size) {
		//downHeap 메서드를 사용하여 배열 a를 힙으로 만듦
		for(int i = (size-1) / 2; i >= 0; i--) { //a[i] ~ a[len-1]을 힙으로 만듦
			downHeap(a, i, size-1);
		}
		
		//a[0]에 있는 가장 큰 값을 빼내어 마지막 배열 요소와 바꾸고, 배열의 나머지 부분을 다시 힙으로 만듦
		for(int i = size - 1; i > 0; i--) {
			swap(a, 0, i); //가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
			downHeap(a, 0, i-1); //a[0] ~ a[i-1]을 힙으로 만듦
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
