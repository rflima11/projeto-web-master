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

import com.stefanini.dto.PerfilDto;
import com.stefanini.model.Perfil;
import com.stefanini.servico.PerfilServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@Path(value = "perfis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilResource {
	
	@Inject 
	private PerfilServico perfilServico;
	
	@ApiOperation(
			  value = "Lista todos os endereços", 
			  produces = MediaType.APPLICATION_JSON)
	@GET
	public Response obterLista(){
		return Response.ok(perfilServico.getList().get()).build();
	}
	
	@ApiOperation(
			  value = "Salva um novo perfil", 
			  consumes = MediaType.APPLICATION_JSON, 
			  produces = MediaType.APPLICATION_JSON)
	@POST
	public Response salvarPerfil(@Valid Perfil perfil) {
		return Response.ok(perfilServico.salvar(perfil)).build();
	}
	
	@ApiOperation(
			  value = "Atualiza um perfil", 
			  consumes = MediaType.APPLICATION_JSON, 
			  produces = MediaType.APPLICATION_JSON)
	@PUT
	public Response alterarPerfil(@Valid Perfil perfil) {
		return Response.ok(perfilServico.atualizar(perfil)).build();
	}
	
	@ApiOperation(
			  value = "Deleta um perfil por ID")
	@DELETE
	@Path("{id}")
	public Response excluirPerfil(@PathParam("id") Long id) {
		perfilServico.remover(id);
		return Response.ok().build();
	}
	

	@ApiOperation(
			  value = "Encontra um perfil por ID")
	@GET
	@Path("{id}")
	public Response obterPessoa(@PathParam("id") Long id) {
		return Response.ok(perfilServico.encontrar(id).get()).build();
	}
	
	@ApiOperation(
			  value = "Encontra um perfil por parâmetros")
	@GET
	@Path("parametros")
	public Response getListAll(@Valid PerfilDto perfil) {
		return Response.ok(perfilServico.getListParametros(perfil).get()).build();
	}

}
