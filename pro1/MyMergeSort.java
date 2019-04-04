package pro1;

public class MyMergeSort {
	int [] data = new int[100000];
	int [] tmp = new int[100000];
	double start, end;
	double time;
	MyMergeSort(int [] nums, int len) {
		data = nums;
	
		start = System.currentTimeMillis();
		MSort(0,len-1);	
		end = System.currentTimeMillis();
		time = (end-start)/1000.0;
	}
	private void MSort(int s, int e) {
		if(s<e) {
			int m = (s+e)/2;
			MSort(s, m);
			MSort(m+1, e);
			merge(s, m, e);
		}
	}
	private void merge(int s, int m, int e) {


		int part1 = s;
		int part2 = m+1;
		int index = s;

		while(part1 <= m && part2 <= e) {
			if(data[part1] <data[part2]) {
				tmp[index] = data[part1];
				part1++;
			}
			else {
				tmp[index] = data[part2];
				part2++;
			}
			index++;
		}
		while(part1<=m)
			tmp[index++] = data[part1++];
		while(part2<=e)
			tmp[index++] = data[part2++];

		for(int k = s; k <= e; k++)
			data[k] = tmp[k];

	}
}