package com.lucas.pdv.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.lucas.pdv.backend.domains.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Query("select p from Produto p where p.descricao like %?1%")
	List<Produto> findProdutobyDescricao(String descricao);

}
