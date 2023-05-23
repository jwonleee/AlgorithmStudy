package chap05_2;

public class RecurX1 {

	//재귀 제거
	static void recur(int n) {
		//정수 크기를 가진 stack 생성
		IntStack s = new IntStack(n);
		
		while(true) { //그림에서 가운데의 네모 숫자를 넣기 위함
			if(n > 0) { 
				s.push(n); //n의 값을 푸시
				n = n-1;
				continue;
			}
			if(s.isEmpty() != true) { //n < 0
				n = s.pop();
				System.out.println(n); //n의 값을 꺼내옴
				n = n-2; //꼬리 재귀 제거
				continue;
			}
			break;
		}
	}
}
