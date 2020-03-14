package com.stefanini.resource;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.model.PessoaPerfil;
import com.stefanini.servico.PessoaPerfilServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@Path(value = "pessoa-perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaPerfilResource {

	@Inject
	private PessoaPerfilServico pessoaServico;


	@ApiOperation(
			  value = "Lista todos as perfis e pessoas associados", 
			  produces = MediaType.APPLICATION_JSON)
	@GET
	public Response listarPessoaPerfil() {
		return Response.ok(pessoaServico.listar().get()).build();
	}
	
	@ApiOperation(
			  value = "Atrela um perfil a uma pessoa", 
			  consumes = MediaType.APPLICATION_JSON, 
			  produces = MediaType.APPLICATION_JSON)
	@POST
	public Response adicionarPessoaPerfil(PessoaPerfil entity) {
		return Response.ok(pessoaServico.salvar(entity)).build();
	}
	
	@GET
	@Path("{id}")
	public Response acharPessoaServicoPeloId(@PathParam("id") long id) {
		return Response.ok(pessoaServico).build();
	}
	
	@ApiOperation(
			  value = "Deleta uma associação de perfil e ID")
	@DELETE
	@Path("{id}")
	public Response deletarPessoaPerfil(@PathParam("id") long id) {
		pessoaServico.remover(id);
		return Response.ok().build();
	}
	
	@ApiOperation(
			  value = "Atualiza uma associação", 
			  consumes = MediaType.APPLICATION_JSON, 
			  produces = MediaType.APPLICATION_JSON)
	@PUT
	public Response atualizarPessoaPerfil(PessoaPerfil perfilPessoa) {
		return Response.ok(pessoaServico.atualizar(perfilPessoa)).build();
	}
	
}