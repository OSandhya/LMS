package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.OrderNotFoundException;
import com.advices.UserNotFoundException;
import com.entites.Users;
import com.repository.UsersRepository;

@Service
public class UsersServImp implements UsersServ{

	@Autowired 
	UsersRepository rep;
	@Override
	public Users registerUserDetails(Users user) {
		rep.save(user);
		return user;
	}

	@Override
	public List<Users> viewAllUsersList() {
		
		List<Users> L1 = rep.findAll();		
		return L1;
	}

	@Override
	public Users updateUserDetails(Users user) throws Throwable {
		int userid = user.getUserid();
		Supplier s2 = ()-> new UserNotFoundException("user  not Found");
		Users u1 =rep.findById(userid).orElseThrow(s2);
		u1.setPassword(user.getPassword());
		u1.setFirstName(user.getFirstName());
		u1.setLastName(user.getLastName());
		u1.setMobileno(user.getMobileno());
		u1.setEmail(user.getEmail());
		u1.setDate_of_birth(user.getDate_of_birth());
		u1.setSubscription_date(user.getSubscription_date());
		u1.setSub_expire_date(user.getSub_expire_date());
		u1.setSubscription_status(user.getSubscription_status());
		rep.save(u1);
		return u1;
	}

	@Override
	public Users deleteUserDetails(Users user) {
		rep.delete(user);
		return user;
	}

	@Override
	public Users getEmail(String email) {
		Users eid =rep.findByEmail(email);
		return eid;
	}

	@Override
	public Users getMobileno(String mobileno) {
		Users eid =rep.findByMobileno(mobileno);
		return eid;
	}

	@Override
	public Users loginValidate(Users user) throws Throwable
	{
		
		Optional<Users> u1=rep.findById(user.getUserid());
		if(!u1.isEmpty())
		{
			if(u1.get().getPassword().equals(user.getPassword()))
			{
				return user;
			}
			/*
			 * else { throw new UserNotFoundException("Wrong Password"); }
			 */
		}
		else
		{
			throw new UserNotFoundException("User Not Found");
		}
		return user;
	}
	}


