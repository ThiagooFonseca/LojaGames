package com.generation.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.games.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	
	public List<Produtos>findAllByNomeContainingIgnoreCase(@Param("nome")String nome);
	
	public List<Produtos>findAllByPrecoLessThan(@Param("menorPreco")double preco);
	
	public List<Produtos>findAllByPrecoGreaterThan(@Param("maiorPreco")double preco);
}
