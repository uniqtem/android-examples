//사용자로부터두개의정수를스트링으로입력받아, 두수의합을스트링으로변환하여출력하는프로그램
// 남승일
import java.io.*;
public class StringEx03 {
	public static void main(String[] ar) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String val1, val2;
		int result;
		String result1;
		
		System.out.println("정수 2개를 입력하세요 String 형입니다.");
		val1=in.readLine();
		val2=in.readLine();
		
		int val11=Integer.parseInt(val1);
		int val12=Integer.parseInt(val2);
		result = val11+val12;
		
		result1= Integer.toString(result);
		
		System.out.println("두수의합을 String으로 변환하여 출력 = " + result1);
		}
}
