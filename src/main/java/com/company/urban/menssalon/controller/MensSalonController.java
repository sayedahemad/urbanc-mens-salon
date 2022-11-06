package com.company.urban.menssalon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.urban.menssalon.entity.MensSalon;
import com.company.urban.menssalon.service.MensSalonService;

@Controller
public class MensSalonController {

	@Autowired
	private MensSalonService service;
	
	@RequestMapping("/addMensSalonService")
	public String showAddService() {
		return "addService";
	}
	
	@RequestMapping("/saveService")
	public String saveService(@ModelAttribute("mensSalon")MensSalon mensSalon, ModelMap modelMap) {
		MensSalon savedService = service.saveMensSalon(mensSalon);
		String message="Service saved with id : "+savedService.getId();
		modelMap.addAttribute("message",message);
		return "addService";
	}
	
	@RequestMapping("/displayAllServices")
	public String displayServices(ModelMap modelMap) {
		List<MensSalon> services = service.findAllMensSalons();
		modelMap.addAttribute("services",services);
		return "displayAllServices";
	}
	
	@RequestMapping("/editService")
	public String showEdit(@RequestParam("id")int id,ModelMap modelMap) {
		MensSalon serviceGot = service.findMensSalonById(id);
		modelMap.addAttribute("service",serviceGot);
		return "updateService";
	}
	
	@RequestMapping("/updateService")
	public String updateService(@ModelAttribute("mensSalon")MensSalon mensSalon,ModelMap modelMap) {
		service.saveMensSalon(mensSalon);
		List<MensSalon> services = service.findAllMensSalons();
		modelMap.addAttribute("services",services);
		return "displayAllServices";
	}
	
	@RequestMapping("/deleteService")
	public String deleteService(@RequestParam("id")int id,ModelMap modelMap) {
		MensSalon m=new MensSalon();
		m.setId(id);
		service.deleteMensSalon(m);
		List<MensSalon> services = service.findAllMensSalons();
		modelMap.addAttribute("services",services);
		return "displayAllServices";
	}
}
