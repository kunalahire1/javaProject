package bank.login;

public class register {
	private int regNo;
	private String uName;
	private String password;
	private float accBal;
	public register(int regNo, String uName, String password, float accBal) {
		super();
		this.regNo = regNo;
		this.uName = uName;
		this.password = password;
		this.accBal = accBal;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getAccBal() {
		return accBal;
	}
	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}

}
