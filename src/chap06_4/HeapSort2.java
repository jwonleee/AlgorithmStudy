package chap06_4;

public class HeapSort2 {

	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	static void heapSort(int[] a, int size) {
		//1. 전체 트리 구조를 최대 힙 구조로 바꿈
		for(int i = 1; i < size; i++) {
			int c = i; //c는 맨 위 루트 제외하고 1, 2, 3, 4... 마지막 배열까지 반복, 자식 루트
			do {
				int root = (c - 1) / 2; //root는 특정 요소의 부모 루트 
				if(a[root] < a[c]) {
					swap(a, root, c); //자식이 더 크면 부모랑 자식이랑 swap
				}
				c = root; //자식이 부모로 이동해서 반복적으로 수행
			} while (c != 0);
		}
		
		//2. 크기를 줄여가며 반복적으로 힙 구성
		for(int i = size-1; i >= 0; i--) {
			//▼ 가장 큰 값을 맨 뒤로 보내는 부분
			swap(a, 0, i); //기본적으로 가장 큰 값인 루트(=a[0])와 가장 마지막에 있는 요소를 바꿔줌
			
			int root = 0;
			int c = 1;
			
			//▼ 힙 구조를 만드는 부분
			do {
				c = 2 * root + 1;
				//자식 중에 더 큰 값 찾기
				if(c < i - 1 && a[c] < a[c+1]) {//c<i-1 범위밖으로 안 넘어가게 막아줌
					c++; //c를 더해줘서 오른쪽으로 이동시켜 줌
				}
				//루트보다 자식이 더 크다면 교환
				if(c < i && a[root] < a[c]) {
					swap(a, root, c);
				}
				root = c; //한 번 바꾸면 c를 root로 이동시켜서 재귀적으로 힙 구조를 만들어줌
			} while (c < i);
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
