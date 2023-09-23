package com.servlet.ai.services;

import java.util.List;

import com.ace.ai.web.Make;
import com.servlet.ai.repo.MakeRepo;

public class MakeService {
	public List<Make> findAll() {
		MakeRepo makeRepo = new MakeRepo();
		List<Make> makes = makeRepo.findAll();
		return makes;
	}
}
