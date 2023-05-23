package chap04_1;

public class IntDeque {

	private int max;
	private int num;
	private int front;
	private int rear;
	private int[] que;
	
	//실행 시 예외: stack이 비어있음
	public class EmptyIntDequeException extends RuntimeException { //실행예외: RuntimeException ▶ 개발자가 직접 예외코드 처리
		public EmptyIntDequeException() {}
	}

	//실행 시 예외: stack이 가득참
	public class OverflowIntDequeException extends RuntimeException {
		public OverflowIntDequeException() {}
	}
	
	//생성자
	public IntDeque(int capacity) {
		num = front = rear = 0;
		max = capacity;
		
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) { //max = 0으로 없애기
			max = 0;
		}
	}
	
	//enqueue 머리쪽부터
	public int endueFront(int x) throws OverflowIntDequeException{
		if(num >= max)
			throw new OverflowIntDequeException();
		num++;
		if(--front < 0)
			front = max - 1;
		que[front] = x;
		return x;
	}
	
	// 덱(deck)에 데이터를 꼬리쪽부터 인큐
	public int enqueRear(int x) throws OverflowIntDequeException {
		if (num >= max)
			throw new OverflowIntDequeException(); // 덱(deck)은 가득 참
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}

	// 덱(deck)의 머리부터 데이터를 디큐
	public int dequeFront() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException(); // 덱(deck)이 비어 있음
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	// 덱(deck)의 꼬리부터 데이터를 디큐
	public int dequeRear() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException(); // 덱(deck)이 비어 있음
		num--;
		if (--rear < 0)
			rear = max - 1;
		return que[rear];
	}

	// 덱(deck)의 머리부터 데이터를 피크(머리데이터를 살펴봄)
	public int peekFront() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException(); // 덱(deck)이 비어 있음
		return que[front];
	}

	// 덱(deck)의 꼬리부터 데이터를 피크(꼬리데이터를 살펴봄)
	public int peekRear() throws EmptyIntDequeException {
		if (num <= 0)
			throw new EmptyIntDequeException(); // 덱(deck)이 비어 있음
		return que[rear == 0 ? max - 1 : rear - 1];
	}

	// 덱(deck)에서 x를 검색하여 index(찾지 못하면 -1)를 반환
	public int indexOf(int x) {
		for (int i = 0; i < num; i++)
			if (que[(i + front) % max] == x) // 검색성공
				return i + front;
		return -1; // 검색실패
	}

	// 덱(deck)에서 x를 검색하여 머리부터 몇 번 째인가(찾지 못하면 0)를 반환
	public int search(int x) {
		for (int i = 0; i < num; i++)
			if (que[(i + front) % max] == x) // 검색성공
				return i + 1;
		return 0; // 검색실패
	}

	// 덱(deck)을 비움
	public void clear() {
		num = front = rear = 0;
	}

	// 덱(deck)의 용량을 반환
	public int capacity() {
		return max;
	}

	// 덱(deck)에 쌓인 데이터 수를 반환
	public int size() {
		return num;
	}

	// 덱(deck)이 비어 있는가?
	public boolean isEmpty() {
		return num <= 0;
	}

	// 덱(deck)이 가득 찼는가?
	public boolean isFull() {
		return num >= max;
	}

	// 덱(deck)내의 데이터를 머리→꼬리의 차례로 나타냄
	public void dump() {
		if (num <= 0)
			System.out.println("덱(deck)이 비었습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % max] + " ");
			System.out.println();
		}
	}
}
