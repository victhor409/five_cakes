package com.ce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ce.model.Produto;

@Repository
public interface ProdutoDAO extends JpaRepository<Produto, Long>{
	
	

}
