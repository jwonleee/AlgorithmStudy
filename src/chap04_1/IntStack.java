package chap04_1;

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
		if(ptr >= max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	
	//스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0) //스택이 비어있음
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	
	//스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
	public int peak() throws EmptyIntStackException {
		if (ptr <= 0) //스택이 비어있음
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}
	
}
