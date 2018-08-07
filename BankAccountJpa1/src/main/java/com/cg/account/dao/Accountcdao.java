package com.cg.account.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.account.bean.Account;
import com.cg.account.exception.AccountException;

public class Accountcdao implements IAccountDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
	EntityManager em = emf.createEntityManager();
	@Override
	public String CreateAccount(Account acc) throws AccountException {
		em.getTransaction().begin();
		em.persist(acc);
		em.getTransaction().commit();
		return acc.getMobileNo();
	}
	@Override
	public double showBalance(String mobileno) throws AccountException {
		String str="select a from Account a where a.mobileNo"
				+ "o=?";
		TypedQuery<Account> query=em.createQuery(str,Account.class);
		query.setParameter(1,mobileno);
		Account ac=query.getSingleResult();
		if(mobileno.equals(ac.getMobileNo())) {
			return ac.getBalance();
		}else {
			throw new AccountException("number doesnot exists");
		}
	}
	@Override
	public Account deposit(String mobileno, double depositAmt)
			throws AccountException {
		em.getTransaction().begin();
		String str="select a from Account a where a.mobileNo=?";
		TypedQuery<Account> query=em.createQuery(str,Account.class);
		query.setParameter(1,mobileno);
		Account ac=query.getSingleResult();
		if(ac==null) {
			throw new AccountException("does not exists");
		}
		double d=ac.getBalance()+depositAmt;
		ac.setBalance(d);
		em.merge(ac);
		em.getTransaction().commit();
		return ac;
	}
	@Override
	public Account withdraw(String mobileno, double withdrawAmt)
			throws AccountException {
		em.getTransaction().begin();
		String str="select a from Account a where a.mobileNo=?";
		TypedQuery<Account> query=em.createQuery(str,Account.class);
		query.setParameter(1,mobileno);
		Account ac=query.getSingleResult();
		if(ac==null) {
			throw new AccountException("does not exists");
		}
		double d=ac.getBalance()-withdrawAmt;
		ac.setBalance(d);
		em.merge(ac);
		em.getTransaction().commit();
		return ac;
	}
	@Override
	public Account printTransactionDetails(String mobileno)
			throws AccountException {
		String str="select a from Account a where a.mobileNo=?";
		TypedQuery<Account> query=em.createQuery(str,Account.class);
		query.setParameter(1,mobileno);
		Account ac=query.getSingleResult();
		if(ac==null) {
			return ac;
		}else {
			throw new AccountException("number doesnot exists");
		}
	}
}



