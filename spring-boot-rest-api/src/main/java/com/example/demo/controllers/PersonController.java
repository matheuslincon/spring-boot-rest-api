package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.vo.v1.PersonVO;
import com.example.demo.services.PersonServices;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@GetMapping
	public List<PersonVO> findAll() {
		return service.findAll();
	}
		
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable Long id) throws Exception {
		return service.findById(id);
	}
	
	@PostMapping
	public PersonVO create(@RequestBody PersonVO person) throws Exception {
		return service.create(person);
	}
	
	@PatchMapping
	public PersonVO update(@RequestBody PersonVO person) throws Exception {
		return service.update(person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
