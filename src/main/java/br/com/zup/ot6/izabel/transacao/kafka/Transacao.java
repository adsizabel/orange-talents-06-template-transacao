package br.com.zup.ot6.izabel.transacao.kafka;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.transacao.dto.CartaoResponse;
import br.com.zup.ot6.izabel.transacao.dto.EstabelecimentoResponse;

public class Transacao {
	@JsonProperty("id")
	private String id;
	@JsonProperty("valor")
	private BigDecimal valor;
	@JsonProperty("estabelecimento")
	private EstabelecimentoResponse estabelecimento;
	@JsonProperty("cartao")
	private CartaoResponse cartao;
	@JsonProperty("efetivadaEm")
	private LocalDateTime efetivadaEm;

	@Deprecated
	public Transacao() {
	}

	
	public Transacao(String id, BigDecimal valor, EstabelecimentoResponse estabelecimento, CartaoResponse cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoResponse getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
}
