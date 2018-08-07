package com.cg.count.exception;

@SuppressWarnings("serial")
public class AccountException extends Exception{
public AccountException(){
	super();
}
public AccountException(String message){
	super(message);
}
}
