package chap05_2;

public class IntStack {

	private int max; //스택 용량, 배열 길이
	private int ptr; //스택 포인터, 현재 쌓여 있는 데이터의 수(인덱스가 아님)
	private int[] stk; //스택 본체
	//실제로는 본체를 참조하는 배열 변수로 배열 본체는 생성자에서 생성함
	
	
	//실행 시 예외: stack이 비어있음
	public class EmptyIntStackException extends RuntimeException { //실행예외: RuntimeException ▶ 개발자가 직접 예외코드 처리
		public EmptyIntStackException() {}
	}

	//실행 시 예외: stack이 가득참
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	//생성자
	public IntStack(int capacity) {
		max = capacity;
		ptr = 0;
		try {
			stk = new int[max];	//스택 본체용 배열을 max 길이 맞춰서 생성		
		} catch (Exception e) { //생성할 수 없음
			max = 0;
		}
	}
	
	//스택에 x를 푸시
	public int push(int x) throws OverflowIntStackException {
		if(ptr >= max) //용량보다 들어간 데이터 수가 크거나 같으면
			throw new OverflowIntStackException(); //예외 던짐
		return stk[ptr++] = x; //들어온 데이터 넣기
		//return문은 x를 저장한 후의 stk[ptr]의 값
	}
	
	//스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0) //스택이 비어있음
			throw new EmptyIntStackException(); //예외 던짐
		return stk[--ptr]; //return으로 ptr의 값을 감소시키고, stk[ptr]에 저장되어 있는 값을 반환
	}
	
	//스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
	public int peak() throws EmptyIntStackException {
		if (ptr <= 0) //스택이 비어있음
			throw new EmptyIntStackException();
		return stk[ptr - 1]; //return으로 맨 위 = 가장 최근의 데이터 값을 반환
	}
	
	//스택에서 x를 찾아 인덱스(없으면 -1)를 반환
	public int indexOf(int x) {
		for(int i = ptr-1; i >= 0; i--) { //top부터 bottom까지 선형 검색
			if(stk[i] == x) //x값과 같은 값이 있으면
				return i; //검색 성공, 인덱스 값 나옴
		}
		return -1; //검색 실패
	}
	
	//스택을 비움
	public void clear() {
		ptr = 0;
	}
	
	//스택의 용량을 반환
	public int capacity() {
		return max;
	}
	
	//스택에 쌓여있는 데이터의 수를 반환
	public int size() {
		return ptr;
	}
	
	//스택이 비어있는가?
	public boolean isEmpty() {
		return ptr <= 0; //스택이 비어있으면 false
	}
	
	//스택이 가득 찼는가?
	public boolean isFull() {
		return ptr >= max;
	}
	
	//스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력
	public void dump() {
		if(ptr <= 0) {
			System.out.println("스택이 비어있습니다");
		} else {
			
		for(int i = 0; i < ptr; i++)
			System.out.print(stk[i] + " ");
		System.out.println();
		}
	}
}
