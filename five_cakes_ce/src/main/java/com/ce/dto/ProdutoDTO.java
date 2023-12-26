package com.ce.dto;

import java.math.BigInteger;
import java.util.Date;

import com.ce.model.Produto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoDTO {

	private Long id;
	private String nome;
	private Integer qtEstoque;
	private BigInteger valor;
	private Date validade;
	private String codBarra;
	
	public ProdutoDTO(Produto entity) {
		super();
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.qtEstoque = entity.getQtEstoque();
		this.valor = entity.getValor();
		this.validade = entity.getValidade();
		this.codBarra = entity.getCodBarra();
	}
	
	
	
}
