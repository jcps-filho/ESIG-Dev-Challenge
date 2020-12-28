package br.com.esig.challenge.rest.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Where;

import br.com.esig.challenge.rest.enums.StatusAtividade;

@Entity
@Where(clause = "excluido = 0")
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	private StatusAtividade status;
	private int excluido;
	private Date data;
	
	public Atividade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Atividade(Integer id, String descricao, StatusAtividade status, int excluido) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.status = status;
		this.excluido = excluido;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public StatusAtividade getStatus() {
		return status;
	}
	
	public void setStatus(StatusAtividade status) {
		this.status = status;
	}
	
	public int getExcluido() {
		return excluido;
	}
	
	public void setExcluido(int excluido) {
		this.excluido = excluido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
