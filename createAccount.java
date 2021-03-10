import java.util.*;

class createAccount extends accountInfo implements printInterface{
	Scanner in=new Scanner(System.in);

	createAccount(long i){
		setAccNum(i);
		getInfo();
		setInitialBalance();
	}

	private void getInfo(){
		print("Enter First Name: ");
		String fname=in.nextLine();
		print("Enter last Name: ");
		String lname=in.nextLine();
		setfName(fname);
		setlName(lname);
		/*
		if(fname.isEmpty()){print("null\n");}
		else print("no\n"+getfName()+" ");
		*/
		print("Enter your Age: ");
		byte age=in.nextByte();
		in.nextLine();
		setAge(age);
		//print(getAge());
		generatePass();
	}

	private void generatePass(){
		print("Create a secure Password: ");
		String pass=in.nextLine();
		//print(pass);
		setPass(pass);
	}

	private void setInitialBalance(){
		print("Enter Initial Amount: ");
		double bal=in.nextDouble();
		setBalance(bal);
		//chkBalance();
		super.accCreated();
	}
}
