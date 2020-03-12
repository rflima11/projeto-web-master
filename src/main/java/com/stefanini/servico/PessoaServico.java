package com.stefanini.servico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PessoaDao;
import com.stefanini.dto.PessoaDto;
import com.stefanini.model.Pessoa;
import com.stefanini.parsers.PessoaParserDTO;

/**
 * 
 * Classe de servico, as regras de negocio devem estar nessa classe
 * 
 * @author joaopedromilhome
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PessoaServico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private PessoaDao dao;
	
	@Inject
	private PessoaParserDTO parser;

	/**
	 * Salvar os dados de uma Pessoa
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Pessoa salvar(@Valid PessoaDto pessoa) {
		return dao.salvar(parser.toEntity(pessoa));
	}

	/**
	 * Atualizar o dados de uma pessoa
	 */
//	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Pessoa atualizar(@Valid PessoaDto pessoa) {
		return dao.atualizar(parser.toEntity(pessoa));
	}

	/**
	 * Remover uma pessoa pelo id
	 */
//	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(@Valid Long id) {
		dao.remover(id);
	}

	/**
	 * Buscar uma lista de Pessoa
	 */
	
	
//	@Override
	public Optional<List<Pessoa>> getList() {
		List<PessoaDto> pessoas = parser.toDtoList(dao.getList().get());
		return Optional.of(parser.toEntityList(pessoas));
	}
	
	

	/**
	 * Buscar uma Pessoa pelo ID
	 */
//	@Override
	public Optional<Pessoa> encontrar(Long id) {
		PessoaDto pessoaDto = parser.toDTO(dao.encontrar(id).get());
		return Optional.of(parser.toEntity(pessoaDto));
	}
	
	public Optional<List<Pessoa>> getListParametros(@Valid PessoaDto pessoa) {
		List<PessoaDto> pessoas = parser.toDtoList(dao.getListParametros("DF").get());
		return Optional.of(parser.toEntityList(pessoas));
	}

}
