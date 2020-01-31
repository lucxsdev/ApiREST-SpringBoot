package com.lucas.pdv.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.pdv.backend.domains.Servico;
import com.lucas.pdv.backend.repositories.ServicoRepository;
import com.lucas.pdv.backend.services.exceptions.ObjectNotFoundException;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repo;
	
	public List<Servico> findAll(){
		return repo.findAll();
	}
	
	public Servico findById(Integer id) {
		
		Optional<Servico> result = repo.findById(id);
		
		return result.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}
	
	public Servico create(Servico servico) {
		
		servico.setValorAvista(servico.getValorCusto() * (servico.getLucroAvista() / 100) + servico.getValorCusto());
		servico.setValorAprazo(servico.getValorCusto() * (servico.getLucroAprazo() / 100) + servico.getValorCusto());
		servico.setTotalCusto(servico.getQuantidade() * servico.getValorCusto());
		
		return repo.save(servico);
	}
	
	
	public Servico update(Servico obj, Integer id) {
		
		Servico newServico = findById(id);
		
		newServico.setDescricao(obj.getDescricao());
		newServico.setValorCusto(obj.getValorCusto());
		newServico.setLucroAvista(obj.getLucroAvista());
		newServico.setLucroAvista(obj.getLucroAvista());
		newServico.setValorAvista(obj.getValorAvista());
		newServico.setValorAprazo(obj.getValorAprazo());
		newServico.setQuantidade(obj.getQuantidade());
		newServico.setTotalCusto(newServico.getQuantidade() * newServico.getValorCusto());
		
		return repo.save(newServico);
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
	
	public List<Servico> filterDescricao(String descricao) {
		
		List<Servico> obj = repo.findServicobyDescricao(descricao);
		
		return obj;
	}
}














