package pro1;

public class MyQuickSort02 {
	int [] data = new int[100000];
	double start, end;
	double time;
	MyQuickSort02(int [] nums, int len) {
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
		
		int pivot = PickPivot(s, (s+e)/2, e);

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
	private int PickPivot(int s, int m, int e) {
		int mid = (data[s] + data[m] + data[e]) - Math.max(Math.max(data[s], data[m]), data[e]) - Math.min(Math.min(data[s], data[m]), data[e]);
		if(mid == data[s])
			return s;
		else if(mid == data[m])
			return m;
		else 
			return e;
	}

}