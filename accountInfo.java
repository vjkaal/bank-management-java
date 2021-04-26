import java.util.*;

class accountInfo implements accountInter{
	
	private long accountNumber;
	private byte age;
	private String fname;
	private String lname;
	private String passOriginal;
	private double balance;
	
	public void setAccNum(long accNum){
		accountNumber=accNum;
	}

	@Override
	public long getAccNum(){
		return accountNumber;
	}

	public void setAge(byte Age){
		age=Age;
	}

	@Override
	public byte getAge(){
		return age;
	}

	public void setfName(String fName){
		fname=fName;
	}

	@Override
	public String getfName(){
		return fname;
	}

	public void setlName(String lName){
		lname=lName;
	}

	@Override
	public String getlName(){
		return lname;
	}

	public void setPass(String pass){
		//System.out.println("Yes");
		passOriginal = pass;
	}

	public boolean chkPass(String pass){
		return passOriginal.equals(pass);
	}

	public void setBalance(String way,double amount){
		if(way.equals("SEND")){
			balance-=amount;
		}
		else if(way.equals("RECIEVE")){
			balance+=amount;
		}
	}

	public void chkBalance(){
		System.out.println("Balance : "+balance);
	}

	protected void accCreated(){
		int chkpoint=0;
		Scanner in=new Scanner(System.in);
		chkpoint+=(fname.isEmpty())?0:1;
		if(chkpoint==0){
			while(fname.isEmpty()){
				System.out.print("Please Enter valid First Name: ");
				fname=in.nextLine();
			}
			chkpoint+=1;
		}
		chkpoint+=(lname.isEmpty())?0:1;
		if(chkpoint==1){
			while(lname.isEmpty()){
				System.out.print("Please Enter valid Last Name: ");
				lname=in.nextLine();
			}
			chkpoint+=1;
		}
		chkpoint+=(age>0)?1:0;
		if(chkpoint==2){
			while(age==0){
				System.out.print("Please Enter Valid Age: ");
				age=in.nextByte();
				in.nextLine();
			}
			chkpoint+=1;
		}
		chkpoint+=(passOriginal.isEmpty())?0:1;
		if(chkpoint==3){
			while(passOriginal.isEmpty()){
				System.out.print("Please generate a Valid Password: ");
				passOriginal=in.nextLine();
			}
			chkpoint+=1;
		}
		chkpoint+=(balance>0)?1:0;
		if(chkpoint==4){
			while(balance==0){
				System.out.print("Please Put some Initial Balance: ");
				balance=in.nextDouble();
			}
		}
		else {
			System.out.println("Account created successfully!");
		}
	}

	protected boolean chkLogin(long accNum,String pass){
		int res=0;
		boolean success;
		res+=(accNum==accountNumber)?1:0;
		res+=(chkPass(pass))?1:0;
		success= res == 2;
		return success;
	}

	protected int loginMenu(){
		System.out.println("Display Information: Press 1");
		System.out.println("Deposit Money: Press 2");
		System.out.println("Withdraw Money: Press 3");
		System.out.println("Transfer Money: Press 4");
		System.out.println("Display Balance: Press 5");
		System.out.println("Exit: Press 0");
		Scanner in=new Scanner(System.in);
		return in.nextInt();
	}

	protected void putInfo(){
		System.out.println("Name: "+fname+" "+lname);
		//System.out.println("Age: "+age);
		chkBalance();
	}

	protected void deposit(){
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Amount to deposit: ");
		double amount=in.nextDouble();
		setBalance("RECIEVE",amount);
	}

	protected void withdraw(){
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Amount to withdraw: ");
		double amount=in.nextDouble();
		boolean success=chkAmount(amount);
		if(success){
			setBalance("SEND",amount);
			System.out.println("Done!");
		}
	}

	protected boolean chkAmount(double amount){
		boolean success=true;
		if(amount>=balance){
			success=false;
		}
		return success;
	}
}
