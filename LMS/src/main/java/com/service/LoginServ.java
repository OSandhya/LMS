package com.service;

import java.util.List;
import java.util.Optional;

import com.entites.Login;

public interface LoginServ {
	public Login addLoginDetails(Login login);
	public Login updateLoginDetails(Login login) throws Throwable;
	public String deleteLoginDetails(Login loginId);
	public List<Login> viewloginList();
	public Login viewusersbyid(int loginId) throws Throwable;
	public List<Login> getByusername(String username);
}
