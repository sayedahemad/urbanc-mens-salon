package com.company.urban.menssalon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.urban.menssalon.entity.MensSalon;
import com.company.urban.menssalon.repository.MensSalonRepository;
@Service
public class MensSalonServiceImpl implements MensSalonService {

	@Autowired
	private MensSalonRepository repository;
	
	@Override
	public MensSalon saveMensSalon(MensSalon mensSalon) {
		return repository.save(mensSalon);
	}

	@Override
	public MensSalon updatMensSalon(MensSalon mensSalon) {
		return repository.save(mensSalon);
	}

	@Override
	public void deleteMensSalon(MensSalon mensSalon) {
		repository.delete(mensSalon);
	}

	@Override
	public MensSalon findMensSalonById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<MensSalon> findAllMensSalons() {
		return repository.findAll();
	}

}
