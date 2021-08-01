package br.com.zup.ot6.izabel.transacao.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CartaoResponse {
	@JsonProperty("id")
	private String id;
	@JsonProperty("email")
	private String email;
	
	@Deprecated
	public CartaoResponse() {}
	
	public CartaoResponse(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	
	
}
