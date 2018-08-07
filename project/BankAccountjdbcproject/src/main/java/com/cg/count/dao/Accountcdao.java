package com.cg.count.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.HashMap;

import com.cg.count.bean.Account;

import com.cg.count.db.DBUtil;
import com.cg.count.exception.AccountException;

public class Accountcdao implements IAccountDao {
	//private static HashMap<String,Account> AccountMap=AccountDB.getAccountDB();
	@Override
	public String CreateAccount(Account acc) throws AccountException {
		//AccountMap.put(acc.getMobileNo(), acc);
		Connection con=DBUtil.getConnection();
		PreparedStatement stat;
		try{
			con.setAutoCommit(false);
			stat = con.prepareStatement(IQueryMapper.insert);
			stat.setString(1, acc.getName());
			stat.setString(2, acc.getEmail());
			stat.setString(3, acc.getMobileNo());
			stat.setDouble(4, acc.getBalance());
			int res=stat.executeUpdate();
			if(res==1){
				con.commit();
				return acc.getMobileNo();
			}else{
				throw new AccountException("Could not create account");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
	}

	@Override
	public double showBalance(String mobileno) throws AccountException {
		Connection con=DBUtil.getConnection();
		PreparedStatement stat;
		try{
			con.setAutoCommit(false);
			stat=con.prepareStatement(IQueryMapper.getBal);
			stat.setString(1, mobileno);
			ResultSet rs=stat.executeQuery();
			con.commit();
			if(rs!=null){
				rs.next();
				return rs.getDouble("balance");
			}else{
				throw new AccountException("mobile no does not exists");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
	}


	@Override
	public Account deposit(String mobileno,double deposit) throws AccountException {
		
		Connection con=DBUtil.getConnection();
		PreparedStatement stat;
		PreparedStatement stat1;
		try{
			con.setAutoCommit(false);
			stat=con.prepareStatement(IQueryMapper.getacc);
			stat.setString(1, mobileno);
			ResultSet rs=stat.executeQuery();
			if(rs!=null){
				rs.next();
				Account acc=new Account();
				double balance=rs.getDouble("balance")+deposit;
				acc.setName(rs.getString("name"));
				acc.setMobileNo(rs.getString("mobileno"));
				acc.setBalance(balance);
				acc.setEmail(rs.getString("email"));
			//	acc.setDate(Date.valueOf(LocalDate.now()));
				//acc.setDate(LocalDateTime.now());
				//Account acc1=new Account();
				stat1=con.prepareStatement(IQueryMapper.update);
				stat1.setDouble(1, acc.getBalance());
			//	stat1.setDate(2, acc.getDate());
				stat1.setString(2, acc.getMobileNo());
				int rs1=stat1.executeUpdate();
				if(rs1==1){
					con.commit();
					return acc;
				}else{
					throw new AccountException("balance is not updated");
				}
			}
			else{
				throw new AccountException("mobile no does not exists");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
	}


	@Override
	public Account withdraw(String mobileno,double withdraw) throws AccountException {
		
		Connection con=DBUtil.getConnection();
		PreparedStatement stat;
		PreparedStatement stat1;
		try{
			con.setAutoCommit(false);
			stat=con.prepareStatement(IQueryMapper.getacc);
			stat.setString(1, mobileno);
			ResultSet rs=stat.executeQuery();
			if(rs!=null){
				rs.next();
				Account acc=new Account();
				double balance=rs.getDouble("balance")-withdraw;
				acc.setName(rs.getString("name"));
				acc.setMobileNo(rs.getString("mobileno"));
				acc.setBalance(balance);
				acc.setEmail(rs.getString("email"));
				//acc.setDate(Date.valueOf(LocalDate.now()));
				//acc.setDate(LocalDateTime.now());
				//Account acc1=new Account();
				stat1=con.prepareStatement(IQueryMapper.update);
				stat1.setDouble(1, acc.getBalance());
				//stat1.setDate(2, acc.getDate());
				stat1.setString(2, acc.getMobileNo());
				int rs1=stat1.executeUpdate();
				if(rs1==1){
					//rs1.next();
					con.commit();
					//bal1=acc.getBalance();
					return acc;
				}else{
					throw new AccountException("mobile no does not exists");
				}
				//return bal1;
			}
			else{
				throw new AccountException("mobile no does not exists");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
	}




	private void autocommit(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account printTransactionDetails(String mobileno)throws AccountException {
		
		Connection con=DBUtil.getConnection();
		PreparedStatement stat;
		try{
			con.setAutoCommit(false);
			stat=con.prepareStatement(IQueryMapper.getacc);
			stat.setString(1, mobileno);
			ResultSet rs=stat.executeQuery();
			con.commit();
			if(rs!=null){
				rs.next();
				Account ac=new Account();
				ac.setName(rs.getString("name"));
				ac.setMobileNo(rs.getString("mobileno"));
				ac.setEmail(rs.getString("email"));
				ac.setBalance(rs.getDouble("balance"));
				//ac.setDate(rs.getDate("date1"));
				return ac;
			}else{
				throw new AccountException("mobile no does not exists");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AccountException(e.getMessage());
		}
	}


}






