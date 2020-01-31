package com.lucas.pdv.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lucas.pdv.backend.domains.Servico;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

	@Query("select s from Servico s where s.descricao like %?1%")
	List<Servico> findServicobyDescricao(String descricao);

}
