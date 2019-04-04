package pro1;
import java.util.Random;
public class Pro1 {
	Random ran = new Random();
	public double [][] show_time = new double[10][10];
	private void Process_command() {
		Make_Rdm0();
		Make_Rvs0();
		Make_Rdm1();
		Make_Rvs1();
		Make_Rdm2();
		Make_Rvs2();
		show();
	}
	private void Make_Rvs2() {
		int n = 5;
		int len = 100000;
		int [] Rvs = new int[100000];
		for(int i=0; i<len; i++) {
			Rvs[i] = len-i; 
		}
		CheckSortTime(n, Rvs, len);
	}

	private void Make_Rdm2() { //랜덤 100000개 만들기
		int n = 4;
		int len = 100000;
		int [] Rdm = new int[100000];
		for(int k=0; k<10; k++) {
			for(int i=0; i<len; i++) {
				Rdm[i] = (Math.abs(ran.nextInt()) % 100001);
			}
			CheckSortTime(n, Rdm, len);
		}
		DivideResult(n);

	}

	private void Make_Rvs1() {
		int n = 3;
		int len = 10000;
		int [] Rvs = new int[100000];
		for(int i=0; i<len; i++) {
			Rvs[i] = len-i; 
		}
		CheckSortTime(n, Rvs, len);
	}

	private void Make_Rdm1() { //랜덤 10000개 만들기
		int n = 2;
		int len = 10000;
		int [] Rdm = new int[100000];
		for(int k=0; k<10; k++) {
			for(int i=0; i<len; i++) {
				Rdm[i] = (Math.abs(ran.nextInt()) % 10001);
			}
			CheckSortTime(n, Rdm, len);
		}
		DivideResult(n);


	}
	private void Make_Rvs0() {
		int n = 1;
		int len = 1000;
		int [] Rvs = new int[100000];
		for(int i=0; i<len; i++) {
			Rvs[i] = len-i; 
		}
		CheckSortTime(n, Rvs, len);
	}
	private void Make_Rdm0() { //랜덤 1000개 만들기
		int n = 0;
		int len = 1000;
		int [] Rdm = new int[100000];
		for(int k=0; k<10; k++) {
			for(int i=0; i<len; i++) {
				Rdm[i] = (Math.abs(ran.nextInt()) % 1001);
			}
			CheckSortTime(n, Rdm, len);
		}
		DivideResult(n);

	}
	private void DivideResult(int n) {
		for(int i=0; i<7; i++) {
			show_time[n][i] = show_time[n][i]/10;
		}

	}
	private void CheckSortTime(int n, int[] val, int len) {

		show_time[n][0] += CheckBubbleSort(val, len); 
		show_time[n][1] += CheckSelectionSort(val, len);
		show_time[n][2] += CheckInsertionSort(val, len);
		show_time[n][3] += CheckMergeSort(val, len);
		show_time[n][4] += CheckQuickSort01(val, len);
		show_time[n][5] += CheckQuickSort02(val, len);
		show_time[n][6] += CheckQuickSort03(val, len);
		show_time[n][7] += CheckMyHeapSort(val, len);
		show_time[n][8] += CheckLibrary(val, len);

		

	}

	private int[] StoreData(int[] val, int len) {
		int [] data = new int[100000];
		for(int i=0; i<len; i++)
			data[i] = val[i];
		return data;
	}
	private void show() {
		System.out.println("           Random1000   Reverse1000   Random10000  Reverse10000  Random100000 Reverse100000");
		System.out.print("Bubble         ");
		for(int i=0; i<6; i++)
			System.out.print(String.format("%.4f",show_time[i][0]) + "        ");
		System.out.println();
		System.out.print("Selection      ");
		for(int i=0; i<6; i++)
			System.out.print(String.format("%.4f",show_time[i][1]) + "        ");
		System.out.println();
		System.out.print("Insertion      ");
		for(int i=0; i<6; i++)
			System.out.print(String.format("%.4f",show_time[i][2]) + "        ");
		System.out.println();
		System.out.print("Merge          ");
		for(int i=0; i<6; i++)
			System.out.print(String.format("%.4f",show_time[i][3]) + "        ");
		System.out.println();
		System.out.print("Quick1         ");
		for(int i=0; i<6; i++)
			System.out.print(String.format("%.4f",show_time[i][4]) + "        ");
		System.out.println();
		System.out.print("Quick2         ");
		for(int i=0; i<6; i++)
			System.out.print(String.format("%.4f",show_time[i][5]) + "        ");
		System.out.println();
		System.out.print("Quick3         ");
		for(int i=0; i<6; i++)
			System.out.print(String.format("%.4f",show_time[i][6]) + "        ");
		System.out.println();
		System.out.print("Heap         ");
		for(int i=0; i<6; i++)
			System.out.print(String.format("%.4f",show_time[i][7]) + "        ");
		System.out.println();
		System.out.print("Library         ");
		for(int i=0; i<6; i++)
			System.out.print(String.format("%.4f",show_time[i][8]) + "        ");
		System.out.println();


	}
	private double CheckLibrary(int[] data, int len) {
		int [] val = new int[100000];
		val = StoreData(data, len);
		Library s = new Library(val, len);
		return s.time;
	}
	private double CheckMyHeapSort(int[] data, int len) {
		int [] val = new int[100000];
		val = StoreData(data, len);
		MyHeapSort s = new MyHeapSort(val, len);
		return s.time;
	}
	private double CheckQuickSort03(int[] data, int len) {
		int [] val = new int[100000];
		val = StoreData(data, len);
		MyQuickSort03 s = new MyQuickSort03(val, len);
		return s.time;
	}
	private double CheckQuickSort02(int[] data, int len) {
		int [] val = new int[100000];
		val = StoreData(data, len);
		MyQuickSort02 s = new MyQuickSort02(val, len);
		return s.time;
	}
	private double CheckQuickSort01(int[] data, int len) {
		int [] val = new int[100000];
		val = StoreData(data, len);
		MyQuickSort01 s = new MyQuickSort01(val, len);
		return s.time;
	}
	private double CheckMergeSort(int[] data, int len) {
		int [] val = new int[100000];
		val = StoreData(data, len);
		MyMergeSort s = new MyMergeSort(val, len);
		return s.time;
	}
	private double CheckInsertionSort(int[] data, int len) {
		int [] val = new int[100000];
		val = StoreData(data, len);
		MyInsertionSort s = new MyInsertionSort(val, len);
		return s.time;
	}
	private double CheckSelectionSort(int[] data, int len) {
		int [] val = new int[100000];
		val = StoreData(data, len);
		MySelectionSort s = new MySelectionSort(val, len);
		return s.time;
	}

	private double CheckBubbleSort(int[] data, int len) {
		int [] val = new int[100000];
		val = StoreData(data, len);
		MyBubbleSort s = new MyBubbleSort(val, len);
		return s.time;
	}
	public static void main(String[] args) {
		Pro1 app = new Pro1();
		app.Process_command();
	}
}