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
			case CREATEACCOUNT: System.out.println("\f");createAccount(); break;
			case LOGIN: System.out.println("\f");login();break;
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
		int x=(int)accNum;
		x-=10000;
		success=accInfo.get(x).chkLogin(accNum,pass);
		if(success==true){
			int res=1;
			while(res!=0){
				res=accInfo.get(x).loginMenu();
				switch(res){
					case 1: accInfo.get(x).putInfo();break;
					case 2: accInfo.get(x).deposit();break;
					case 3: accInfo.get(x).withdraw();break;
					case 4: transferMoney(x,accNum);break;
					case 5: accInfo.get(x).chkBalance();break;
					case 0: System.out.println("Exiting");break;
				}
			}		
		}
		else{
			System.out.println("AccountNumber or password is wrong!\n");
			login();
		}
		selection();
	}

	private void transferMoney(int x,long acc1){
		System.out.println("Your Account Number: "+acc1);
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Beneficiary Account Number: ");
		long acc2=in.nextLong();
		int y=(int)acc2;
		y-=10000;
		boolean success=false;
		double amount=0;
		while(success==false){
			System.out.print("Enter amount to transfer: ");
			amount=in.nextDouble();
			success=accInfo.get(x).chkAmount(amount);
			//System.out.println(success);
		}
		accInfo.get(x).setBalance("SEND",amount);
		accInfo.get(y).setBalance("RECIEVE",amount);
		accInfo.get(x).chkBalance();
		System.out.println("DONE");
	}
}
