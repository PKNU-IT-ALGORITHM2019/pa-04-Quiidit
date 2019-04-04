package pro1;

public class MySelectionSort {
	int [] data = new int[100000];
	double start, end;
	double time;
	MySelectionSort(int [] nums, int len) {
		data = nums;
		start = System.currentTimeMillis();
		for(int i=len-1; i>0; i--) {
			int max=0;
			for(int j=0; j<i; j++) {
				if(data[max]<data[j+1]) 
					max = j+1;
			}
			int tmp = data[i];
			data[i] = data[max];
			data[max] = tmp;
		}
		end = System.currentTimeMillis();
		time = (end-start)/1000.0;
	}
}
