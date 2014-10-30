import java.util.Date;

public class MyDate extends Date {
	
	public int getYear(){
		return super.getYear()+1900;
	}
	public int getMonth(){
		return super.getMonth()+1;
	}

}
