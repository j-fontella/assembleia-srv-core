package com.assembleia.kafka;

import com.assembleia.dto.response.ResultadoVotacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC = "resultado_votacao";
    private final KafkaTemplate<String, ResultadoVotacaoDTO> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, ResultadoVotacaoDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarResultado(ResultadoVotacaoDTO resultado) {
        kafkaTemplate.send(TOPIC, resultado);
    }
}
