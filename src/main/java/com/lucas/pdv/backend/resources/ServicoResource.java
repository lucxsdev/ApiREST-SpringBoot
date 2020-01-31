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

import com.lucas.pdv.backend.domains.Servico;
import com.lucas.pdv.backend.services.ServicoService;

@CrossOrigin
@RestController
@RequestMapping(value="/servicos")
public class ServicoResource {
	
	@Autowired
	private ServicoService service;
	
	@GetMapping
	public ResponseEntity<List<Servico>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Servico obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value="/create")
	public Servico create(@RequestBody Servico servico) {
		return service.create(servico);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public Servico update(@RequestBody Servico servico, @PathVariable Integer id) {
		return service.update(servico, id);
	}
	
	@RequestMapping(value="{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id){
		String msg = service.delete(id); 
		
		return ResponseEntity.ok().body(msg);
	}
	
	// filtros      /search/?nome=narcos
	@RequestMapping(value="**/", method=RequestMethod.POST)
	public ResponseEntity<List<Servico>> filterDescricao(@RequestParam(value = "descricao") String nome){
		
		List<Servico> obj = service.filterDescricao(nome);
		
		return ResponseEntity.ok().body(obj);
	}
	
}















