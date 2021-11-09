package com.advices;

public class SubscriptionExpiredException extends Exception {
	private static final long serialVersionUID = 1L;
	public SubscriptionExpiredException(String message){
        super(message);
    }
}
