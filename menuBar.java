import java.util.*;

class menuBar implements printInterface{
	LinkedList<accountInfo> accInfo=new LinkedList<accountInfo>();
	private static long i=10000;

	enum menuSelection {
		EXIT,CREATEACCOUNT,LOGIN
	}

	public void selection(){
		switch(menu_bar()){
			case EXIT: print("Exiting\n");break;
			case CREATEACCOUNT: createAccount(); break;
			case LOGIN: login();break;
			default: break;
		}
	}

	private menuSelection menu_bar(){
		print("Menu bar: \n");
		print("Create Account - Press 1\n");
		print("Login to Existing account - Press 2\n");
		print("Exit - Press 0\n");
		Scanner in=new Scanner(System.in);
		int choice=in.nextInt();
		menuSelection res=menuSelection.EXIT;
		switch(choice){
			case 0: res=menuSelection.EXIT;break;
			case 1: res=menuSelection.CREATEACCOUNT;break;
			case 2: res=menuSelection.LOGIN;break;
			default: break;
		}
		return res;
	}
	
	public void createAccount(){
		accInfo.add(new createAccount(i));
		i++;
		selection();
	}

	public void login(){
		Scanner in=new Scanner(System.in);
		System.out.print("Enter account Number: ");
		long accNum=in.nextLong();
		in.nextLine();
		System.out.print("Enter password: ");
		String pass=in.nextLine();
		boolean success=true;
		accNum-=10000;
		int x=(int)accNum;
		success=accInfo.get(x).chkLogin(accNum,pass);
		if(success=true){
			accInfo.get(x).putInfo();
		}
		else{
			System.out.println("AccountNumber or password is wrong!\n");
			login();
		}
		selection();
	}
}
