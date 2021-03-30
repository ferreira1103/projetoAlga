package br.com.ferreira.projetoAlga.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.ferreira.projetoAlga.model.RamoAtividade;

import java.io.Serializable;
import java.util.List;

public class RamoAtividades implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	public RamoAtividades() {

	}

	public RamoAtividades(EntityManager manager) {
		this.manager = manager;
	}

//	Obter lista de Ramo de atividades (Listar) utilizando "criteriaQuery"	
	public List<RamoAtividade> pesquisar(String descricao) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);		
		Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);			
		criteriaQuery.select(root);				
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));		
		
		TypedQuery<RamoAtividade> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}
