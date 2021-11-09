package com.controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.spi.LoginModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entites.Login;
import com.service.LoginServ;
import com.service.LoginServImp;

@RestController
@RequestMapping("/api")
public class LoginCon {
	@Autowired
	LoginServImp LogSe;
	
	@PostMapping("/addLoginDetails")
	public ResponseEntity<Login>  addLoginDetails(@RequestBody Login lo) {
		Login Lm=LogSe.addLoginDetails(lo);
		ResponseEntity<Login> re=new ResponseEntity <Login>(Lm,HttpStatus.OK);
		return re;
		
	}
	
	@PutMapping(path="/updateLoginDetails")
	public ResponseEntity<Login> updateLoginDetails(@RequestBody Login Lmm) throws Throwable{
		Login up=LogSe.updateLoginDetails(Lmm);
		ResponseEntity<Login> re=new ResponseEntity <Login>(up,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteLoginDetails")
	public ResponseEntity<Login> deleteLoginDetails(@RequestBody Login Del){
		LogSe.deleteLoginDetails(Del);
		ResponseEntity<Login> re=new ResponseEntity<Login>(Del,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/ViewusersList")
	public ResponseEntity<List<Login>> viewloginlist(){
		List<Login> lc1=LogSe.viewloginList();
		ResponseEntity<List<Login>> re=new ResponseEntity <List<Login>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/ViewusersbyId/{userid}")
	public ResponseEntity<Login> viewuserById(@PathVariable int loginId ) throws Throwable 
	{
		Login UI=LogSe.viewusersbyid(loginId);
		ResponseEntity<Login> re=new ResponseEntity<Login>(UI,HttpStatus.OK);
		return re;
		
	}
	
	@GetMapping(path="/viewusersbyName/{username}")
	public ResponseEntity<List<Login>> getByusername(@PathVariable String username ) 
	{
		List<Login> USN=LogSe.getByusername(username);
		ResponseEntity<List<Login>> re=new ResponseEntity<List<Login>>(USN,HttpStatus.OK);
		return re;
	}
	
	



}
