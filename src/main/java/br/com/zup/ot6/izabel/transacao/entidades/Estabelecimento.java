package br.com.zup.ot6.izabel.transacao.entidades;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Estabelecimento {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String cidade;
	@NotBlank
	private String endereco;
	
	@Deprecated
	public Estabelecimento() {}
	
	public Estabelecimento(String nome, String cidade, String endereco) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}
	
	
	
}
