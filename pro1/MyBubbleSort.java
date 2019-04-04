package pro1;

public class MyBubbleSort {
	int [] data = new int[100000];
	double start, end;
	double time;
	MyBubbleSort(int [] nums, int len) {
		data = nums;
		start = System.currentTimeMillis();
		for(int i=len-1; i>0; i--) {
			for(int j=0; j<i; j++)
				if(data[j]>data[j+1]) {
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
		}

		end = System.currentTimeMillis();
		time = (end-start)/1000.0;
	}
}
