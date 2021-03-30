package br.com.ferreira.projetoAlga.repository;


import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ferreira.projetoAlga.model.Empresa;

public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public Empresas() {

	}

	public Empresas(EntityManager manager) {
		this.manager = manager;
	}

//	Busca por identificador (Consultar)
	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}

//	Obter lista de empresas	(Listar) utilizando "JPQL"
	public List<Empresa> pesquisar(String nome) {
		String jpql = "from Empresa where nomeFantasia like :nomeFantasia";
		
		TypedQuery<Empresa> query = manager
				.createQuery(jpql, Empresa.class);
		
		query.setParameter("nomeFantasia", nome + "%");
		
		return query.getResultList();
	}

//	Salvar uma empresa (Incluir)
	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

//	Remover empresa (Excluir)	
	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}
}