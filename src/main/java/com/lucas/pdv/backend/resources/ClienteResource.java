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

import com.lucas.pdv.backend.domains.Cliente;
import com.lucas.pdv.backend.services.ClienteService;

@CrossOrigin
@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Cliente obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value="/create")
	public Cliente create(@RequestBody Cliente cliente) {
		return service.create(cliente);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Integer id) {
		return service.update(cliente, id);
	}
	
	@RequestMapping(value="{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id){
		String msg = service.delete(id); 
		
		return ResponseEntity.ok().body(msg);
	}
	
	
	// filtros      /search/?nome=narcos
	@RequestMapping(value="**/", method=RequestMethod.POST)
	public ResponseEntity<List<Cliente>> filterNome(@RequestParam(value = "nome") String nome){
		
		List<Cliente> obj = service.filterNome(nome);
		
		return ResponseEntity.ok().body(obj);
	}

	
}















