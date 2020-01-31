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

import com.lucas.pdv.backend.domains.Venda;
import com.lucas.pdv.backend.services.VendaService;

@CrossOrigin
@RestController
@RequestMapping(value="/vendas")
public class VendaResource {
	
	@Autowired
	private VendaService service;
	
	@GetMapping
	public ResponseEntity<List<Venda>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Venda obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value="/create")
	public Venda create(@RequestBody Venda venda) {
		return service.create(venda);
	}
	

	@RequestMapping(value="{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id){
		String msg = service.delete(id); 
		
		return ResponseEntity.ok().body(msg);
	}
	
	
	// filtros      /search/?nome=narcos
	@RequestMapping(value="**/", method=RequestMethod.POST)
	public ResponseEntity<List<Venda>> filterDescricao(@RequestParam(value = "nomeProduto") String nome){
		
		List<Venda> obj = service.filterNomeProduto(nome);
		
		return ResponseEntity.ok().body(obj);
	}
	
}















