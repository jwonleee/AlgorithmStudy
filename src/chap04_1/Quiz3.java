package chap04_1;


public class Quiz3 {

	private int max; //스택 용량
	//다중 스택에서는 ptr이 스택포인터로서의 역할, 다음에 저장될 데이터의 인덱스값을 갖고있는 변수
	private int ptrA; //스택 포인터A
	private int ptrB; //스택 포인터B
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
		ptrB = max - 1; 
		try {
			stk = new int[max]; //스택 본체용 배열 생성
		} catch (Exception e) {
			max = 0;
		}
	}

	//stack 선택 사용을 위한 열거형
	enum AB{
		StackA,
		StackB
	}

	//push stackA or stackB
	public int push(AB sw, int x) throws OverflowIntStackException {
		if(ptrA >= ptrB + 1) //그림 잘 보고 이해
			throw new OverflowIntStackException();

		switch (sw) {

		case StackA : 
			stk[ptrA++] = x;
			break;

		case StackB :
			stk[ptrB--] = x;
			break;
		}
		return x;
	}

	//pop stackA or stackB (꼭대기의 데이터를 꺼냄)
	public int pop(AB sw) throws EmptyIntStackException {
		int x = 0; //꺼낸 데이터를 넣을 변수
		switch (sw) {
		case StackA:
			if(ptrA <= 0)
				throw new EmptyIntStackException();
			x = stk[--ptrA]; //ptr 기준 꼭대기 (비어있는 곳을 가리키기 때문에 감소해주고 값 얻기)
			break;

		case StackB:
			if(ptrB >= max - 1)
				throw new EmptyIntStackException();
			x = stk[++ptrB];
			break;
		}
		return x;
	}

	//peak (꼭대기의 데이터를 살펴봄)
	public int peek(AB sw) throws EmptyIntStackException {
		int x = 0;
		switch (sw) {
		case StackA:
			if(ptrA <= 0)
				throw new EmptyIntStackException();
			x = stk[ptrA - 1];
			break;

		case StackB:
			if(ptrB >= max -1)
				throw new EmptyIntStackException();
			x = stk[ptrB + 1];
			break;
		}
		return x;
	}

	//스택에서 x 검색하여 인덱스 반환 (없으면 -1)
	public int indexOf(AB sw, int x) {
		switch (sw) {
		case StackA:
			for(int i = ptrA - 1; i >= 0; i--) {
				if(stk[i] == x) //Gsrack에서는 E형 타입이니까 equals로 비교
					return i; //검색 성공
			}
			break;

		case StackB:
			for(int i = ptrB + 1; i <= max; i++) {
				if(stk[i] == x)
					return i;
			}
			break;
		}

		return -1; //검색 실패
	}

	//스택을 비움 (A, B 선택해서 비우기 가능)
	public void clear(AB sw) {
		switch (sw) {
		case StackA:
			ptrA = 0;
			break;

		case StackB :
			ptrB = max - 1;
			break;
		}
	}

	//스택의 용량을 반환 (A, B의 합계)
	public int capacity() {
		return max;
	}

	//스택에 쌓인 데이터 수 반환
	public int size(AB sw) {
		switch (sw) {
		case StackA:
			return ptrA;
		case StackB:
			return max - ptrB - 1;
		}
		return 0;
	}

	//스택이 비어 있는가?
	public boolean isEmpty(AB sw) {
		switch (sw) {
		case StackA:
			return ptrA <= 0; //비어있으면 true,

		case StackB:
			return ptrB >= max - 1;
		}
		return true; //스택 선택이 잘못된 경우 일반적으로 스택이 비어있다고 가정
	}

	// 스택이 가득 찼는가?
	public boolean isFull() {
		return ptrA >= ptrB + 1; //둘이 겹쳐질 때
	}

	// 스택 안의 데이터를 바닥 → 꼭대기의 차례로 나타냄
	public void dump(AB sw) {
		switch (sw) {
		case StackA:
			if (ptrA <= 0)
				System.out.println("스택이 비었습니다.");
			else {
				for (int i = 0; i < ptrA; i++)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		case StackB:
			if (ptrB >= max - 1)
				System.out.println("스택이 비었습니다.");
			else {
				for (int i = max - 1; i > ptrB; i--)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		}
	}
}
