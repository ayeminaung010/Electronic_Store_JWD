package com.servlet.ai.services;

import java.util.List;

import com.ace.ai.web.Printer;
import com.servlet.ai.repo.PrinterRepo;



public class PrinterService {
	public List<Printer> findAll() {
		PrinterRepo printeRepo = new PrinterRepo();
		List<Printer> printers = printeRepo.findAll();
		return printers;
	}
	
	
	public boolean addPrinter(Printer printer) {
		PrinterRepo printerRepo = new PrinterRepo();
		boolean status = printerRepo.createPrinter(printer);
		if (status) {
			return true;
		}
		return false;
	}
	
	public void updatePrinter(Printer printer) {
		PrinterRepo printerRepo = new PrinterRepo();
		printerRepo.updatePrinter(printer);
	}
	
	
	public void deletePrinter(int id) {
		PrinterRepo printerRepo = new PrinterRepo();
		printerRepo.deletePrinter(id);
	}

	
}
