package br.com.zup.ot6.izabel.transacao.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.ot6.izabel.transacao.dto.TransacaoMessageDTO;
import br.com.zup.ot6.izabel.transacao.entidades.Transacao;
import br.com.zup.ot6.izabel.transacao.repositorios.TransacaoRepositorio;

@Component
public class OuvinteTransacao {
	
	TransacaoRepositorio transacaoRepositorio;
	
	@Autowired
    public OuvinteTransacao(TransacaoRepositorio transacaoRepositorio) {
		super();
		this.transacaoRepositorio = transacaoRepositorio;
	}

	private final Logger logger = LoggerFactory.getLogger(OuvinteTransacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoMessageDTO transacaoMessagem) {
        logger.info("----- Nova transação! -----");
        logger.info("Id {}", transacaoMessagem.getId());
        logger.info("Valor {}", transacaoMessagem.getValor());
        logger.info("Efetuado em  {}", transacaoMessagem.getEfetivadaEm());
        logger.info("Nome do estabelecimento {}", transacaoMessagem.getEstabelecimento().getNome());
        
        Transacao transacao = transacaoMessagem.converterParaEntidade();
        transacaoRepositorio.save(transacao);
    }
}
