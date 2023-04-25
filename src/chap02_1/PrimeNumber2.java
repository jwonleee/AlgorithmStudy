package chap02_1;

//1000이하의 소수를 구하라
public class PrimeNumber2 {
	public static void main(String[] args) {
		int counter = 0; //나눗셈의 횟수
		int ptr = 0; //찾은 소수의 개수, 소수 2가 저장되고 다음은 1이 나옴
		int[] prime = new int[500]; //길이가 500인 소수를 저장하는 배열
		
		prime[ptr++] = 2; //prime[0] = 2 저장, 2는 소수, 여기서 ptr = 1
		
		for(int n = 3; n <= 1000; n += 2) { //2는 소수이고, 3부터 1000까지 홀수(+2씩)만 확인
			int i;
			for(i = 1; i < ptr; i++) { //처음의 i < ptr이 1 < 1이므로 for문을 반복 수행x
				counter++; //나눗셈 횟수를 세고,
				if(n % prime[i] == 0) { //나누어 떨어지면 멈춤(소수x)
					break;
				}
			}
			if(ptr == i) { //처음의 ptr == i는 1==1이므로 prime[1] = 3을 넣음
				prime[ptr++] = n;
			}
		}
		
		for(int i = 0; i < ptr; i++) {
			System.out.println(prime[i]); //찾은 ptr개의 소수를 나타냄
		}
		
		System.out.println("나눗셈을 수행한 횟수: " + counter);
		
	}
	
}
