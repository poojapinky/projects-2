package com.cg.account.service;

import com.cg.account.bean.Account;
import com.cg.account.dao.Accountcdao;
import com.cg.account.dao.IAccountDao;
import com.cg.account.exception.AccountException;

public class AccounService implements IAccountService {
IAccountDao dao=new Accountcdao();
	@Override
	public String CreateAccount(Account acc) throws AccountException {
		if(!acc.getMobileNo().matches("\\d{10}")){
			throw new AccountException("Mobile number should contain 10 digits");
		}
		if(acc.getName().isEmpty()|| acc.getName()== null){
			throw new AccountException("Name cannot be empty");
		}else{
			if(!acc.getName().matches("[A-Z][A-Za-z]{3,}")){
				throw new AccountException("Name should start with capital letter and should contain only alphabets");
			}
		}
		if(!acc.getEmail().matches("[a-z0-9]+@[a-z]+\\.com")){
		    throw new AccountException("Enter valid emailid");	
		}
		if(acc.getBalance()<=0){
			throw new AccountException("Balance should be greater than zero");
		}
		return dao.CreateAccount(acc);
	}

	@Override
	public double showBalance(String mobileno) throws AccountException {
	 if(!mobileno.matches("\\d{10}")){
		 throw new AccountException("Mobile number should contain ten digits");
	 }
		return dao.showBalance(mobileno);
	}

	@Override
	public Account deposit(String mobileno,double depositAmt) throws AccountException {
		
		//Account acc=dao.deposit(mobileno);
		if(depositAmt<=0){
			throw new AccountException("Deposit amount must be greater than zero");
		}else{
			if(!mobileno.matches("\\{10}")){
				 throw new AccountException("Mobile number should contain ten digits");
			}
		}
		//acc.setBalance(acc.getBalance()+depositAmt);
		//acc.setDate(LocalDateTime.now());
		return dao.deposit(mobileno, depositAmt);
	}

	@Override
	public Account withdraw(String mobileno,double withdrawAmt) throws AccountException {
		if(!mobileno.matches("\\d{10}")){
		
			 throw new AccountException("Mobile number should contain ten digits");
		}
		
		if(withdrawAmt<=0){
			throw new AccountException("The amount to be withdrawn should be less than available balance and greater than zero");
		}
		
		Account acc1=dao.withdraw(mobileno, withdrawAmt);
		return acc1;
	}

	@Override
	public boolean fundTransfer(String sourcemobileno, String destmobileno,
			double tranferAmt) throws AccountException {
		if(!sourcemobileno.matches("\\d{10}")){
			 throw new AccountException("Mobile number should contain ten digits");
		}
			 if(!destmobileno.matches("\\{10}")){
				 throw new AccountException("Mobile number should contain ten digits");
			 }
			 IAccountService service=new AccounService();
			 Account ac1=service.withdraw(sourcemobileno,tranferAmt);
			 Account ac2=service.deposit(destmobileno, tranferAmt);
		return true;
	
	}

	@Override
	public Account printTransactionDetails(String mobileno)
			throws AccountException {
		// TODO Auto-generated method stub
		return dao.printTransactionDetails(mobileno);
	}

	
		
	}


