package com.jsp.restapiwithvalidation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.restapiwithvalidation.entity.Bottle;
import com.jsp.restapiwithvalidation.service.BottleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bottle")
public class BottleController {

	@Autowired
	BottleService ser;
	public BottleController() {
	}
	
	@PostMapping
	public ResponseEntity<Bottle> storeBottle(@Valid @RequestBody Bottle Bottle)
	{
		return new ResponseEntity<Bottle>(ser.storeBottle(Bottle), HttpStatus.CREATED);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Bottle> getBottleById(@PathVariable int id)
	{
		return new ResponseEntity<Bottle>(ser.findBottleById(id), HttpStatus.OK);
		
	}
	@GetMapping
	public ResponseEntity<List<Bottle>> getBottle()
	{
		return new ResponseEntity<>(ser.findAllBottles(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteBottle(@PathVariable int id)
	{
		ser.deleteBottleById(id);
		return new ResponseEntity<>( HttpStatus.OK);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Bottle> updateBottleById(@PathVariable int id, @Valid @RequestBody Bottle bottle)
	{
		return new ResponseEntity<Bottle>(ser.updateBottleByID(id, bottle), HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Bottle> patchBottleById(@PathVariable int id, @RequestParam String color)
	{
		return new ResponseEntity<Bottle>(ser.patchBottleByColor(id,color), HttpStatus.OK);
	}
	

}
