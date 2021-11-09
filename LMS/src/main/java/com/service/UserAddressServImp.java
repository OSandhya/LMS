package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.AddressNotFoundException;
import com.advices.UserNotFoundException;
import com.entites.UserAddress;
import com.repository.UserAdressRepository;

@Service
public class UserAddressServImp implements UserAddressServ  {

	@Autowired 
	UserAdressRepository repo;
	@Override
	public UserAddress addUserAddress(UserAddress user) {
		 repo.save(user);
		 return user;
	}

	@Override
	public UserAddress updateUserAddressDetails(UserAddress user) throws Throwable{
		Supplier s2 = ()-> new AddressNotFoundException("Addressr not Found");
		int userid= user.getAddressId();
		UserAddress a1 = repo.findById(userid).orElseThrow();
			a1.setAddress(user.getAddress());
			a1.setAddressId(user.getAddressId());
			a1.setCity(user.getCity());
			a1.setPincode(user.getPincode());
			a1.setState(user.getState());
			a1.setUsers(user.getUsers());
			repo.save(user);
			return a1;
	}

	@Override
	public String deleteUserAddress(UserAddress addressId) throws Throwable
	{
		int aId=addressId.getAddressId();
		Supplier s2 = ()-> new AddressNotFoundException("Adderss not Found");
		repo.delete(addressId);
		return "Deleted";
	
	}

	@Override
	public UserAddress viewAddressByUserId(UserAddress userid)
	{
		repo.delete(userid);
		 return userid;
	}

	@Override
	public List<UserAddress> viewUserAddressList() {
		List<UserAddress> L2 = repo.findAll();
		return L2;
	}

	@Override
	public UserAddress getPinCode(String pincode) {
		UserAddress pin = repo.findByPincode(pincode);
		return pin;
	}

	@Override
	public List<UserAddress> getState(String state) {
		List<UserAddress> st=repo.findByState(state);
		return st;
	}

}
