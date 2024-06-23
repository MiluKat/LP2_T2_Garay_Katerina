package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.AreaRepository;
import com.example.demo.repository.EmpleadoRepository;

@Controller
public class EmpleadoController {
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping ("/listar")
	public String listarEmpleado (Model model) {
		List<EmpleadoEntity> listaEmpleados = empleadoRepository.findAll();
		model.addAttribute("listaEmpleados", listaEmpleados);
		return "home";
	}
}
