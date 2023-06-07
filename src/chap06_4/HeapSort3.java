package chap06_4;

public class HeapSort3 {

	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	// 2의 n 제곱을 구합니다
	static int pow2(int n) {
		int k = 1;

		while (n-- > 0)
			k *= 2;
		return (k);
	}

	// n개의 스페이스를 출력
	static void dispSpace(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(' ');
//			System.out.print(' ');
		}
	}
	
	// 힙을 출력
	static void dispHeap(int a[], int n) {
		int i = n;
		int height = 1; // 트리의 높이
		while ((i >>= 1) > 0)
			height++;
		i = 0;
		int w = 1;
		Loop: {
			for (int level = 0; level < height; level++) {
				dispSpace(pow2(height - level) - 1);
				for (int k = 0; k < w; k++) {
					System.out.printf("%02d", a[i++]);
					if (i >= n)
						break Loop;
					if (k < w - 1)
						dispSpace(pow2(height - level + 1) - 2);
				}
				System.out.println();

				dispSpace(pow2(height - level) - 4);
				for (int k = 0; k < w; k++) {
					if (2 * k + i < n)
						System.out.print(" ／ ");
					if (2 * k + i + 1 < n)
						System.out.print(" ＼ ");
					if (k < w - 1)
						dispSpace(pow2(height - level + 1) - 8);
				}
				System.out.println();
				w *= 2;
			}
		}
		System.out.println();
		System.out.println();
	}
	
	static void heapSort(int[] a, int size) {
		//1. 최대 힙 구조로 변환 (상 → 하)
		for(int i = 1; i < size; i++) {
			int c = i;
			do {
				//c는 자식이고, 부모는 1개, 부모가 자식보다 크게 변환
				//부모가 자식을 최대 2개까지 가질 수 있고, 2번째 자식이 부모보다 클 수 있지만 size까지 다 돌면 해결
				int parent = (c - 1) / 2; //0(1-2), 1(3-4), 2(5-6) 이런식으로
				if(a[parent] < a[c]) {
					swap(a, parent, c);
				} else {
					break; //이론상 변경이 없으면 이미 위로는 힙구조
				}
				c = parent; //자식이 부모로 이동해서 반복적으로 수행
			} while (c != 0);
		}
		
		//출력
		dispHeap(a, size);
		
		//2. 크기를 줄이면서 힙 유지
		for(int i = size - 1; i >= 1; i--) {
			//현재 a[0] 자리(최상위, 루트)에는 최댓값이 있고, 이를 i로 빼냄. 반복하면 내림차순 정렬
			swap(a, 0, i);
			//i를 제외한 전부를 다시 최대힙으로 변경, 따라서 0번 자리에는 i를 제외한 가장 큰 값이 위치함
			//이 때 c와 parent를 비교하여, 변경된 c 가지 방향으로만 나아가면 됨
			int parent = 0;
			do {
				int c = 2 * parent + 1;
				if(c >= i) break;
				if(c + 1 < i) {
					if(a[c] < a[c + 1])
						c++;
				}
				if(a[parent] < a[c]) {
					swap(a, parent, c);
				} else { //변경이 없다면 c가지 방향으로 이미 힙구조가 되어 있음
					break;
				}
				parent = c;
			} while (true);
			
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
