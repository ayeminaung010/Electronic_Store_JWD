package com.servlet.ai.services;

import java.util.List;

import com.ace.ai.web.TypeComputer;

import com.servlet.ai.repo.TypeComputerRepo;

public class TypeComputerService {
	public List<TypeComputer> findAll() {
		TypeComputerRepo typeComputerRepo = new TypeComputerRepo();
		List<TypeComputer> typeComputers = typeComputerRepo.findAll();
		return typeComputers;
	}
}
