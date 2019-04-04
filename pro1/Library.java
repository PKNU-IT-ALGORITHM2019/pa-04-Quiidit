package pro1;

import java.util.Arrays;

public class Library {
	int [] data = new int[100000];
	double start, end;
	double time;
	Library(int [] nums, int len) {
		data = nums;


		start = System.currentTimeMillis();

		Arrays.sort(data, 0, len);
		
		end = System.currentTimeMillis();
		time = (end-start)/1000.0;
	}
}
