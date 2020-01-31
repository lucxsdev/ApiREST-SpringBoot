package com.lucas.pdv.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.pdv.backend.domains.Produto;
import com.lucas.pdv.backend.domains.Venda;
import com.lucas.pdv.backend.repositories.ProdutoRepository;
import com.lucas.pdv.backend.repositories.VendaRepository;
import com.lucas.pdv.backend.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repo;
	
	@Autowired
	private ProdutoRepository repoProduto;
	
	@Autowired
	private ProdutoService serviceProduto;
	
	
	
	public List<Venda> findAll(){
		return repo.findAll();
	}
	
	public Venda findById(Integer id) {
		
		Optional<Venda> result = repo.findById(id);
		
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}
	
	public Venda create(Venda venda) {
		
		abaterEstoque(venda.getQuantidade(), venda.getIdProduto());
		
		return repo.save(venda);
	}
	
	
	public String delete(Integer id) {
		
		try {
			repo.deleteById(id);
			
			String msg = "{msg: 'Excluido com sucesso'}";
			
			return msg;
			
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	public void abaterEstoque(Integer qtd, Integer id) {
		
		if (id != 0) {
			Produto obj = serviceProduto.findById(id);
			
			obj.setQuantidade(obj.getQuantidade() - qtd);
			
			repoProduto.save(obj);
		}
		
		
	}
	
	
	// filtros 
	
	public List<Venda> filterNomeProduto(String nomeProduto) {
		
		List<Venda> obj = repo.findVendabyNomeProduto(nomeProduto);
		
		return obj;
	}
	
}














