// 사용자로부터두개의스트링을입력받아,길이와내용이같은지비교하는프로그램
// 남승일
import java.io.*;
public class StringEx01 {
	public static void main(String[] ar)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String in1, in2;
		System.out.println("첫번째 문자 입력");
		in1 = in.readLine();
		System.out.println("두번째 문자 입력");
		in2 = in.readLine();
		
		if(in1.equals(in2) && in1.length() == in2.length()){
			//if(in1==in2){
			System.out.println("같네요");
			//}
		}
		else{
			System.out.println("다르네요");
		}
	}
}
