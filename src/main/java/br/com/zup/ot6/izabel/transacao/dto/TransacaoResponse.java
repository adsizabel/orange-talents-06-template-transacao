package br.com.zup.ot6.izabel.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zup.ot6.izabel.transacao.entidades.Estabelecimento;
import br.com.zup.ot6.izabel.transacao.entidades.Transacao;

public class TransacaoResponse {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoResponse estabelecimento;
	private CartaoResponse cartao;
	private String cartaoId;
	private LocalDateTime efetivadaEm;

	@Deprecated
	public TransacaoResponse() {
	}

	public TransacaoResponse(Transacao transacao) {
		super();
		this.id = transacao.getId();
		this.valor = transacao.getValor();
		this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
		this.cartao = new CartaoResponse(transacao.getCartao());
		this.cartaoId = transacao.getCartao().getId();
		this.efetivadaEm = transacao.getEfetivadaEm();
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

	public String getCartaoId() {
		return cartaoId;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
}