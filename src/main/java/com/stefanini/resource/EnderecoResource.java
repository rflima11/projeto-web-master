package com.stefanini.resource;

import javax.inject.Inject;
import javax.validation.Valid;
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

import com.stefanini.dto.EnderecoDto;
import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import com.stefanini.servico.EnderecoServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@Path(value = "enderecos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {

	
	@Inject
	private EnderecoServico enderecoServico;
	
	@ApiOperation(
			  value = "Lista todos os endereços", 
			  produces = MediaType.APPLICATION_JSON)
	@GET
	public Response obterListaEndereco() {
		return Response.ok(enderecoServico.getList().get()).build();
	}
	
	@ApiOperation(
			  value = "Salva um novo endereço", 
			  consumes = MediaType.APPLICATION_JSON, 
			  produces = MediaType.APPLICATION_JSON)
	@POST
	public Response salvarEndereco(Endereco entity) {
		return Response.ok(enderecoServico.salvar(entity)).build();
	}
	
	@ApiOperation(
			  value = "Atualiza um endereço", 
			  consumes = MediaType.APPLICATION_JSON, 
			  produces = MediaType.APPLICATION_JSON)
	@PUT
	public Response alterarPerfil(@Valid Endereco entity) {
		return Response.ok(enderecoServico.atualizar(entity)).build();
	}
	
	@ApiOperation(
			  value = "Deleta um endereço")
	@DELETE
	@Path("{id}")
	public Response deletarEndereco(@PathParam("id") long id) {
		enderecoServico.remover(id);
		return Response.ok().build();
	}
	
	@ApiOperation(
			  value = "Procura um endereço por ID",  
			  produces = MediaType.APPLICATION_JSON)
	@GET
	@Path("{id}")
	public Response procurarPorId(@PathParam("id") long id) {
		return Response.ok(enderecoServico.encontrar(id).get()).build();
	}
	
	@ApiOperation(
			  value = "Procura um endereço por parâmetros", 
			  consumes = MediaType.APPLICATION_JSON, 
			  produces = MediaType.APPLICATION_JSON)
	@GET
	@Path("parametros")
	public Response getListAll(@Valid EnderecoDto endereco) {
		return Response.ok(enderecoServico.getListParametros(endereco).get()).build();
	}

}
