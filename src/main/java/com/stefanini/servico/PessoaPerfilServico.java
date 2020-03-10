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

import com.stefanini.dao.PessoaPerfilDao;
import com.stefanini.model.PessoaPerfil;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PessoaPerfilServico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaPerfilDao pessoaPerfilDao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public PessoaPerfil salvar(PessoaPerfil entity) {
		return pessoaPerfilDao.salvar(entity);
	}
	
	public Optional<List<PessoaPerfil>> listar() {
		return pessoaPerfilDao.getList();
	}
	
	public PessoaPerfil encontrar(long id) {
		return pessoaPerfilDao.encontrar(id).get();
	}
	
	public void remover(long id) {
		pessoaPerfilDao.remover(id);
	}
	
	public PessoaPerfil atualizar(PessoaPerfil pessoa){
		return pessoaPerfilDao.atualizar(pessoa);
	}

}
