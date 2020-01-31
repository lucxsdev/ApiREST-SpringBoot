package com.lucas.pdv.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.pdv.backend.domains.Cliente;
import com.lucas.pdv.backend.repositories.ClienteRepository;
import com.lucas.pdv.backend.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Cliente findById(Integer id) {
		
		Optional<Cliente> result = repo.findById(id);
		
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}
	
	public Cliente create(Cliente cliente) {

		return repo.save(cliente);
	}
	
	
	public Cliente update(Cliente obj, Integer id) {
		
		Cliente newCliente = findById(id);
		
		newCliente.setNome(obj.getNome());
		newCliente.setEndereco(obj.getEndereco());
		newCliente.setNumero(obj.getNumero());
		newCliente.setBairro(obj.getBairro());
		newCliente.setCep(obj.getCep());
		newCliente.setCidade(obj.getCidade());
		newCliente.setUf(obj.getUf());
		newCliente.setCpfOucnpj(obj.getCpfOucnpj());
		newCliente.setTelefone(obj.getTelefone());
		newCliente.setCelular(obj.getCelular());
		newCliente.setNascimento(obj.getNascimento());
		newCliente.setEmail(obj.getEmail());
		
		return repo.save(newCliente);
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
	
	public List<Cliente> filterNome(String nome) {
		
		List<Cliente> obj = repo.findClientebyNome(nome);
		
		return obj;
	}
	
}














