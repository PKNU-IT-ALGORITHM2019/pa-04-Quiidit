package pro1;

import java.util.Random;

public class MyQuickSort03 {
	int [] data = new int[1000000];
	double start, end;
	double time;
	Random ran = new Random();
	MyQuickSort03(int [] nums, int len) {
		data = nums;
		start = System.currentTimeMillis();
		QSort(0,len-1);
		end = System.currentTimeMillis();
		time = (end-start)/1000.0;
	}
	private void QSort(int s, int e) {
		if(s<e) {
			int p = participation(s, e);
			QSort(s, p-1);
			QSort(p+1, e);
		}
	}
	private int participation(int s, int e) {
		int i=s-1;
		int j;
		int r = (Math.abs(ran.nextInt())%(e-s));


		int pivot = data[s+r];

		int tmp = data[pivot];
		data[pivot] = data[e];
		data[e] = tmp;

		for(j=s; j<e; j++) {
			if(data[j] < data[e]) {
				tmp = data[++i];
				data[i] = data[j];
				data[j] = tmp;
			}
		}
		tmp = data[e];
		data[e] = data[i+1];
		data[i+1] = tmp;

		return i+1;
	}

}