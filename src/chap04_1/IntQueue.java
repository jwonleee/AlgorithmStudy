package chap04_1;

//스트링 버퍼 방식으로 queue
public class IntQueue {

	private int max; //큐의 총 용량 [0]~[11] = 12
	private int front; //첫번째 요소 커서
	private int rear; //마지막 요소 커서
	private int num; //현재 데이터 수
	private int[ ] que; //큐 본체

	//실행 시 예외: stack이 비어있음
	public class EmptyIntQueueException extends RuntimeException { //실행예외: RuntimeException ▶ 개발자가 직접 예외코드 처리
		public EmptyIntQueueException() {}
	}

	//실행 시 예외: stack이 가득참
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {}
	}
	
	//생성자
	public IntQueue(int capacity) {
		num = front = rear = 0; //기본 초기화
		max = capacity;
		
		try {
			que = new int[max];
		} catch (Exception e) {
			max = 0;
		}
	}
	
	//데이터 인큐
	public int enque(int x) throws OverflowIntQueueException{
		if(num >= max)
			throw new OverflowIntQueueException();
		
		que[rear++] = x; //x를 현재 rear에 넣고 rear++
		num++; //데이터 수 증가
		
		//ex) 0~11 = max = 12, rear[11]에 넣고 rear++하면 rear[12]여야하는데 없으니까 rear[0]으로
		if(rear == max) //++한 rear가 큐의 최대 용량인 max와 같아질 경우
			rear = 0; //rear를 배열의 처음인 0으로 변경
		
		return x;
	}
	
	//데이터 디큐
	public int deque() throws EmptyIntQueueException{
		if(num <= 0) //데이터 수 없으면
			throw new EmptyIntQueueException();
		
		int x = que[front++]; //현재 front에서 빼고, front++
		num--; //데이터 수 감소
		
		if(front == max) //++한 front가 큐의 최대 용량인 max와 같아질 경우
			front = 0; //front를 배열의 처음인 0으로 변경
		
		return x;
	}
	
	//front 데이터를 들여다 봄
	public int peek() throws EmptyIntQueueException{
		if(num <= 0)
			throw new EmptyIntQueueException();
		return que[front];
	}
	
	//x를 검색하여 인덱스 반환 (못 찾으면 -1)
	public int indexOf(int x) {
		for(int i = 0; i < num; i++) { //데이터 개수 만큼만 반복(인덱스 아님)
			
			//front → rear 순으로 선형 검색
			//시작은 front부터
			int idx = (i + front) % max; //인덱스 설정, 12 % 12 = 0이 되므로 처음으로 돌아감
			
			if(que[idx] == x) { //검색 성공
				return x;
			}
		}
		return -1; //실패
	}
	
	//큐 안의 모든 데이터를 출력, front → rear 순서
	public void dump() {
		if(num <= 0) {			
			System.out.println("큐가 비어있습니다.");
		} else {
			for(int i = 0; i < num; i++) {
				System.out.print(que[(i + front) % max] + "");
				System.out.println();
			}
		}
		
	}
	
	public void clear() {
		num = front = rear = 0;
	}
	
	//큐의 용량 반환
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
	
	//main
	public static void main(String[] args) {
		IntQueue s = new IntQueue(10);
		s.enque(1);
		s.enque(3);
		s.enque(4);
		s.enque(5);
		
		s.dump();
	}
	
}

