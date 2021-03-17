import java.util.*;

class createAccount extends accountInfo{
	Scanner in=new Scanner(System.in);

	createAccount(long i){
		setAccNum(i);
		System.out.println("Account Number: "+i);
		getInfo();
		setInitialBalance();
	}

	private void getInfo(){
		System.out.print("Enter First Name: ");
		String fname=in.nextLine();
		System.out.print("Enter last Name: ");
		String lname=in.nextLine();
		setfName(fname);
		setlName(lname);
		/*
		if(fname.isEmpty()){print("null\n");}
		else print("no\n"+getfName()+" ");
		*/
		System.out.print("Enter your Age: ");
		byte age=in.nextByte();
		in.nextLine();
		setAge(age);
		//print(getAge());
		generatePass();
	}

	private void generatePass(){
		System.out.print("Create a secure Password: ");
		String pass=in.nextLine();
		//print(pass);
		setPass(pass);
	}

	private void setInitialBalance(){
		System.out.print("Enter Initial Amount: ");
		double bal=in.nextDouble();
		setBalance("RECIEVE",bal);
		//chkBalance();
		super.accCreated();
	}
}
