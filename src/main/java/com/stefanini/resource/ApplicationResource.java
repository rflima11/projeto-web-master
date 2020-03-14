package com.stefanini.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.stefanini.config.JacksonJavaTimeConfiguration;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath("/api")
public class ApplicationResource extends Application{

	public ApplicationResource() {
		 BeanConfig conf = new BeanConfig();
		    conf.setTitle("Stefanini API");
		    conf.setDescription("API para treinamento stefanini");
		    conf.setVersion("1.0.0");
		    conf.setHost("localhost:8080");
		    conf.setBasePath("/treinamento/api");
		    conf.setSchemes(new String[] { "http" });
		    conf.setResourcePackage("com.stefanini.resource");
		    conf.setScan(true);
	}
	
	@Override
	  public Set<Class<?>> getClasses() {
	      Set<Class<?>> resources = new HashSet<>();
	      
	      resources.add(JacksonJavaTimeConfiguration.class);
	      resources.add(PessoaResource.class);
	      resources.add(PerfilResource.class);
	      resources.add(EnderecoResource.class);
	      resources.add(PessoaPerfilResource.class);

	       
	      //classes do swagger...
	      resources.add(ApiListingResource.class);
	      resources.add(SwaggerSerializers.class);
	      return resources;
	   }
}
