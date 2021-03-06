package myutil;

import java.util.Calendar;

public class Jumin2 {
	
	private String jumin_no;

	
	
	
	public String getJumin_no() {
		return jumin_no;
	}

	
	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
		
	}
	//			  01234567890123 <- index
	//jumin_no = "801212-1234560"
	
	//출생년도
	public int getYear() {
		
		//2자리 년도 추출
		String str_year = jumin_no.substring(0,2);
		int year = Integer.parseInt(str_year);
		
		//성별정보 구함
		char gender = jumin_no.charAt(7);
		if(gender=='1' || gender=='2' || gender=='5' || gender=='6')
			year += 1900;
		else if (gender=='3' || gender=='4' || gender=='7' || gender=='8')
			year+=2000;
		else
			year+=1800; 
	
		return year;
	}
	
	//나이
	public int getAge() {
		
		Calendar c = Calendar.getInstance();
		
		int current_year = c.get(Calendar.YEAR);
		
		//나이 = 현재년도 - 출생년도
		//클래스는 자기가 자기 메소드를 호출해 쓸 수 있다.
		int age = current_year - this.getYear()+1;
	
		return age;
	}
	
	//띠
	public String getTti() {
		
		
		int my_Tti = this.getYear()%12; //12나머지 연산이기때문에 0 ~ 11사이
		
		String [] tti_array = { "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양"};
		
		return tti_array[my_Tti];
		
	}
	/*
					 남자				 여자
				내국인	외국인		내국인	외국인
		1900	  1			5		  2			6
		2000	  3			7		  4			8
		1800	  9					  0
	
	*/
	
	
	
	//성별
	public String getGender() {
		
		String res = "여자";
		
		char gender = jumin_no.charAt(7);
		if((gender-'0')%2!=0) {
			return res = "남자";
		}
		return res;
	}
	
	//지역
	public String getLocal() {
		
		String str_local = jumin_no.substring(8,10);
		int local = Integer.parseInt(str_local);
		
		if(local>=0 &&local<=8)			return "서울특별시";
		else if(local>=9 && local<=12)	return "부산광역시";
		else if(local>=13 && local<=15)	return "인천광역시";
		else if(local>=16 && local<=25)	return "경기도";
		else if(local>=26 && local<=34) return "강원도";
		else if(local>=35 && local<=39) return "충청북도";
		else if(local==40)				return "대전광역시";
		else if(local==44 || local==49) return "세종특별시";
		else if(local>=41 && local<=43 || 
				local>=45 && local<=47) return "충청남도";
		else if(local>=48 && local<=54) return "전라북도";
		else if(local>=55 && local<=56) return "광주광역시";
		else if(local>=57 && local<=66) return "전라남도";
		else if(local>=67 && local<=70) return "대구광역시";
		else if(local>=71 && local<=81) return "경상북도";
		else if(local==85 || local==90) return "울산광역시";
		else if(local>=82 && local<=92) return "경상남도";
		else if(local>=93 && local<=95) return "제주특별시";
		
		
		return "";
				
	}
	
	//계절
	public String getSeason() {
		
		
		String str_month =this.jumin_no.substring(2,4);
		int month = Integer.parseInt(str_month);

		//봄 3 4 5  여름 6 7 8 가을 9 10 11 
		switch(month/3) {
		case 1 : return "봄"; 
		case 2 : return "여름"; 
		case 3 : return "가을";
		}
		
		return "겨울";
	}
	
	//간지
	public String getGanji() {
		//				  0 1 2 3 4 5 6 7 8 9 10 11
		String gan_str = "경신임계갑을병정무기";
		String ji_str  = "신유술해자축인묘진사오미";
		
		char ch = gan_str.charAt(2);
		
		int my_year = this.getYear();
		
	
		char gan = gan_str.charAt(my_year%10); // 출생년도%10 : 0 ~ 9
		char ji	 = ji_str.charAt(my_year%12);  // 출생년도%12 : 0 ~ 11
		
		
		// 더하기연산 하면 메모리낭비 심하니 String.format이용
		//String ganji=String.format("%s%s년",gan, ji);
		return String.format("%c%c년",gan, ji);
		
	}
	
	
	
	
	//			  01234567890123 <- index
	//jumin_no = "801212-1234560"
	//			  234567 892345
	
	//유효성
	public boolean isvalid() {
		
		
		int sum = 0; //누적값
		/*
		//			  		  		'8'-'0' => 8
		sum = sum + (jumin_no.charAt(0)-'0') * 2;
		//sum = sum + ( Interger.parseInt(jumin_no.subString(0, 1) ) )*2
		sum = sum + (jumin_no.charAt(1)-'0') * 3;
		sum = sum + (jumin_no.charAt(2)-'0') * 4;
		sum = sum + (jumin_no.charAt(3)-'0') * 5; )
		sum = sum + (jumin_no.charAt(4)-'0') * 6;
		sum = sum + (jumin_no.charAt(5)-'0') * 7;
		*/
		// - 건너뛰고
		for(int i=0; i<=5; i++) {
			sum = sum +(jumin_no.charAt(i)-'0')*(i+2);
		}
		
		/*
		sum = sum + (jumin_no.charAt(7)-'0') * 8;
		sum = sum + (jumin_no.charAt(8)-'0') * 9;
		sum = sum + (jumin_no.charAt(9)-'0') * 2;
		sum = sum + (jumin_no.charAt(10)-'0')* 3;
		sum = sum + (jumin_no.charAt(11)-'0')* 4;
		sum = sum + (jumin_no.charAt(12)-'0')* 5;
		*/
		for(int i=7; i<=8;i++) {
			sum = sum +(jumin_no.charAt(i)-'0')*(i+1);
		}
		for(int i=9; i<=12;i++) {
			sum = sum +(jumin_no.charAt(i)-'0')*(i-7);
		}
		
		
		//System.out.println(sum);
		
		/*
		sum %= 11;
		sum = 11-sum;
		sum %= 10; // 0~9
		*/
		sum = (11-sum%11)%10;
		
		System.out.println(sum);
		//				주민번호 마지막자리 숫자
		int last_no = ( jumin_no.charAt(13)-'0');
		
		return (sum==last_no);
	}
	/*
	public boolean isvalid2() {
		
		
		int sum = 0; //누적값
		int check = 2;
		
		for(int i = 0; i<=12; i++) {
			
			if(i==6) continue; // i=6일때 컨티뉴 건너뜀
				
			sum = sum + (jumin_no.charAt(i)-'0') * check;
			check++;
			if(check>9) check=2;
		}
	
		sum = (11-sum%11)%10;
		
		System.out.println(sum);
		//				주민번호 마지막자리 숫자
		int last_no = ( jumin_no.charAt(13)-'0');
		
		return (sum==last_no);
	}
	*/
	
	
	
	public boolean isvalid2() {
		
		int sum = 0;
		int count =2;
		
		for(int i=0; i<=12; i++) {
			
			if(i==6) continue;
			
			sum = sum +(jumin_no.charAt(i)-'0')*count;
			count++;
			
			if(count>9) count = 2;
			
		}
		
		sum = (11-sum%11)%10;
		
		System.out.println(sum);
		
		int last_num = (jumin_no.charAt(13)-'0');
		
		return (sum==last_num);
	}
	
	
}




