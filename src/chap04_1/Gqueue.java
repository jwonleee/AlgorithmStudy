package chap04_1;

public class Gqueue<E> {

	private int max; //용량, 인덱스+1
	private int front;
	private int rear;
	private int num; //데이터 수
	private E[] que;
	
	//제너릭 클래스는 하위클래스가 될 수 없으므로 static을 붙여야 runtimeException에서 오류가 안남
	//실행 시 예외: stack이 비어있음
	public static class EmptyIntQueueException extends RuntimeException { //실행예외: RuntimeException ▶ 개발자가 직접 예외코드 처리
		public EmptyIntQueueException() {}
	}

	//실행 시 예외: stack이 가득참
	public static class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {}
	}
	
	//생성자
	public Gqueue(int capacity) { //capacity = 용량 설정
		num = front = rear = 0;
		max = capacity;
		
		try {
			que = (E[])new Object[max]; //객체형이고, E[]로 형변환
		} catch (Exception e) {
			max = 0; 
		}
	}
	
	//enqueue - 예외
	public E enque(E x) throws OverflowIntQueueException {
		if(num >= max)
			throw new OverflowIntQueueException();
		
		que[rear++] = x; //x를 현재 rear에 넣고, rear++해서 다음 인덱스로
		num++;
		
		if(rear == max)
			rear = 0;
		
		return x;
	}
	
	//dequeue - 예외
	public E dequeue() throws EmptyIntQueueException {
		if(num <= 0) //큐가 비어있으면
			throw new EmptyIntQueueException();
		E x = que[front++]; //front의 인덱스값 꺼내고 front++
		num--; //개수는 하나 줄이기
		if(front == max) //front 위치가 max 용량과 같으면 front = 0으로 설정
			front = 0;
		return x;
	}
	
	//peek - 예외
	public E peek() throws EmptyIntQueueException{
		if(num <= 0)
			throw new EmptyIntQueueException();
		E x = que[front];
		return x;
	}
	
	//indexOf - 인덱스 반환, 없으면 -1
	public int indexOf(E x) {
		for(int i = 0; i < num; i++) {
			if(que[(i+front) % max] == x) {
				return i + front; //인덱스값 반환
			}
		}
		return -1; //실패
	}
	
	//search - 몇 번째인지 반환, 없으면 -1
	public int search(E x) {
		for(int i = 0; i < num; i++) {
			if(que[(i + front) % max] == x) {
				return i + 1;
			}
		}
		return -1;
	}
	
	//queue를 비움
	public void clear() {
		num = front = rear = 0;
	}
	
	//queue 용량
	public int capacity() {
		return max;
	}
	
	//queue 데이터의 수
	public int size() {
		return num;
	}
	
	public boolean isEmpty() {
		return num <= 0;
	}
	
	public boolean isFull() {
		return num >= max;
	}
	
	//머리 → 꼬리의 차례로 큐 안의 데이터를 나타냄
	public void dump() {
		if(num <= 0) {
			System.out.println("큐가 비었습니다.");
		} else {
			for(int i = 0; i < num; i++) {
				System.out.print(que[(i + front) % max].toString() + "");
				System.out.println();
			}
		}
	}


}
