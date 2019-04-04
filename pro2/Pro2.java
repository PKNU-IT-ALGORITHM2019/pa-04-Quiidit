package pro2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Pro2 {
	public int capacity = 100;
	public int size = 0;
	public Mydata[] data = new Mydata[capacity];
	public int SortType; //현재의 소트 타입이 어떤것으로 지정되어 있는지 알려준다
	private Scanner kb = new Scanner(System.in);

	public void processCommand() {
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("read")) {
				String FileName = kb.next();
				ReadText(FileName);
			}
			else if(command.equals("sort")){
				String Category = kb.next();
				if(Category.equals("-t")){
					SortType = 0;
					Arrays.sort(data, Mydata.TimeComparator);
				}
				else if(Category.equals("-ip")){
					SortType = 1;
					Arrays.sort(data, Mydata.IpComparator);
				}
			}
			else if(command.equals("print")){
				if(SortType == 0) {
					for(int i=0; i<size; i++) {
						System.out.println(data[i].Time);
						System.out.println("     IP : " + data[i].IP);
						System.out.println("     URL : " + data[i].URL);
						System.out.println("     Status : " + data[i].Status);
					}
				}
				else {
					for(int i=0; i<size; i++) {
						System.out.println(data[i].IP);
						System.out.println("     Time : " + data[i].Time);
						System.out.println("     URL : " + data[i].URL);
						System.out.println("     Status : " + data[i].Status);
					}
				}
			}
			else if(command.equals("exit")){
				break;
			}
		}
		kb.close();
	}
	private void ReadText(String FileName) {
		try {
			Scanner in = new Scanner(new File(FileName));
			String sentence;
			sentence = in.nextLine();
			while(in.hasNext()) {
				sentence = in.nextLine();
				tokenize(sentence);		
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("No Files");
			System.exit(0);
		}
	}
	private void tokenize(String sentence) {
		String [] tokens = sentence.split(",");
		addWords(tokens[0], tokens[1].substring(1), tokens[2], tokens[3]);  //달에 [를 빼주고 시작

	}

	private void addWords(String Addrress, String Time, String Url, String Status) {
		if(size>= capacity)
			reallocate();
		data[size++] = new Mydata(Addrress, Time, Url, Status);		
	}
	private void reallocate() {
		capacity += 1;
		Mydata[] tmp = new Mydata[capacity];
		System.arraycopy(data, 0, tmp, 0, data.length);
		data = tmp;
	}

	public static void main(String[] args) {
		Pro2 app = new Pro2();
		app.processCommand();
	}

}
