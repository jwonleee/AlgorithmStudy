package chap09_3;

import java.util.Comparator;

import chap09_3.CircleLinkedList.Node;

//연결 리스트 클래스 (배열 커서 버전)
public class CircleLinkedListT<E> {
	//노드
	class Node<E> { //각 요소를 표현하며 배열 n에 Node 객체를 저장하여 연결리스트 구성
		private E data; //데이터
		private int next; //다음 노드를 가키리는 포인터
		private int dnext; //추가, free 리스트의 뒤쪽 포인터

		//data와 next 설정
		void set(E data, int next) {
			this.data = data;
			this.next = next;
		}
	} //end Node<E> class

	//필드 = 멤버변수 = 전역변수
	private Node<E>[] n; //리스트 본체
	private int size; //리스트의 용량 (가장 큰 데이터 수)
	private int max; //추가, 배열에서 꼬리 인덱스, 현재 사용중인 마지막 인덱스
	private int head; //머리 노드
	private int tail; //꼬리 노드
	private int crnt; //선택 노드

	private int deleted; //추가, free 리스트의 머리 노드
	private static final int NULL = -1; //다음 노드 없음 / 리스트가 가득 참 

	//생성자
	public CircleLinkedListT(int capacity) {
		head = tail = crnt = max = deleted = NULL;
		try {
			n = new Node[capacity];
			for (int i = 0; i < capacity; i++) { //capacity 사이즈 만큼의 리스트 본체 생성하고
				n[i] = new Node<E>(); //그 안에 노드 하나씩 생성
			}
			size = capacity;
		} catch (OutOfMemoryError e) { //배열 생성에 실패
			size = 0;
		}
	}

	//다음에 삽입하는 record의 인덱스를 구함
	private int getInsertIndex() {
		if(deleted == NULL) { //deleted에서 삭제할 노드가 없음 = 삭제 리스트가 비어있거나 모든 노드가 사용중인 경우
			if(max < size) //배열이 마지막 사용 인덱스보다 크다는 것은 아직 널널하다는 뜻
				return ++max; //새 record를 사용
			else
				return NULL; //용량 넘침(over)
		} else {
			int rec = deleted;  //free 리스트에서
			deleted = n[rec].dnext; //머리 rec을 꺼냄
			return rec;
		}
	}

	//삭제할 노드의 인덱스를 free 리스트에 등록
	private void deleteIndex(int idx) {
		if(deleted == NULL) { //deletd가 가리키는 노드 없음
			deleted = idx; //idx를 free 리스트의
			n[idx].dnext = NULL; //머리에 등록 = n[idx]의 다음 노드를 가리키는 포인터가 null 값을 가짐
		} else {
			int rec = deleted; //idx를 free리스트의
			deleted = idx; //머리에 삽입
			n[rec].dnext = rec;
			//기존에 deleted가 가리키는 것을 rec에 넣고, idx를 deleted에 다음 노드는 rec를 가리킴
		}
	}

	//노드를 검색
	public E search(E obj, Comparator<? super E> c) {
		if(head != NULL) {			
			int ptr = head; //현재 스캔중인 노드

			do {
				if(c.compare(obj, n[ptr].data) == 0) {
					crnt = ptr;
					return n[ptr].data; //검색 성공
				}
			} while (ptr != head);
		}
		return null; //검색 실패
	}

	//머리에 노드를 삽입
	public void addFirst(E obj) {
		if (head == NULL) {
		int rec = getInsertIndex();
		if(rec != NULL) {
			head = tail = crnt = rec; //인덱스 rec인 record에 삽입
			n[head].set(obj, rec);
			}
		} else {
			int ptr = head; // 삽입 전의 머리 노드
			int rec = getInsertIndex();
			if (rec != NULL) {
				head = crnt = rec; // 인덱스 rec인 record에 삽입
				n[head].set(obj, ptr);
				n[tail].next = head;
			}
		}
	}

	// 꼬리에 노드를 삽입
	public void addLast(E o) {
		if (head == NULL) // 리스트가 비어있으면
			addFirst(o); // 머리에 삽입
		else {
			int rec = getInsertIndex();
			if (rec != NULL) {
				n[tail].next = crnt = rec;
				n[rec].set(o, head);
				tail = rec;
			}
		}
	}
	
	// 머리 노드를 삭제
	public void removeFirst() {
		if (head != NULL) { // 리스트가 비어 있지 않으면
			if (head == tail) {
				deleteIndex(head);
				head = tail = crnt = NULL;
			} else {
				int ptr = n[head].next;
				deleteIndex(head);
				head = crnt = ptr;
				n[tail].next = head;
			}
		}
	}
	
	// 꼬리 노드를 삭제
	public void removeLast() {
		if (head != NULL) {
			if (head == tail) // 노드가 하나만 있으면
				removeFirst(); // 머리노드를 삭제
			else {
				int ptr = head; // 스캔중인 노드
				int pre = head; // 스캔중인 노드의 앞쪽노드

				while (n[ptr].next != head) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = head; // pre는 삭제 뒤의 꼬리노드
				deleteIndex(ptr);
				tail = crnt = pre;
			}
		}
	}
	
	// record p를 삭제
	public void remove(int p) {
		if (head != NULL) {
			if (p == head) // p가 머리노드면
				removeFirst(); // 머리노드를 삭제
			else if (p == tail) // p가 꼬리노드면
				removeLast(); // 꼬리노드를 삭제
			else {
				int ptr = head;

				while (n[ptr].next != p) {
					ptr = n[ptr].next;
					if (ptr == head)
						return; // p가 리스트에 없습니다.
				}
				n[ptr].next = n[p].next;
				deleteIndex(p);
				crnt = ptr;
			}
		}
	}
	
	// 선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}

	// 모든 노드를 삭제
	public void clear() {
		while (head != NULL) // 비게 될 때까지
			removeFirst(); // 머리노드를 삭제
		crnt = NULL;
	}

	// 선택 노드를 하나 뒤쪽으로 진행
	public boolean next() {
		if (crnt == NULL || n[crnt].next == head)
			return false; // 나아갈 수 없음
		crnt = n[crnt].next;
		return true;
	}

	// 선택 노드를 출력
	public void printCurrentNode() {
		if (crnt == NULL)
			System.out.println("선택 노드가 없습니다.");
		else
			System.out.println(n[crnt].data.toString());
	}

	// 모든 노드를 출력
	public void dump() {
		if (head != NULL) {
			int ptr = head;

			do {
				System.out.println(n[ptr].data.toString());
				ptr = n[ptr].next;
			} while (ptr != head);
		}
	}

	// comparator c에 의해 서로 같다고 보는 노드를 모두 삭제
	public void purge(Comparator<? super E> c) {
		if (head == NULL)
			return;
		int ptr = head;

		do {
			int count = 0;
			int ptr2 = ptr;
			int pre = ptr;

			while (n[pre].next != head) {
				ptr2 = n[pre].next;
				if (c.compare(n[ptr].data, n[ptr2].data) == 0) {
					remove(ptr2);
					count++;
				} else
					pre = ptr2;
			}
			if (count == 0)
				ptr = n[ptr].next;
			else {
				int temp = n[ptr].next;
				remove(ptr);
				ptr = temp;
			}
		} while (n[ptr].next != head);
		crnt = head;
	}

	// 머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환
	public E retrieve(int n) {
		if (head != NULL) {
			int ptr = head;

			while (n >= 0) {
				if (n-- == 0) {
					crnt = ptr;
					return this.n[ptr].data; // 검색성공
				}
				ptr = this.n[ptr].next; // 뒤쪽노드에 주목
				if (ptr == head)
					break;
			}
		}
		return (null);
	}
	
	

}
