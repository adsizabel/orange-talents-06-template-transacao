package br.com.zup.ot6.izabel.transacao.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.zup.ot6.izabel.transacao.dto.EstabelecimentoResponse;

@Entity
public class Transacao {
	@Id
	private String id;
	@NotNull
	private BigDecimal valor;
	@Embedded
	private Estabelecimento estabelecimento;
	@ManyToOne(cascade = CascadeType.ALL)
	private Cartao cartao;
	@NotNull
	private LocalDateTime efetivadaEm;
	
	@Deprecated
	public Transacao() {}
	
	public Transacao(String id, @NotNull BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			@NotNull LocalDateTime efetivadaEm) {
		super();
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

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
	
}
