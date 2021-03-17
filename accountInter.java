interface accountInter extends privateAccountInter{
	void setAccNum(long accNum);
	long getAccNum();
	void setAge(byte Age);
	byte getAge();
	void setfName(String fName);
	void setlName(String lName);
	String getfName();
	String getlName();
}

interface privateAccountInter{
	void setPass(String pass);
	boolean chkPass(String pass);
	void setBalance(String way,double amount);
	void chkBalance();
}
