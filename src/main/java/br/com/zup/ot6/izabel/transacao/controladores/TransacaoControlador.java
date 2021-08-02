package br.com.zup.ot6.izabel.transacao.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.ot6.izabel.transacao.dto.TransacaoResponse;
import br.com.zup.ot6.izabel.transacao.entidades.Cartao;
import br.com.zup.ot6.izabel.transacao.entidades.Transacao;
import br.com.zup.ot6.izabel.transacao.repositorios.CartaoRepositorio;
import br.com.zup.ot6.izabel.transacao.repositorios.TransacaoRepositorio;

@RestController
public class TransacaoControlador {

	private TransacaoRepositorio transacaoRepositorio;
	private CartaoRepositorio cartaoRepositorio;
	
	@Autowired	
	public TransacaoControlador(TransacaoRepositorio transacaoRepositorio,
			CartaoRepositorio cartaoRepositorio) {
		super();
		this.transacaoRepositorio = transacaoRepositorio;
		this.cartaoRepositorio = cartaoRepositorio;
	}

	@GetMapping(value = "/transacoes/{id}")
	public ResponseEntity<?> listarTransacoes(@PathVariable("id") String id,
			@PageableDefault(sort = "efetivadaEm", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		Cartao cartao = cartaoRepositorio.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	
		Page<Transacao> transacoes = transacaoRepositorio.findAllByCartaoId(paginacao, cartao.getId());

		List<TransacaoResponse> transacoesResponses = new ArrayList<TransacaoResponse>();

		transacoes.forEach(transacao -> transacoesResponses.add(new TransacaoResponse(transacao)));
	
		return ResponseEntity.ok(transacoesResponses);
	}

}
