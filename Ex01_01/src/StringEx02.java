//사용자로부터두개의정수를입력받아, 그합을스트링으로변환하는프로그램
// 남승일
import java.io.*;
public class StringEx02 {
	public static void main(String[] ar) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int val1, val2;
		int result ; 
		String stresult ;
		System.out.println("숫자 2개 입력하세요");
		val1 = Integer.parseInt(in.readLine());
		val2 = Integer.parseInt(in.readLine());
		
		result = val1+val2;
		
		stresult=Integer.toString(result);
		System.out.println("스트링으로 변환값 = " + stresult);
		
	}

}
