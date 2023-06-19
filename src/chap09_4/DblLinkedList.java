package chap09_4;

import java.util.Comparator;

//원형 이중 연결 리스트 클래스
public class DblLinkedList<E> { //<E> 꼭 넣어줘야 함
	//노드
	class Node<E> {
		private E data;
		private Node<E> prev; //앞쪽 포인터
		private Node<E> next; //뒤쪽 포인터
		
		//생성자
		public Node() {
			super();
			data = null; //데이터 없음
			prev = next = this; //현재값 위치
		}

		//생성자
		public Node(E obj, Node<E> prev, Node<E> next) {
			super();
			this.data = obj;
			this.prev = prev;
			this.next = next;
		}
	} //end Node<E> class
	
	private Node<E> head; //머리 노드(더미 노드는 자기 자신을 가리킴)
	private Node<E> crnt; //선택 노드
	
	//생성자
	public DblLinkedList() {
		super();
		head = crnt = new Node<E>(); //더미 노드를 생성, prev.next = this
	}
	
	//리스트가 비어있는가?
	public boolean isEmpty() {
		return head.next == head; //true이면 비어있음, head 다음이 head
	}
	
	//검색 - 검색의 시작은 head.next
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head.next; //현재 스캔중인 노드, 처음에는 검색의 시작
		
		while(ptr != head) { //리스트가 있으면 반복
			if(c.compare(obj, ptr.data) == 0) { //비교했을 때 같으면
				crnt = ptr; //선택 노드는 ptr
				return ptr.data; //검색 성공
			}
			ptr = ptr.next; //같지 않으면 다음 노드로 선택
		}
		return null; //끝까지 찾아도 없으면 검색 실패
	}
	
	//선택 노드를 출력
	public void printCurrentNode() {
		if(isEmpty())
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data); //crnt = 선택 노드 출력
	}
	
	//모든 노드를 출력
	public void dump() {
		Node<E> ptr = head.next; //더미 노드의 다음 노드
		
		while(ptr != head) { //리스트가 있으면 + 한바퀴 돌아서 head로 돌아오면 스캔 끝
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	//모든 노드를 거꾸로 출력
	public void dumpReverse() {
		Node<E> ptr = head.prev; //더미 노드의 앞쪽 노드
		
		while(ptr != head) {
			System.out.println(ptr.data);
			ptr = ptr.prev;
		}
	}
	
	//선택 노드를 하나 뒤쪽으로 이동
	public boolean next() {
		if(isEmpty() || crnt.next == head) //비어있지 않고, 선택 노드의 뒤쪽 노드가 있을 때만 이동 가능
			return false; //이동할 수 없음
		else {
			crnt = crnt.next;
			return true;
		}
	}
	
	//선택 노드를 하나 앞쪽으로 이동
	public boolean prev() {
		if(isEmpty() || crnt.prev == head) //비어있지 않고, 선택 노드의 앞쪽 노드가 있을 때만 이동 가능
			return false; //이동할 수 없음
		else {
			crnt = crnt.prev;
			return true;
		}
	}
	
	//선택 노드의 바로 뒤에 노드를 삽입
	public void add(E obj) {
		//새로운 노드 생성
		//생성자는 Node(E obj, Node<E> prev, Node<E> next), 객체, 앞쪽노드, 뒤쪽노드
		Node<E> node = new Node<E>(obj, crnt, crnt.next);
		
		//들어갈 노드의 앞쪽 포인터와 뒤쪽 포인터가 전부 들어갈 노드를 가리키도록 업데이트
		crnt.next = crnt.next.prev = node; //crnt = B 였고, crnt.next = node 로 업데이트 / crnt.next = C 였고, crnt.next.prev = node 로 업데이트
		crnt = node; //현재 선택 노드는 삽입한 노드
		
	}
	
	//머리에 노드 삽입
	public void addFirst(E obj) {
		crnt = head; //더미 노드 head의 바로 뒤에 삽입하므로 선택 crnt가 가리키는 곳을 head로 업데이트
		add(obj); //add() 메서드 호출
	}
	
	//꼬리에 노드 삽입
	public void addLast(E obj) {
		crnt = head.prev; //더미 노드 head의 바로 앞에 삽입하므로 선택 crnt가 가리키는 곳을 head.prev로 업데이트
		add(obj);
	}
	
	//선택 노드를 삭제
	public void removeCurrentNode() {
		if(!isEmpty()) { //리스트가 비어있지 않으면
			crnt.prev.next = crnt.next;
			crnt.next.prev = crnt.prev;
			crnt = crnt.next; //선택 노드가 삭제한 앞쪽 노드 A를 가리키도록 업데이트
			if(crnt == head) crnt = head.next;
		}
	}
	
	//노드 p를 삭제
	public void remove(Node p) {
		Node<E> ptr = head.next;
		
		while(ptr != head) {
			if(ptr == p) { //p를 찾음
				crnt = p; //p를 선택 노드로 만듦
				removeCurrentNode(); //선택 노드 삭제
				break;
			}
			ptr = ptr.next; //p를 못찾으면 반복
		}
	}
	
	//머리 노드를 삭제
	public void removeFirst() {
		crnt = head.next; //머리 노드 head.next를 crnt로 만들어서
		removeCurrentNode(); //삭제
	}
	
	//꼬리 노드를 삭제
	public void removeLast() {
		crnt = head.prev;
		removeCurrentNode();
	}
	
	//전체 삭제
	public void clear() {
		while(!isEmpty()) { //텅 빌때까지
			removeFirst(); //머리 노드를 삭제
		}
	}
	
}
