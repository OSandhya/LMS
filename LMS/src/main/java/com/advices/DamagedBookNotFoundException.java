package com.advices;

public class DamagedBookNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public DamagedBookNotFoundException(String message){
        super(message);
    }
}
