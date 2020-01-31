package com.lucas.pdv.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lucas.pdv.backend.domains.Venda;


@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

	@Query("select v from Venda v where v.nomeProduto like %?1%")
	List<Venda> findVendabyNomeProduto(String nomeProduto);
}
