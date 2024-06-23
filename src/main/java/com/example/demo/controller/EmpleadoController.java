package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.AreaEntity;
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
	
	@GetMapping("/registrar_empleado")
	public String showResgistrarEmpleado (Model model){
		List<AreaEntity>listaAreas = areaRepository.findAll();
		model.addAttribute("listaAreas", listaAreas);
		model.addAttribute("empleado", new EmpleadoEntity());
		return "registrar_empleado";
	}	
	
	@PostMapping("/registrar_empleado")
	public String registrarEmpleado (Model model,@ModelAttribute EmpleadoEntity empleado) {
		empleadoRepository.save(empleado);
		return "redirect:/listar";
		
	}
	//Buscar empelado por id
	/*@GetMapping"/detalle_empleado/{id}")
	public String verEmpleado (Model model,@PathVariable("Id") String id) {
		EmpleadoEntity empleadoEncontrado = repository.findById.get();
		model.addAttribute("empleado", empleadoEncontrado);
		return "detalle_empleado";
	}*/
	
	@GetMapping("/detalle_empleado/{id}")
	public String verUsuario(Model model, @PathVariable("id")String id) {
		EmpleadoEntity empleadoEncontrado = empleadoRepository.findById(id).get();
		model.addAttribute("empleado",empleadoEncontrado);
		return "detalle_empleado";
		
	}
	
	@GetMapping("/editar_empleado/{id}")
	public String showActualizarEmpleado(Model model, @PathVariable("id")String id) {
		EmpleadoEntity empleadoEncontrado = empleadoRepository.findById(id).get();
		List<AreaEntity>listaAreas = areaRepository.findAll();
		model.addAttribute("listaAreas", listaAreas);
		model.addAttribute("empleado",empleadoEncontrado);
		return "editar_empleado";
		
	}
	
	@PostMapping("/editar_empleado/{id}")
	public String actualizarEmpleado (Model model,@ModelAttribute EmpleadoEntity empleado) {
		empleadoRepository.save(empleado);
		
		return "redirect:/listar";
		
	}
	
	@GetMapping("/delete/{id}")
	public String eliminarUsuario(@PathVariable("id")String id) {
		empleadoRepository.deleteById(id);
		return "redirect:/listar";
	}
	

}
