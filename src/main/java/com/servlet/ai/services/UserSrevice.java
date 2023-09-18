package com.servlet.ai.services;

import java.util.List;

import com.ace.ai.web.User;
import com.servlet.ai.repo.UserRepo;

public class UserSrevice {
	
	public boolean checkEmailAndPassword(String email,String password) {
		UserRepo userRepo  = new UserRepo();
		User user =	userRepo.findUserByEmail(email);
		if(user == null) {
			return false;
		}else{
			if(password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public List<User> findAll(){
		UserRepo userRepo = new UserRepo();
		List<User> users = userRepo.findAll();
		return users;
	}
	
	public User findById(int id){
		UserRepo userRepo = new UserRepo();
		User users = userRepo.findUserById(id);
		return users;
	}
	
	public  boolean checkEmailAlreadyExist(String email) {
		UserRepo userRepo = new UserRepo();
		User user = userRepo.findUserByEmail(email);
		if(user != null) {
			return true;
		}
		return false;
	}
	public boolean addUser(User user){
		UserRepo userRepo = new UserRepo();
		boolean status = userRepo.createUser(user);
		if(status) {
			return true;
		}
		return false;
	}
	
	public boolean checkEmailAlreadyExistAtUpdate(String email,int id) {
		UserRepo userRepo = new UserRepo();
		User user = userRepo.findUserByEmail(email);
		if (user == null) {
			return false;
		} else {
			if(id == user.getId()) {
				return false;
			}
			return true;
		}
	}
	
	public void updateUser(User user) {
		UserRepo userRepo = new UserRepo();
		userRepo.updateUser(user);
	}
	
	public void deleteUser(int id) {
		UserRepo userRepo = new UserRepo();
		userRepo.deleteUser(id);
	}
	
	public void changePassword(int id,String newPassword) {
		UserRepo userRepo = new UserRepo();
		userRepo.ChangePassword(id, newPassword);
	}
	
}
