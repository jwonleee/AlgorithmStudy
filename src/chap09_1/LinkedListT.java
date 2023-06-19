package chap09_1;

import java.util.Comparator;

import chap09_1.LinkedList.Node;

public class LinkedListT<E> {
	//노드
	class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node(E data, Node<E> next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
	
	//추가 노드
	private Node<E> head; //머리노드
	private Node<E> tail; //꼬리노드
	private Node<E> crnt; //선택노드
	
	public LinkedListT() {
		super();
		head = tail = crnt = null; //null로 초기화
	}
	
	//검색은 같음
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head = tail; //현재 스캔중인 노드
		//ptr.next == null이면 꼬리였는데 지금은 ptr.next == tail 이면 꼬리임
		while(ptr != null) { //마지막 노드 직전까지
			if(c.compare(obj, ptr.data) == 0) { //검색 성공
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		
		return null;
	}
	
	//머리에 노드 삽입
	public void addFirst(E obj) {
		Node<E> ptr = head;
		
		boolean empty = (tail == null); //비어있음
		head = crnt = new Node<E>(obj, ptr); //머리에 삽입
		if(empty) //꼬리에도 crnt 넣어줌
			tail = crnt;
	}
	
	
	//질문 -> 이거 할 때 tail은 알아서 마지막을 잡고 있는 건가?
	public void addLast(E obj) {
		if(head == null) { //데이터가 없으면
			addFirst(obj); //머리에 삽입
		} else {
			tail.next = crnt = new Node<E>(obj, null); //obj는 넣고, 그 뒤에 참조할 것은 없음
			tail = crnt;
		}
		
	}
	
	//머리 노드 삭제
	public void removeFirst() {
		if(head != null)
			head = crnt = head.next; //head를 그 다음으로 옮기고
			if(head == null) //그 값이 null이면
				tail = null; //tail에도 null
	}
	
	//질문 -> 꼬리 노드 삭제
	public void removeLast() {
		if(head != null) {
			if(head.next == null) //노드가 하나면
				removeFirst(); //첫번째 노드 삭제
			else {
				Node<E> ptr = head;
				Node<E> pre = head;
				
				while(ptr.next != null) { //ptr이 마지막 노드가 아니면
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null; //pre는 삭제 후의 꼬리
				tail = crnt = pre; //꼬리에 pre, crnt 넣어줌.. 근데 head에는?
			}
		}
	}
	
	//p 노드 삭제
	public void remove(Node p) {
		if(head != null) {
			if(p == head) { //p가 머리 노드이면
				removeFirst(); //머리 노드 삭제
			} else if(p == tail){ //p가 꼬리 노드이면
				removeLast(); //꼬리 노드 삭제
			
			} else { //그 외의 노드이면 
				Node<E> ptr = head;
				while(ptr.next != p) { //ptr 다음 값이 p가 아닐때까지
					ptr = ptr.next;
					if(ptr == null)
						return;
				}
				ptr.next = p.next; //ptr 다음값이 p이면, p의 다음값을 ptr 다음 값으로 만들고
				crnt = ptr; //ptr을 현재값으로 만듦
			}
			
		}
	}
	
	////////////////////////////////////아래에는 tail 사용 안 함//////////////////////////////////
	//선택 노드 삭제
		public void removeCurrentNode() {
			remove(crnt);
		}
		
		//모든 노드 삭제
		public void clear() {
			while(head != null) { //노드에 아무것도 없을 때까지
				removeFirst(); //머리 노드 삭제
			crnt = null; //리스트가 비어있으므로 crnt도 null로 업데이트
			}
		}
		
		//선택 노드를 하나 뒤쪽으로 이동
		public boolean next() {
			if(crnt == null || crnt.next == null) { //리스트가 비어있거나 선택 노드의 뒤쪽 노트가 없으면
				return false; //이동할 수 없음
			}
			crnt = crnt.next;
			return true;
		}
		
		//선택 노드를 표시
		public void printCurrentNode() {
			if(crnt == null)
				System.out.println("선택한 노드가 없습니다.");
			else
				System.out.println(crnt.data);
		}
		
		//모든 노드를 표시
		public void dump() {
			Node<E> ptr = head;
			
			while(ptr != null) {
				System.out.println(ptr.data);
				ptr = ptr.next;
			}
			//crnt 값을 업데이트 하지 않음, crnt는 메서드 실행 전 그대로임
		}
		
		//머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환
		public E retireve(int n) {
			Node<E> ptr = head;
			
			while(n >= 0 && ptr != null) { //n은 양수, 노드에 값이 있음
				if(n-- == 0) { //n번 반복(종료 조건은 n이 0이 될떄까지)
					crnt = ptr; //현재 값이 ptr이 된 곳에서
					return ptr.data; //data 리턴
				}
				ptr = ptr.next; //계속 넘기다가
			}
			
			return null;
		}
	
}
