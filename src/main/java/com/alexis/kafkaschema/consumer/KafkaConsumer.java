package com.alexis.kafkaschema.consumer;

import com.alexis.kafkaschema.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "${topic.name}", groupId = "${Spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Employee> consumerRecord){
        String key = consumerRecord.key();
        Employee employee = consumerRecord.value();

        log.info("Avro message received for key " + key + " Value " + employee.toString());
    }
}
