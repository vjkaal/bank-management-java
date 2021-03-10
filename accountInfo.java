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

	public long getAccNum(){
		return accountNumber;
	}

	public void setAge(byte Age){
		age=Age;
	}

	public byte getAge(){
		return age;
	}

	public void setfName(String fName){
		fname=fName;
	}

	public String getfName(){
		return fname;
	}

	public void setlName(String lName){
		lname=lName;
	}

	public String getlName(){
		return lname;
	}

	public void setPass(String pass){
		//System.out.println("Yes");
		passOriginal = pass;
	}

	public boolean chkPass(String pass){
		boolean success=false;
		success=passOriginal.equals(pass);
		return success;
	}

	public void setBalance(double bal){
		balance=bal;
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
			chkpoint+=1;
		}
		else if(chkpoint==5){
			System.out.println("Account created successfully!");
		}
	}

	protected boolean chkLogin(long accNum,String pass){
		int res=0;
		boolean success=false;
		res=(accNum==accountNumber)?1:0;
		res=(chkPass(pass)==true)?1:0;
		if(res==2){
			success=true;
		}
		else success=false;
		return success;
	}

	protected void putInfo(){
		System.out.println("Name: "+fname+" "+lname);
		System.out.println("Age: "+age);
		chkBalance();
	}
}
