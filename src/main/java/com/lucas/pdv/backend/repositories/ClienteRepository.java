package com.lucas.pdv.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lucas.pdv.backend.domains.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query("select c from Cliente c where c.nome like %?1%")
	List<Cliente> findClientebyNome(String nome);
}
