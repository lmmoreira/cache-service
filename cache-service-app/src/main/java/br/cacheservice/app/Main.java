package br.cacheservice.app;

import java.util.ArrayList;
import java.util.List;

import org.cacheservice.annotation.Cache;
import org.cacheservice.annotation.ClearCache;

public class Main {

	public static void main(String args[]){
		Main m = new Main();
		List<Cidade> cidades1 = m.getCidades();
		List<Cidade> cidades2 = m.getCidades();
		System.out.println(cidades1);
		System.out.println(cidades2);
		
		m.reset();
		
		List<Cidade> cidades3 = m.getCidades();
		List<Cidade> cidades4 = m.getCidades();
		System.out.println(cidades3);
		System.out.println(cidades4);
		
	}	
	
	@Cache(name="cidadesCache", scope="local")
	public List<Cidade> getCidades(){
		List<Cidade> cidades = new ArrayList<Cidade>();
		cidades.add(new Cidade("São Paulo"));
		cidades.add(new Cidade("Rio de Janeiro"));
		
		System.out.println("Method Runned");
		
		return cidades;
	}
	
	//@ClearCache(name={"cidadesCache"}, scope="local")
	@ClearCache(scope="local")
	public void reset(){
		System.out.println("Reseting");
	}
	
}
	