package com.servlet.ai.services;

import java.util.List;

import com.ace.ai.web.Computer;
import com.servlet.ai.repo.ComputerRepo;


public class ComputerService {
	public List<Computer> findAll() {
		ComputerRepo computerRepo = new ComputerRepo();
		List<Computer> computers = computerRepo.findAll();
		return computers;
	}
	
	public boolean addComputer(Computer computer) {
		ComputerRepo computerRepo = new ComputerRepo();
		boolean status = computerRepo.createComputer(computer);
		if (status) {
			return true;
		}
		return false;
	}
	
	public void updateComputer(Computer computer) {
		ComputerRepo computerRepo = new ComputerRepo();
		computerRepo.updateComputer(computer);
	}
	
	
	public void deleteComputer(int id) {
		ComputerRepo computerRepo = new ComputerRepo();
		computerRepo.deleteComputer(id);
	}

	
}
