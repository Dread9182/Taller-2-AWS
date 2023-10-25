package com.mendez.API.controllers;

import com.mendez.API.models.Blanket;
import com.mendez.API.services.IRDSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rds")
public class RDSController {
	@Autowired
	private IRDSService rs;
	
	@PostMapping("/save")
	public ResponseEntity<Blanket> save(@RequestBody Blanket blanket){
		Blanket savedEntity = rs.save(blanket);
		if (savedEntity == null)
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
	}
	
	@GetMapping("/find")
	public ResponseEntity<List<Blanket>> findAll(){
		return new ResponseEntity<>(rs.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Blanket> findById(@PathVariable Long id){
		return new ResponseEntity<>(rs.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		rs.deleteById(id);
		return new ResponseEntity<>("El objeto fue eliminado correctamente", HttpStatus.ACCEPTED);
	}
	
	
}
