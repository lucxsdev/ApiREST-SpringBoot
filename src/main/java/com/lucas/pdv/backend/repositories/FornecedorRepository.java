package com.lucas.pdv.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lucas.pdv.backend.domains.Fornecedor;


@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

	@Query("select f from Fornecedor f where f.nome like %?1%")
	List<Fornecedor> findFornecedorbyNome(String nome);
}
