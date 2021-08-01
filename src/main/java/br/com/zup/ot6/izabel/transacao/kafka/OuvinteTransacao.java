package br.com.zup.ot6.izabel.transacao.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OuvinteTransacao {

    private final Logger logger = LoggerFactory.getLogger(OuvinteTransacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(Transacao transacaoMessagem) {
        logger.info("----- Nova transação! -----");
        logger.info("Id {}", transacaoMessagem.getId());
        logger.info("Valor {}", transacaoMessagem.getValor());
        logger.info("Efetuado em  {}", transacaoMessagem.getEfetivadaEm());
        logger.info("Nome do estabelecimento {}", transacaoMessagem.getEstabelecimento().getNome());
    }
}
