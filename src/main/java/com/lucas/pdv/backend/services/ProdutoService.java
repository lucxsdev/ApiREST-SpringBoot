package com.lucas.pdv.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.pdv.backend.domains.Produto;
import com.lucas.pdv.backend.repositories.ProdutoRepository;
import com.lucas.pdv.backend.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public List<Produto> findAll(){
		return repo.findAll();
	}
	
	public Produto findById(Integer id) {
		
		Optional<Produto> result = repo.findById(id);
		
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}
	
	public Produto create(Produto produto) {
		
		produto.setValorAvista(produto.getValorCusto() * (produto.getLucroAvista() / 100) + produto.getValorCusto());
		produto.setValorAprazo(produto.getValorCusto() * (produto.getLucroAprazo() / 100) + produto.getValorCusto());
		produto.setTotalCusto(produto.getQuantidade() * produto.getValorCusto());
		produto.setTotalEstoque(produto.getQuantidade() * produto.getValorAvista());
		
		return repo.save(produto);
	}
	
	
	public Produto update(Produto obj, Integer id) {
		
		Produto newProduto = findById(id);
		
		newProduto.setDescricao(obj.getDescricao());
		newProduto.setValorCusto(obj.getValorCusto());
		newProduto.setLucroAvista(obj.getLucroAvista());
		newProduto.setLucroAvista(obj.getLucroAvista());
		newProduto.setValorAvista(obj.getValorAvista());
		newProduto.setValorAprazo(obj.getValorAprazo());
		newProduto.setQuantidade(obj.getQuantidade());
		newProduto.setUnidadeMedida(obj.getUnidadeMedida());
		newProduto.setTotalCusto(newProduto.getQuantidade() * newProduto.getValorCusto());
		newProduto.setTotalEstoque(newProduto.getQuantidade() * newProduto.getValorAvista());
		
		return repo.save(newProduto);
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
	
	// filtros 
	
	public List<Produto> filterDescricao(String descricao) {
		
		List<Produto> obj = repo.findProdutobyDescricao(descricao);
		
		return obj;
	}
	
}














