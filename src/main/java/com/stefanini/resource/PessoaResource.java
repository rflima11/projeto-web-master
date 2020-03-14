package com.stefanini.resource;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.dto.PessoaDto;
import com.stefanini.servico.PessoaServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@Path("pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

	@Inject
	private PessoaServico pessoaServico;

	@ApiOperation(
			  value = "Lista todos as pessoas", 
			  produces = MediaType.APPLICATION_JSON)
	@GET
	public Response obterListaPessoa() {
		return Response.ok(pessoaServico.getList().get()).build();
	}

	@ApiOperation(
			  value = "Salva uma nova pessoa", 
			  consumes = MediaType.APPLICATION_JSON, 
			  produces = MediaType.APPLICATION_JSON)
	@POST
	public Response salvarPessoa(@Valid PessoaDto pessoa) {
		return Response.ok(pessoaServico.salvar(pessoa)).build();
	}
	
	@ApiOperation(
			  value = "Atualiza uma pessoa", 
			  consumes = MediaType.APPLICATION_JSON, 
			  produces = MediaType.APPLICATION_JSON)
	@PUT
	public Response alterarPessoa(@Valid PessoaDto pessoa) {
		return Response.ok(pessoaServico.atualizar(pessoa)).build();
	}
	
	@ApiOperation(
			  value = "Deleta uma pessoa por ID")
	@DELETE
	@Path("{id}")
	public Response excluirPessoa(@PathParam("id") Long id) {
		pessoaServico.remover(id);
		return Response.ok().build();
	}
	

	@ApiOperation(
			  value = "Procura uma pessoa por ID",  
			  produces = MediaType.APPLICATION_JSON)
	@GET
	@Path("{id}")
	public Response obterPessoa(@PathParam("id") Long id) {
		return Response.ok(pessoaServico.encontrar(id).get()).build();
	}
	
	@ApiOperation(
			  value = "Procura todas pessoas que residem no DF", 
			  consumes = MediaType.APPLICATION_JSON, 
			  produces = MediaType.APPLICATION_JSON)
	@GET
	@Path("df")
	public Response getListAll(@Valid PessoaDto pessoa) {
		return Response.ok(pessoaServico.getListParametros(pessoa).get()).build();
	}


}
