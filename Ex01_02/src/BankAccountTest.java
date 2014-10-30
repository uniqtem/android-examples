import java.io.*;
public class BankAccountTest {
	public static void main(String [] ar)throws IOException{
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BankAccount a = new BankAccount("123","남승일",1000);
		int m = a.getMoney();
		System.out.println(m);
		a.deposit(10000);
		m = a.getMoney();
		System.out.println(m);
		a.withDraw(5000);
		m = a.getMoney();
		System.out.println(m);
		int str[]= null;
		str = new int[5];
		str[0] = 1;
		str[1] = 2;
		str[4] = 4;
		a.getMM(str);
	}
}
