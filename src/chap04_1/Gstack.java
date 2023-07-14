package chap04_1;

import java.util.EmptyStackException;

public class Gstack<E> {

	private int max; //스택 용량
	private int ptr; //스택 포인터
	private E[] stk; //스택 본체
	
	//실행 시 예외: stack이 비어있음
	public static class EmptyIntStackException extends RuntimeException { //실행예외: RuntimeException ▶ 개발자가 직접 예외코드 처리
		public EmptyIntStackException() {}
	}
	
	//실행 시 예외: stack이 가득참
	public static class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	//생성자
	public Gstack(int capacity) {
		max = capacity;
		ptr = 0;
		try {
			stk = (E[])new Object[max]; //형변환 필요!!
		} catch (Exception e) {
			max = 0; //생성할 수 없음
		}
	}
	
	//push
	public E push(E x) throws OverflowIntStackException {
		if(ptr >= max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	
	//pop
	public E pop(E x) throws EmptyIntStackException {
		if(ptr <= 0)
			throw new EmptyStackException();
		return stk[--ptr]; //ptr의 값을 감소시키고, stk[ptr]에 저장되어 있는 값을 반환
	}
	
	//peak
	public E peak() throws OverflowIntStackException {
		if(ptr <= 0)
			throw new EmptyStackException();
		return stk[ptr - 1];
	}
	
	//찾기
	public int indexOf(int x) {
		for(int i = ptr-1; i >= 0; i--) {
			if(stk[i].equals(x)) //E형 타입이니까 equals로 비교
				return i; //검색 성공
		}
		return -1; //검색 실패
	}
	
	public void clear() {
		ptr = 0;
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return ptr;
	}
	
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	public boolean isFull() {
		return ptr >= max;
	}
	
	public void dump() {
		if(ptr <= 0) {
			System.out.println("스택이 비어있습니다.");
		} else {
			for(int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			} System.out.println();
		}
		
	}
}
