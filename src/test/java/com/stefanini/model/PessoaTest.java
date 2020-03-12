package com.stefanini.model;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.junit.Test;

public class PessoaTest {
	
	
	String uf = "Rodolfo";

@Inject
protected EntityManager em;
	
	public List<Pessoa> getList(String nome){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> query = criteriaBuilder.createQuery(Pessoa.class);
		query.from(Pessoa.class); 
		TypedQuery<Pessoa> typedQuery = em.createQuery(query);
		
		
		return typedQuery.getResultList();
	}
	
	
	
	}

