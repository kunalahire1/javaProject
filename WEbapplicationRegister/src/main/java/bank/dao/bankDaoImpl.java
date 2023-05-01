package bank.dao;

import java.sql.*;

import java.util.*;

import bank.db.*;
import bank.login.register;
import bank.login.*;

public class bankDaoImpl implements bankDao {
	Connection con=DbConnection.getDbConnection();
	@Override
	public int create(List<register> lst) {

		// TODO Auto-generated method stub
		int i=0;
		Connection con=DbConnection.getDbConnection();

		try {
			for(register r:lst)
			{
				
				PreparedStatement pstate=con.prepareStatement("insert into register values(?,?,?,?)");
				pstate.setInt(1,r.getRegNo());
				pstate.setString(2, r.getuName());
				pstate.setString(3, r.getPassword());
				pstate.setFloat(4,r.getAccBal());
				i=pstate.executeUpdate();
				if(i>0)
				{
					System.out.println("Record save...");
				}
				else
				{
					System.out.println("not saved...");
				}
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public void log(List<login> lg) {
		int i=0;
		Connection con=DbConnection.getDbConnection();
		for(login l:lg)
		{
			
			try {
				PreparedStatement pstate=con.prepareStatement("insert into login values(?,?)");
			//	pstate.setString(1,l.getEmail());
			//	pstate.setString(2,l.getPassword());
				i=pstate.executeUpdate();
				if(i>0)
				{
					System.out.println("Record inserted....");
				}
				else
				{ 
					System.out.println("Not inserted");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<register> retrive(int regNo) {
		List<register> lst=null;
		int i=0;
		ResultSet rs=null;
		Connection con=DbConnection.getDbConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("select * from register where reg_No=?");
			pstate.setInt(1, regNo);
			rs=pstate.executeQuery();
			if(rs.next())
			{
				register robj=new register (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4));
				lst=new ArrayList<register>();
				lst.add(robj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return lst;
	}

	@Override
	public int delete(int regNo) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("delete from register where reg_no=?");
			pstate.setInt(1,regNo);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<register> displayAll() {
		Connection con=DbConnection.getDbConnection();
		Statement stat;
		List<register>lst=new LinkedList<register>();
		ResultSet rs=null;
		String str="select * from register";
		try {
			stat=con.createStatement();
			rs=stat.executeQuery(str);
			while(rs.next())
			{
				lst.add(new register(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return lst;
	}
	@Override
	public int update(int regNo,float accBal) {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getDbConnection();
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("update register set acc_bal=? where reg_no=?");
			pstate.setFloat(1, accBal);
			pstate.setInt(2,regNo);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


}


