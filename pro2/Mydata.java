package pro2;

import java.util.Comparator;

public class Mydata{
	String IP;
	int IP_p1;
	int IP_p2;
	int IP_p3;
	int IP_p4;
	
	String Time;
	int Year;
	int Month; 
	int Day;
	int Hours;
	int Minutes;
	int Seconds;
	
	
	String URL;
	String Status;
	
	Mydata(String I, String T, String U, String S){
		IP = I;
		Time = T;
		URL = U;
		Status = S;
		SpecifyIp(IP);
		SpecifyTime(Time);
		
	}
	private void SpecifyIp(String I) { //�ּҸ� ��ũ����¡ �Ѵ�
		String [] tokens = I.split("\\.");
		IP_p1 = Integer.parseInt(tokens[0]);
		IP_p2 = Integer.parseInt(tokens[1]);
		IP_p3 = Integer.parseInt(tokens[2]);
		IP_p4 = Integer.parseInt(tokens[3]);
		
	}
	private void SpecifyTime(String T) { //�ð��� ��ũ����¡ �Ѵ�
		String [] tokens = T.split("/");
		String [] tokens_detail = tokens[2].split(":");
		Year = Integer.parseInt(tokens_detail[0]);
		Month = CheckMonth(tokens[1]);
		Day = Integer.parseInt(tokens[0]);
		Hours = Integer.parseInt(tokens_detail[1]);
		Minutes = Integer.parseInt(tokens_detail[2]);
		Seconds = Integer.parseInt(tokens_detail[3]);		
	}
	
	private int CheckMonth(String M) {  //���� ���Ҽ� �ְ� ��ġȭ ��Ų��
		String [] tmp_month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		for(int i=0; i<12; i++) {
			if(M.equalsIgnoreCase(tmp_month[i]))
				return i;
		}
		System.out.println("��ȿ���� ���� ���� �ֽ��ϴ�.");
		return -1;
	}
	public static Comparator<Mydata> IpComparator = new Comparator<Mydata>() {
		@Override
		public int compare(Mydata data1, Mydata data2) {			
			if(data1.IP_p1 != data2.IP_p1)
				return data1.IP_p1 - data2.IP_p1;
			else {
				if(data1.IP_p2 != data2.IP_p2)
					return data1.IP_p2 - data2.IP_p2;
				else {
					if(data1.IP_p3 != data2.IP_p3)
						return data1.IP_p3 - data2.IP_p3;
					else {
						if(data1.IP_p4 != data2.IP_p4)
							return data1.IP_p4 - data2.IP_p4;
						else
							return HandleSortTime(data1, data2);  //IP�� �������� time������ ����
					}
				}
			}
		}
	};
	
	public static Comparator<Mydata> TimeComparator = new Comparator<Mydata>() {
		@Override
		public int compare(Mydata data1, Mydata data2) {
			return HandleSortTime(data1, data2);
		}

		
	};
	private static int HandleSortTime(Mydata data1, Mydata data2) {
		if(data1.Year != data2.Year)
			return data1.Year - data2.Year;
		else {
			if(data1.Month != data2.Month)
				return data1.Month - data2.Month;
			else {
				if(data1.Day != data2.Day)
					return data1.Day - data2.Day;
				else {
					if(data1.Hours != data2.Hours)
						return data1.Hours - data2.Hours;
					else {
						if(data1.Minutes != data2.Minutes)
							return data1.Minutes - data2.Minutes;
						else {
								return data1.Seconds - data2.Seconds;
						}
					}
				}
			}
		}			
	}
}
