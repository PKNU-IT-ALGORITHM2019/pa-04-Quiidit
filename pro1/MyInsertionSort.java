package pro1;

public class MyInsertionSort {
	int [] data = new int[100000];
	double start, end;
	double time;
	MyInsertionSort(int [] nums, int len) {
		data = nums;


		start = System.currentTimeMillis();
		for(int i=1; i<len; i++) {
			for(int j=i; j>0; j--)
				if(data[j]<data[j-1]) {
					int tmp = data[j];
					data[j] = data[j-1];
					data[j-1] = tmp;
				}
		}

		end = System.currentTimeMillis();
		time = (end-start)/1000.0;
	}
}