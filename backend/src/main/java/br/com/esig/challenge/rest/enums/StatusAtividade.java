package br.com.esig.challenge.rest.enums;

public enum StatusAtividade {
	
	A_FAZER("A fazer"),
	FEITO("Feito");
	
	private String descricao;
	
	StatusAtividade(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
