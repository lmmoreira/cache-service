package br.cacheserviceweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.cacheservice.annotation.Cache;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.cacheserviceweb.domain.Cidade;
import br.cacheserviceweb.domain.Usuario;

@Component
@Scope("session")
public class CacheServiceController {

	@Cache(name="cidadesCache", scope="local")
	public List<Cidade> getCidades() {
		
		List<Cidade> cidades = new ArrayList<Cidade>();
		cidades.add(new Cidade("São Paulo"));
		cidades.add(new Cidade("Rio de Janeiro"));
		System.out.println("Method Cidades Runned");
		return cidades;
		
	}

	@Cache(name="usuariosCache", scope="local")
	public List<Usuario> getUsuarios() {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("lm.moreira"));
		usuarios.add(new Usuario("leosjc"));
		System.out.println("Method Users Runned");
		return usuarios;
		
	}

}
