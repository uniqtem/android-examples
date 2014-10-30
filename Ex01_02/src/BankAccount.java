public class BankAccount {
	private String accountNum;
	private String name;
	private int money;
	
	public BankAccount(){
		accountNum = "";
		name = "";
		money = 0;
	}
	public BankAccount(String accountNum, String name, int money){
		this.accountNum = accountNum;
		this.name = name;
		this.money = money;
	}
	public String getAccountNum(){
		return accountNum;
	}
	public void setAccountNum(String accountNum){
		this.accountNum = accountNum;	
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public void deposit(int m){
		money += m;
	}
	public void withDraw(int m){
		money -= m;
	}
	public int getMoney(){
		return money;		
	}
	public int getMM(int[] str){
		System.out.println(str[4]);
		return 0;
	}
}