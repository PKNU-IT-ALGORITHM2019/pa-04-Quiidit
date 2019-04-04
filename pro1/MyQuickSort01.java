package pro1;

public class MyQuickSort01 {
	int [] data = new int[100000];
	double start, end;
	double time;
	MyQuickSort01(int [] nums, int len) {
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
		for(j=s; j<e; j++) {
			if(data[j] < data[e]) {
				int tmp = data[++i];
				data[i] = data[j];
				data[j] = tmp;
			}
		}
		int tmp = data[e];
		data[e] = data[i+1];
		data[i+1] = tmp;
		return i+1;
	}

}