package br.com.zup.ot6.izabel.transacao.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


@Configuration
public class KafkaConfiguracao {
	
    private final KafkaProperties kafkaProperties;

    @Autowired
    public KafkaConfiguracao(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    public Map<String, Object> configuracoesConsumidor() {
        Map<String, Object> propriedades = new HashMap<>();
        propriedades.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        propriedades.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getKeyDeserializer());
        propriedades.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getConsumer().getValueDeserializer());
        propriedades.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
        propriedades.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getConsumer().getAutoOffsetReset());
        return propriedades;
    }

    @Bean
    public ConsumerFactory<String, Transacao> produtorTransacaoConsumidor() {
        StringDeserializer stringDesserializador = new StringDeserializer();
        JsonDeserializer<Transacao> jsonDesserializador = new JsonDeserializer<>(Transacao.class, false);
        return new DefaultKafkaConsumerFactory<>(configuracoesConsumidor(), stringDesserializador, jsonDesserializador);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Transacao> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Transacao> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(produtorTransacaoConsumidor());
        return factory;
    }



}