package pro1;

public class MyHeapSort {
	int [] data = new int[100000];
	double start, end;
	double time;
	int n;
	int left;
	int right;
	int largest;

	MyHeapSort(int [] nums, int len) {
		data = nums;
		n = len-1;
		start = System.currentTimeMillis();

		buildheap(data);

		for(int i=n;i>0;i--){
			exchange(0, i);
			n=n-1;
			maxheap(data, 0);
		}
		end = System.currentTimeMillis();
		time = (end-start)/1000.0;
	}
	private void buildheap(int[] arr) {
		for(int i=n/2;i>=0;i--){
			maxheap(arr,i);
		}
	}
	private void maxheap(int[] arr, int i) {
		left=2*i;
		right=2*i+1;
		if(left <= n && arr[left] > arr[i])
			largest=left;
		else
			largest=i;

		if(right <= n && arr[right] > arr[largest])
			largest=right;
		if(largest!=i){
			exchange(i,largest);
			maxheap(arr, largest);
		}

	}
	private void exchange(int i, int j) {
		int tmp=data[i];
		data[i]=data[j];
		data[j]=tmp; 		
	}
}
