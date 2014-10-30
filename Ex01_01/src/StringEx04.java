//하나의스트링을입력받아, 처음두문자와마지막두문자를출력하는프로그램
// 남승일
import java.io.*;
public class StringEx04 {
	public static void main(String[] ar) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String hangle;
		String jjal1,jjal2;
		
		System.out.println("문자 4개를 입력하세요");
		
		hangle = in.readLine();
		
		//substring 쓰기
		jjal2 = hangle.substring(0,2);
		System.out.println("앞2개 = " + jjal2);
		jjal1 = hangle.substring(2);
		System.out.println("뒤2개 = " + jjal1);
		
		//바이트로짜르기
		byte[] t = hangle.getBytes();
		jjal1 = new String(t, 0, 4);
		jjal2 = new String(t, 4, 4);
		
		System.out.println("앞2개 = " + jjal1);
		System.out.println("뒤2개 = " + jjal2);
		
	}
}

