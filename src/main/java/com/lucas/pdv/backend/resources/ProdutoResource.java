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

import com.lucas.pdv.backend.domains.Produto;
import com.lucas.pdv.backend.services.ProdutoService;

@CrossOrigin
@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Produto obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value="/create")
	public Produto create(@RequestBody Produto produto) {
		return service.create(produto);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public Produto update(@RequestBody Produto produto, @PathVariable Integer id) {
		return service.update(produto, id);
	}
	
	@RequestMapping(value="{id}", method= RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id){
		String msg = service.delete(id); 
		
		return ResponseEntity.ok().body(msg);
	}
	
	// filtros      /search/?nome=narcos
	@RequestMapping(value="**/", method=RequestMethod.POST)
	public ResponseEntity<List<Produto>> filterDescricao(@RequestParam(value = "descricao") String nome){
		
		List<Produto> obj = service.filterDescricao(nome);
		
		return ResponseEntity.ok().body(obj);
	}

	
}















