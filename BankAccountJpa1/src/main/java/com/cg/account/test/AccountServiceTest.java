package com.cg.account.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.account.bean.Account;
import com.cg.account.exception.AccountException;
import com.cg.account.service.AccounService;
import com.cg.account.service.IAccountService;

public class AccountServiceTest {
	 private IAccountService service;
	 @Before
	 public void init(){
	 	service=new AccounService();
	 }
	 @Test 
	 public void testCreateAccountForMobile(){
	 	Account ac=new Account();
	 	ac.setMobileNo("4567");
	 	ac.setName("Pinky");
	 	ac.setEmail("pinky@gmail.com");
	 	ac.setBalance(500.0);
	 	try {
			service.CreateAccount(ac);
		} catch (AccountException e) {
			assertEquals("Mobile number should contain 10 digits", e.getMessage());
		}
	 }
	 @Test 
	 public void testCreateAccountForMobile1(){
	 	Account ac=new Account();
	 	ac.setMobileNo("apapo");
	 	ac.setName("Pinky");
	 	ac.setEmail("pinky@gmail.com");
	 	ac.setBalance(500.0);
	 	try {
			service.CreateAccount(ac);
		} catch (AccountException e) {
			assertEquals("Mobile number should contain 10 digits", e.getMessage());
		}
	 }
	 @Test
	 public void testCreateAccountForName(){
	 	Account ac=new Account();
	 	ac.setMobileNo("1234475567");
	 	ac.setName("anil");
	 	ac.setEmail("Anil@gmail.com");
	 	ac.setBalance(500.0);
	 	try{
	 		service.CreateAccount(ac);
	 	}catch(AccountException e){
	 		assertEquals("Name should start with capital letter and should contain only alphabets",e.getMessage());
	 		
	 	}
	 }
	 @Test
	 public void testCreateAccountForname(){
	 	Account ac=new Account();
	 	ac.setMobileNo("1234475567");
	 	ac.setName("anil");
	 	ac.setEmail("anil@gmail.com");
	 	ac.setBalance(500.0);
	 	try{
	 		service.CreateAccount(ac);
	 	}catch(AccountException e){
	 		Assert.assertEquals("Name should start with capital letter and should contain only alphabets",e.getMessage());
	 	}
	 	}
	 @Test
	 public void testCreateAccountForname1(){
	 	Account ac=new Account();
	 	ac.setMobileNo("1234475567");
	 	ac.setName("anil");
	 	ac.setEmail("anil@gmail.com");
	 	ac.setBalance(500.0);
	 	try{
	 		service.CreateAccount(ac);
	 	}catch(AccountException e){
	 		assertEquals("Name should start with capital letter and should contain only alphabets",e.getMessage());
	 	}
	 	}
	 @Test
	 public void testCreateAccountNameEmpty(){
	 	Account ac=new Account();
	 	ac.setMobileNo("1234478679");
	 	ac.setName("");
	 	ac.setEmail("akhil@gmail.com");
	 	ac.setBalance(300.0);
	 	try{
	 		service.CreateAccount(ac);
	 	}catch(AccountException e){
	 		assertEquals("Name cannot be empty",e.getMessage());
	 		
	 	}
	 }
	/* @Test
	 public void testCreateAccountForEmailId(){
	 	Account ac=new Account();
	 	ac.setMobileNo("1234330988");
	 	ac.setName("Deepthi");
	 	ac.setEmail("deepthi@gmail.com");
	 	ac.setBalance(100.0);
	 	try{
	 		service.CreateAccount(ac);
	 	}catch(AccountException e){
	 		assertEquals("Enter valid emailid",e.getMessage());
	 		
	 	}*/
	 
	/* @Test
	 public void testCreateAccountForEmailId1(){
	 	Account ac=new Account();
	 	ac.setMobileNo("1234330988");
	 	ac.setName("Deepthi");
	 	ac.setEmail("deepthi@gm123l.com");
	 	
	 	ac.setBalance(100.0);
	 	try{
	 		service.CreateAccount(ac);
	 	}catch(AccountException e){
	 		assertEquals("Enter valid emailid",e.getMessage());
	 		
	 	}
	 	}*/
	
	 public void testCreateAccount(){
	 	Account ac=new Account();
	 	ac.setMobileNo("9834330988");
	 	ac.setName("Sowju");
	 	ac.setEmail("sowju@gmail.com");
	 	ac.setBalance(200.0);
	 	try{
	 		String s=service.CreateAccount(ac);
	 		assertNotNull(s);
	 	}catch(AccountException e){
	 		assert (e.getMessage()) != null; 
	 		}
	 }
	 @Test
	 public void testShowBalanceForMobileNo(){
	 	try{
	 		service.showBalance("56443");
	 	}catch(AccountException e){
	 		assertEquals("Mobile number should contain ten digits", e.getMessage());
	 			
	 	}
	 	
	 }
	 @Test
	 public void testShowBalanceForMobileNoDoesNotExist(){
	 	try{
	 		service.showBalance("564466663");
	 	}catch(AccountException e){
	 		assertEquals("Mobile number should contain ten digits", e.getMessage());
	 	}
	 	}
	 @Test

	 public void testshowBalanceForName(){
	 	Account ac=new Account();
	 	ac.setMobileNo("937645647");
	 	try{
	 		service.showBalance(ac.getMobileNo());
	 		assertEquals("pooja",ac.getName());
	 	}catch(AccountException e){
	 	assertEquals("Mobile number should contain ten digits", e.getMessage());
	 }
	 }
	
	/* @Test
	 public void testDepositForMobileNoDoesNotExist(){
	 	Account ac=new Account();
	 	ac.setMobileNo("993344550a");
	 	try{
	 		service.deposit(ac.getMobileNo(),252);
	 		
	 	}catch(AccountException e){
	 	assertEquals("The mobile number does not exist", e.getMessage());
	 }
	 }*/
	 @Test

	 public void testDepositForDepositAm1(){
	  	try{
	 		service.deposit("9966065155",-252);
	 		
	 	}catch(AccountException e){
	 	assertEquals("Deposit amount must be greater than zero", e.getMessage());
	 }
	 }
	 @Test

	 public void testDeposit(){
	 	Account ac=new Account();
	 	ac.setMobileNo("9573754346");
	 	try{
	 		Account ac1=service.deposit(ac.getMobileNo(), 220);
	 		assertNotNull(ac1);
	 	}catch(AccountException e){
	 		assert (e.getMessage()) != null;
	 }
	 }
	 @Test

	 public void testWithdrawForMobileNo(){
	 	Account ac=new Account();
	 	ac.setMobileNo("957305436");
	 	try{
	 		service.withdraw(ac.getMobileNo(),852);
	 		
	 	}catch(AccountException e){
	 	assertEquals("Mobile number should contain ten digits", e.getMessage());
	 }

	 }
	 @Test

	 public void testWithdrawForMobileNoDoesNotExist(){
	 	Account ac=new Account();
	 	ac.setMobileNo("95754369");
	 	try{
	 		service.withdraw(ac.getMobileNo(),652);
	 		
	 	}catch(AccountException e){
	    assertEquals("Mobile number should contain ten digits", e.getMessage());
	 }

	 }

	 @Test

	 public void testWithdrawForAmt(){
	 	Account ac=new Account();
	 	ac.setMobileNo("946353539");
	 	try{
	 		service.withdraw(ac.getMobileNo(),-252);
	 		
	 	}catch(AccountException e){
	   assertEquals("Mobile number should contain ten digits", e.getMessage());
	 }

	 }
	 @Test

	 public void testFundTranferForMobileNo(){
	 	Account ac=new Account();
	 	Account ac1=new Account();
	 	ac.setMobileNo("9575436906");
	 	ac1.setMobileNo("9575");
	 	try{
	 		service.fundTransfer(ac.getMobileNo(),ac1.getMobileNo(),342);
	 		
	 	}catch(AccountException e){
	 	Assert.assertEquals("Mobile number should contain ten digits", e.getMessage());
	 }
	 }

	 @Test

	 public void testFundTranferForMobileNoDoesNotExist(){
	 	Account ac=new Account();
	 	Account ac1=new Account();
	 	ac.setMobileNo("9500036906");
	 	ac1.setMobileNo("9575003588");
	 	try{
	 		service.fundTransfer(ac.getMobileNo(),ac1.getMobileNo(),322);
	 		
	 	}catch(AccountException e){
	 	Assert.assertEquals("Mobile number should contain ten digits", e.getMessage());
	 }
	 }

	 @Test

	 public void testFundTranferForAmt(){
	 	Account ac=new Account();
	 	Account ac1=new Account();
	 	ac.setMobileNo("9575493763");
	 	ac1.setMobileNo("9575235353");
	 	try{
	 		service.fundTransfer(ac.getMobileNo(),ac1.getMobileNo(),-342);
	 		
	 	}catch(AccountException e){
	 	assertEquals("Mobile number should contain ten digits", e.getMessage());
	 }
	 }
	 @Test
	 public void testFundTranfer(){
	 	Account ac=new Account();
	 	Account ac1=new Account();
	 	ac.setMobileNo("9575393763");
	 	ac1.setMobileNo("9575005353");
	 	try{
	 		assertTrue(service.fundTransfer(ac.getMobileNo(),ac1.getMobileNo(),130));
	 		
	 	}catch(AccountException e){
	  assert (e.getMessage()) != null;
	 }
	 }
}
	





