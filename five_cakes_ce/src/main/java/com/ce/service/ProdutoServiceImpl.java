package com.ce.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.ce.dao.ProdutoDAO;
import com.ce.dao.ProdutoService;
import com.ce.dto.ProdutoDTO;
import com.ce.model.Produto;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private ProdutoDAO dao;

	public ProdutoServiceImpl(ProdutoDAO dao) {
		this.dao = dao;
	}

	public ProdutoDTO insert(Produto entity) {

		ProdutoDTO dto = new ProdutoDTO();

		try {
			dto.setId(entity.getId());
			dto.setCodBarra(entity.getCodBarra());
			dto.setNome(entity.getNome());
			dto.setQtEstoque(entity.getQtEstoque());
			dto.setValidade(entity.getValidade());
			dto.setValor(entity.getValor());

			entity = dao.save(entity);

			return new ProdutoDTO(entity);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}

	}

	@Override
	public List<ProdutoDTO> findAll() {

		List<Produto> list = dao.findAll();
		return list.stream().map(x -> new ProdutoDTO(x)).collect(Collectors.toList());
	}

	@Override
	public Optional<Produto> findById(Long id) {

		Optional<Produto> entity;

		try {
			entity = dao.findById(id);
			return entity;
		} catch (Exception e) {
			e.getStackTrace();
			return Optional.empty();
		}

	}

	@Override
	public void delete(Long id) {

		dao.deleteById(id);

	}

	@Override
	public ProdutoDTO update(Produto entity) {

		Optional<Produto> optional = findById(entity.getId());

		ProdutoDTO dto = new ProdutoDTO();

		try {
			dto.setId(entity.getId());
			dto.setCodBarra(entity.getCodBarra());
			dto.setNome(entity.getNome());
			dto.setQtEstoque(entity.getQtEstoque());
			dto.setValidade(entity.getValidade());
			dto.setValor(entity.getValor());

			entity = dao.save(entity);
			return new ProdutoDTO(entity);
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}

	}

}
