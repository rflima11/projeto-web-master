package com.stefanini.servico;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PerfilDao;
import com.stefanini.dto.PerfilDto;
import com.stefanini.model.Perfil;
import com.stefanini.parsers.PerfilParserDTO;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PerfilServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PerfilDao perfilDao;
	
	@Inject
	private PerfilParserDTO parser;
	
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Perfil salvar(@Valid Perfil perfil) {	
		return perfilDao.salvar(perfil);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Perfil atualizar(@Valid Perfil perfil) {
		return perfilDao.atualizar(perfil);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(@Valid Long id) {
		perfilDao.remover(id);
	}

	public Optional<List<Perfil>> getList() {
		return perfilDao.getList();
	}

	public Optional<Perfil> encontrar(Long id) {
		return perfilDao.encontrar(id);
	}

	public Optional<List<Perfil>> getListParametros(@Valid PerfilDto perfil) {
		List<PerfilDto> perfils = parser.toDtoList(perfilDao.getListParametros(perfil).get());
		return Optional.of(parser.toEntityList(perfils));
	}
	
}
