package br.com.zup.ot6.izabel.transacao.dto;

import br.com.zup.ot6.izabel.transacao.entidades.Cartao;

public class CartaoResponse {

	private String id;
	private String email;
	
	@Deprecated
	public CartaoResponse() {}

	public CartaoResponse(Cartao cartao) {
		super();
		this.id = cartao.getId();
		this.email = cartao.getEmail();
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	
	
}
