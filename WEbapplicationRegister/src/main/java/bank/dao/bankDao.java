package bank.dao;
import java.util.List;

import bank.login.*;

public interface bankDao {
	public int create(List<register> lst);
	public void log(List<login>lg);
	public List<register>retrive(int regNo);
	public int delete(int regNo);
	public List<register> displayAll();
//	public int update(int regNo,float accBal);
	public int update(int regNo, float accBal);

}
