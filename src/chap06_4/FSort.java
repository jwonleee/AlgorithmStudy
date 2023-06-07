package chap06_4;

public class FSort {

	
	static void counting(int[] data, int[] cnt) {
		for(int i = 0; i < 10; i++) {
			cnt[ data[i] ]++; //data[i]의 값을 cnt에 인덱스에 맞춰서 count
		}		
	}
	
	static void fSort(int[] cnt) {	
		for(int i = 0; i < cnt.length; i++) {
			if(cnt[i] != 0) { //cnt의 값이 0이 아니면
				int j = 0; //몇번 반복할지를 나타내는 변수
				while(j < cnt[i]) { //인덱스니까 앞부분도 같은 숫자를 적으려면 적어야 함
					System.out.print(i + " "); //인덱스 값 적기
					j++;
				}
			}
		}
	}
	
	static void guide() {
		System.out.println("  인덱스 : 0 1 2 3 4 5 6 7 8 9");
		System.out.print("  데이터 : ");
	}
	
	public static void main(String[] args) {
		int[] data = {3, 5, 1, 4, 1, 2, 2, 3, 2, 7};
		int[] cnt = new int[10];
		
		System.out.println("도수 정렬 전 값");
		guide();
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		
		System.out.println("\n\n정렬 전 cnt 값");
		guide();
		for(int i = 0; i < cnt.length; i++) {
			System.out.print(cnt[i] + " ");
		}
		
		counting(data, cnt);
		
		System.out.println("\n\n정렬 후 cnt 값");
		guide();
		for(int i = 0; i < cnt.length; i++) {
			System.out.print(cnt[i] + " ");
		}
		
		System.out.println("\n\n도수 정렬 후 값");
		guide();
		fSort(cnt);
	}
	
}
