package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.IDNotFoundException;
import com.entites.Login;
import com.repository.LoginRepository;
import com.repository.UsersRepository;
@Service
public class LoginServImp implements LoginServ {
@Autowired
LoginRepository repo;
@Autowired
UsersRepository rep;
	@Override
	public Login addLoginDetails(Login login) {
		return repo.save(login);
	}

	@Override
	public Login updateLoginDetails(Login login) throws Throwable {
		int loginId=login.getLoginId();
		Supplier s1=()->new IDNotFoundException("userId doesnot exist in the database");
		Login L=repo.findById(loginId).orElseThrow(s1);
		L.setLoginId(L.getLoginId());
		L.setUsername(L.getUsername());
		L.setPassword(L.getPassword());
		repo.save(login);
		return login;
	}

	@Override
	public String deleteLoginDetails(Login loginId) {
		repo.delete(loginId);
		return "deleted";
	}

	@Override
	public List<Login> viewloginList() {
		List<Login> LC=repo.findAll();
		return LC;
	}

	@Override
	public Login viewusersbyid(int loginId) throws Throwable {
	   Login in=  repo.getById(loginId);
		Supplier s1=()->new IDNotFoundException("userId doesnot exist in the database");
		Login Lm=  repo.findById(loginId).orElseThrow(s1);
		return Lm;
	}

	@Override
	public List<Login> getByusername(String username) {
		List<Login> UN=repo.findByusername(username);
		return UN;
	}

}
