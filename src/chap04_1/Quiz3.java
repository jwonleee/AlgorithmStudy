package chap04_1;

public class Quiz3 {

	private int max; //스택 용량
	private int ptrA;
	private int ptrB;
	private int[] stk; //스택 본체

	//실행 시 예외: stack이 비어있음
	public class EmptyIntStackException extends RuntimeException { //실행예외: RuntimeException ▶ 개발자가 직접 예외코드 처리
		public EmptyIntStackException() {}
	}

	//실행 시 예외: stack이 가득참
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	//생성자
	public Quiz3(int capacity) {
		max = capacity;
		ptrA = 0;
		ptrB = capacity - 1;
		try {
			stk = new int[max]; //스택 본체용 배열 생성
		} catch (Exception e) {
			max = 0;
		}
	}
	
	//push
	
}
