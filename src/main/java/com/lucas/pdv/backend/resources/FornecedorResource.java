package com.lucas.pdv.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.pdv.backend.domains.Fornecedor;
import com.lucas.pdv.backend.services.FornecedorService;

@CrossOrigin
@RestController
@RequestMapping(value="/fornecedores")
public class FornecedorResource {
	
	@Autowired
	private FornecedorService service;
	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Fornecedor obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value="/create")
	public Fornecedor create(@RequestBody Fornecedor fornecedor) {
		return service.create(fornecedor);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public Fornecedor update(@RequestBody Fornecedor fornecedor, @PathVariable Integer id) {
		return service.update(fornecedor, id);
	}
	
	@RequestMapping(value="{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id){
		String msg = service.delete(id); 
		
		return ResponseEntity.ok().body(msg);
	}
	
	// filtros      /search/?nome=narcos
	@RequestMapping(value="**/", method=RequestMethod.POST)
	public ResponseEntity<List<Fornecedor>> filterNome(@RequestParam(value = "nome") String nome){
		
		List<Fornecedor> obj = service.filterNome(nome);
		
		return ResponseEntity.ok().body(obj);
	}
	
}















