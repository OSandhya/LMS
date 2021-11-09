package com.service;

import java.util.List;

import com.entites.UserAddress;

public interface UserAddressServ {
	public UserAddress addUserAddress(UserAddress user);
	public UserAddress updateUserAddressDetails(UserAddress user) throws Throwable;
	public String  deleteUserAddress(UserAddress addressId) throws Throwable;
	public UserAddress viewAddressByUserId(UserAddress userid);
	public List<UserAddress> viewUserAddressList();
	public UserAddress getPinCode(String pincode);
    public List<UserAddress> getState(String state);

}
