package com.lucas.pdv.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.pdv.backend.domains.Fornecedor;
import com.lucas.pdv.backend.repositories.FornecedorRepository;
import com.lucas.pdv.backend.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository repo;
	
	public List<Fornecedor> findAll(){
		return repo.findAll();
	}
	
	public Fornecedor findById(Integer id) {
		
		Optional<Fornecedor> result = repo.findById(id);
		
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}
	
	public Fornecedor create(Fornecedor fornecedor) {

		return repo.save(fornecedor);
	}
	
	
	public Fornecedor update(Fornecedor obj, Integer id) {
		
		Fornecedor newFornecedor = findById(id);
		
		newFornecedor.setNome(obj.getNome());
		newFornecedor.setEndereco(obj.getEndereco());
		newFornecedor.setNumero(obj.getNumero());
		newFornecedor.setBairro(obj.getBairro());
		newFornecedor.setCep(obj.getCep());
		newFornecedor.setCidade(obj.getCidade());
		newFornecedor.setUf(obj.getUf());
		newFornecedor.setCpfOucnpj(obj.getCpfOucnpj());
		newFornecedor.setTelefone(obj.getTelefone());
		newFornecedor.setCelular(obj.getCelular());
		newFornecedor.setNascimento(obj.getNascimento());
		newFornecedor.setEmail(obj.getEmail());
		
		return repo.save(newFornecedor);
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
	
	public List<Fornecedor> filterNome(String nome) {
		
		List<Fornecedor> obj = repo.findFornecedorbyNome(nome);
		
		return obj;
	}
	
}














