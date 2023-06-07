package chap06_3;

public class QuickSort3 {

	//swap
	void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	//퀵 sort
    void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int pivot = a[(pl+pr)/2];

        do{
            while(a[pl] < pivot) pl++;
            while(a[pr] > pivot) pr--;
            if(pl <= pr){
            	swap(a, pl++, pr--);
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
	
}
