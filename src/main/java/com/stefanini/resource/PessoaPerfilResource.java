package com.stefanini.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.servico.PessoaPerfilServico;

@Path(value = "pessoa-perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaPerfilResource {

	@Inject
	private PessoaPerfilServico pessoaServico;


	@GET
	public Response listarPessoaPerfil() {
		return Response.ok(pessoaServico.listar().get()).build();
	}
}