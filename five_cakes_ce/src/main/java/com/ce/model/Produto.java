package com.ce.model;

import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="produto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome_produto")
	private String nome;
	
	@Column(name = "qt_estoque")
	private Integer qtEstoque;
	
	@Column(name = "valor")
	private BigInteger valor;
	
	@Column(name = "data_validade")
	private Date validade;
	
	@Column(name = "codigo_barra")
	private String codBarra;

}
