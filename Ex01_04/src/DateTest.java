import java.util.Date;

public class DateTest{
	public static void main(String[] ar){
		MyDate today = new MyDate();
	
		int year = today.getYear();
		int month = today.getMonth();
		int day = today.getDate();
		
		System.out.println(year + "³â" + month + "¿ù" + day + "ÀÏ");
	}
}
