package com.cg.account.exception;

@SuppressWarnings("serial")
public class AccountException extends Exception{
public AccountException(){
	super();
}
public AccountException(String message){
	super(message);
}
}
