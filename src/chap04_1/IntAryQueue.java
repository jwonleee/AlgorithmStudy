package chap04_1;

//배열 방식으로 queue
public class IntAryQueue {

	private int max; //총 용량
	private int num; //데이터 수
	private int[] que; //본체

	//실행 시 예외: stack이 비어있음
	public class EmptyIntAryQueueException extends RuntimeException { //실행예외: RuntimeException ▶ 개발자가 직접 예외코드 처리
		public EmptyIntAryQueueException() {}
	}

	//실행 시 예외: stack이 가득참
	public class OverflowIntAryQueueException extends RuntimeException {
		public OverflowIntAryQueueException() {}
	}

	//생성자
	public IntAryQueue(int capacity) {
		max = capacity;
		num = 0; //데이터 수
		try {
			que = new int[max]; //que 본체용 배열 생성
		} catch (Exception e) {
			max = 0;
		}
	}
	
	//인큐
	public int enque(int x) throws OverflowIntAryQueueException {
		if(num >= max)
			throw new OverflowIntAryQueueException(); //큐 가득참
		return que[num++] = x;
	}
	
	//디큐
	//데이터를 꺼내고 앞으로 한칸씩 옮기기 - queue에서는 선입선출이므로 [0]번째 부터 나옴
	public int deque() throws EmptyIntAryQueueException { 
		if(num <= 0)
			throw new EmptyIntAryQueueException();
		
		int x = que[0]; //제일 앞에 있는 값 꺼내기
		//앞으로 한칸씩 옮기기
		for(int i = 0 ; i < num; i++) {
			que[i] = que[i + 1];
		}
		num--; //하나씩 데이터가 줄어드니까 num도 하나씩 줄어듦
		return x;
	}
	
		// 큐에서 데이터를 피크(머리 데이터를 살펴봄)
		public int peek() throws EmptyIntAryQueueException {
			if (num <= 0)
				throw new EmptyIntAryQueueException(); // 큐가 비어 있음
			return que[num - 1]; //가장 최근의 데이터 값 반환
		}

		// 큐에서 x를 검색하여 index(찾지 못하면 -1)를 반환
		public int indexOf(int x) {
			for (int i = 0; i < num; i++)
				if (que[i] == x) // 검색성공
					return i;
			return -1; // 검색실패
		}

		public void clear() {
			num = 0;
		}

		public int capacity() {
			return max;
		}

		public int size() {
			return num;
		}

		public boolean isEmpty() {
			return num <= 0;
		}

		public boolean isFull() {
			return num >= max;
		}

		// 머리 → 꼬리 출력
		public void dump() {
			if (num <= 0)
				System.out.println("큐가 비었습니다.");
			else {
				for (int i = 0; i < num; i++)
					System.out.print(que[i] + " ");
				System.out.println();
			}
		}
}
