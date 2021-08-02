package br.com.zup.ot6.izabel.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.transacao.entidades.Transacao;

public class TransacaoMessageDTO {
	@JsonProperty("id")
	private String id;
	@JsonProperty("valor")
	private BigDecimal valor;
	@JsonProperty("estabelecimento")
	private EstabelecimentoMensagemDTO estabelecimento;
	@JsonProperty("cartao")
	private CartaoMensagemDTO cartao;
	@JsonProperty("efetivadaEm")
	private LocalDateTime efetivadaEm;

	@Deprecated
	public TransacaoMessageDTO() {
	}

	public TransacaoMessageDTO(String id, BigDecimal valor, EstabelecimentoMensagemDTO estabelecimento, CartaoMensagemDTO cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public Transacao converterParaEntidade() {
		return new Transacao(id, valor, estabelecimento.converterParaEntidade(), cartao.converterParaEntidade(), efetivadaEm);
	}
	
	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoMensagemDTO getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoMensagemDTO getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
}
