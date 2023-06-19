package chap09_3;

import java.util.Comparator;

// 연결 리스트 클래스 (원형 리스트 버전)
public class CircleLinkedList<E> {

	//노드
	class Node<E> {
		private E data;
		private Node<E> next; //뒤쪽 포인터
		
		//생성자
		public Node(E data) {
			super();
			this.data = data;
			this.next = this;  //꼬리 노드의 다음 포인터가 머리 노드를 가리키게 하기 위해?
		}

		//생성자
		public Node(E data, Node<E> next) {
			super();
			this.data = data;
			this.next = next;
		}
	} //end Node<E> class
	
	//필드
	private Node<E> head;
	private Node<E> tail; //꼬리 노드 추가
	private Node<E> crnt; //선택 노드
	
	//생성자 - null로 초기화
	public CircleLinkedList() {
		head = tail = crnt = null;
	}
	
	//검색
	public E search(E obj, Comparator<? super E> c) {
		if(head != null) {			
			Node<E> ptr = head; //현재 스캔중인 노드
			
			do {
				if(c.compare(obj, ptr.data) == 0) {
					crnt = ptr;
					return ptr.data;
				}
			} while (ptr != head);
		}
		return null; //검색 실패
	}
	
	//머리에 노드를 삽입
	public void addFirst(E obj) {
		if(head == null)
			head = tail = crnt = new Node<E>(obj);
		else {
			Node<E> ptr = head;
			head = crnt = new Node<E>(obj, ptr);
			tail.next = head;
		}
	}
	
	//꼬리에 노드를 삽입
	public void addLast(E obj) {
		if(head == null) { //리스트가 비어있으면
			addFirst(obj); //머리에 삽입
		} else {
			Node<E> ptr = tail; //꼬리 노드를 찾기 위해 머리노드를 가리키도록 초기화한 ptr을
			ptr.next = crnt = tail = new Node<E>(obj, head); //tail의 다음 노드는 head
		}
	}
	
	//머리 노드를 삭제
	public void removeFirst() {
		if(head != null) {//리스트가 비어있지 않으면
			head = tail = crnt = null;
		} else { //리스트가 비어있으면
			Node<E> ptr = head.next;
			head = crnt = ptr;
			tail.next = head;
		}
	}
	
	//꼬리 노드를 삭제
	public void removeLast() {
		if(head != null) { //리스트가 비어있지 않으면
			if(head.next == tail) //노드가 하나면
				removeFirst(); //머리 노드 삭제
			else {
				Node<E> ptr = head; //현재 스캔 중인 노드
				Node<E> pre = head; //현재 스캔 중인 노드의 앞쪽 노드
				
				while(ptr.next != head) { //현재 노드 다음이 head가 아니면
					pre = ptr;
					ptr = ptr.next;
				} //while 종료시 ptr은 꼬리 노드, pre는 꼬리로부터 두번째 노드
				pre.next = head; //pre는 삭제 후의 꼬리 노드
				tail = crnt = pre; //crnt는 삭제 후의 꼬리노드 pre
			}
		}
	}
	
	//노드 p를 삭제
	public void remove(Node p) {
		if(head != null) { //리스트가 비어있지 않으면
			if(p == head) { //p가 머리 노드이면
				removeFirst(); //머리 노드 삭제
			} else if(p == tail){
				removeLast();
			} else {
				//p의 앞쪽 노드 찾기
				Node<E> ptr = head; //현재 스캔 중인 노드
				
				while(ptr.next != p) { //ptr의 뒤쪽 포인터가 p와 같을 때까지 반복
					ptr = ptr.next;
					if(ptr == head) return; //p가 리스트에 없으면 메서드 종료
				}
				ptr.next = p.next; //기존의 p다음 노드를 ptr의 다음 노드로 만들어주고, 참조되지 않은 노드의 메모리는 자동으로 해제
				crnt = ptr; //현재 노드를 삭제한 노드의 앞 노드로 업데이트
			}
		}
	}
	
	//선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	//모든 노드를 삭제
	public void clear() {
		while(head != null) { //노드에 아무것도 없을 때까지
			removeFirst(); //머리 노드 삭제
		crnt = null; //리스트가 비어있으므로 crnt도 null로 업데이트
		}
	}
	
	//선택 노드를 하나 뒤쪽을 이동
	public boolean next() {
		if(crnt == null || crnt.next == head) { //리스트가 비어있거나 선택 노드의 뒤쪽 노트가 없으면
			return false; //이동할 수 없음
		}
		crnt = crnt.next;
		return true;
	}
	
	//선택 노드를 출력
	public void printCurrentNode() {
		if(crnt == null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data.toString());
	}
	
	//모든 노드를 출력
	public void dump() {
		if(head != null) {
			Node<E> ptr = head;
			do {
				System.out.println(ptr.data.toString());
				ptr = ptr.next;
			} while (ptr != head);
		}
		//crnt 값을 업데이트 하지 않음, crnt는 메서드 실행 전 그대로임
	}
	
	//comparator c에 의해 서로 같다고 보는 노드를 모두 삭제
	public void purge(Comparator<? super E> c) { //비교할 값 = no 또는 name
		if(head == null)
			return;
		
		Node<E> ptr = head;
		
		do { //마지막 노드 직전까지 반복
			int count = 0; 
			Node<E> ptr2 = ptr; //비교할 ptr값인데 현재 노드로 초기화
			Node<E> pre = ptr; //현재 노드의 앞쪽 노드
			
			while(pre.next != head) { //현재 노드값(crnt, ptr)이 마지막까지 반복
				ptr2 = pre.next; //ptr하고, pre.next는 같은 값인데 변수명을 다르게
				if(c.compare(ptr.data, ptr2.data) == 0) {
					pre.next = ptr2.next;
					count++; //지웠다고, 카운트 셈
				} else { pre = ptr2; }
			}
			
			if(count == 0) { //같은 노드가 없으면
				ptr = ptr.next;
			} else { //같은 노드가 있었으면
				Node<E> temp = ptr;
				remove(ptr);
				ptr = temp.next;
			}
			
		} while(ptr.next != head);
		crnt = head;
	}
	
	// 머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환
	public E retireve(int n) {
		Node<E> ptr = head;
		while (n >= 0) {
			if (n-- == 0) { //n번 반복(종료 조건은 n이 0이 될떄까지)
				crnt = ptr; //현재 값이 ptr이 된 곳에서
				return (ptr.data); // 검색성공
			}
			ptr = ptr.next; // 다음 노드에 선택
			if (ptr == head)
				break;
		}
		return null;
	}
	
	
	
}
