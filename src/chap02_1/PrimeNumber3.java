package chap02_1;

//1000이하의 소수를 구하라
public class PrimeNumber3 {
	public static void main(String[] args) {
		int counter = 0; //나눗셈의 횟수
		int ptr = 0; //찾은 소수의 개수, 소수 2가 저장되고 다음은 1이 나옴
		int[] prime = new int[500]; //길이가 500인 소수를 저장하는 배열
		
		prime[ptr++] = 2; //prime[0] = 2 저장, 2는 소수, 여기서 ptr = 1
		prime[ptr++] = 3; //prime[1] = 3 저장, 3은 소수
		
		for(int n = 5; n <= 1000; n += 2) { //2, 3은 소수이고, 5부터 1000까지 홀수(+2씩)만 확인
			boolean flag = false; //기본값 false
			
			for(int i = 1; prime[i]*prime[i] <= n; i++) { //prime[i]가 n의 제곱근 이하인가? 확인하기 위해
				
				counter += 2; //위의 곱하기랑, 밑의 나누기 한번에 카운트
				if(n % prime[i] == 0) { //나누어 떨어지면 멈춤(소수x)
					flag = true; //나누어떨어지면 flag는 true가 되고, 멈춤
					break; //더 이상의 반복문은 필요x
				}
			} //제곱근 반복문 끝
			if(!flag) { //마지막까지 나누어떨어지지 않으면
				prime[ptr++] = n; //소수라고 배열에 저장
				counter++; //한번만 세기
			}
		}
		
		for(int i = 0; i < ptr; i++) {
			System.out.println(prime[i]); //찾은 ptr개의 소수를 나타냄
		}
		
		System.out.println("나눗셈을 수행한 횟수: " + counter);
		
	}
	
}
