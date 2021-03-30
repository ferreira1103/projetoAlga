package br.com.ferreira.projetoAlga.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ferreira.projetoAlga.model.Empresa;

public class SchemaGeneration {
	
	public static void main(String[] args) {	
		
		System.out.println("#1. Obter Entity Manager Factory");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
		
		System.out.println("#2. Obter Entity Manager");

		EntityManager em = emf.createEntityManager();
		
		System.out.println("#3. Obter Lista de empresas - Acesso ao banco de dados");

		List<Empresa> lista = em.createQuery("from Empresa", Empresa.class)
				.getResultList();
		
		System.out.println(lista);
		
		em.close();
		emf.close();
	}

}