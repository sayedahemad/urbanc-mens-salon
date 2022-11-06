package com.company.urban.menssalon.service;

import java.util.List;

import com.company.urban.menssalon.entity.MensSalon;

public interface MensSalonService {

	MensSalon saveMensSalon(MensSalon mensSalon);
	
	MensSalon updatMensSalon(MensSalon mensSalon);
	
	void deleteMensSalon(MensSalon mensSalon);
	
	MensSalon findMensSalonById(int id);
	
	List<MensSalon> findAllMensSalons();
}
