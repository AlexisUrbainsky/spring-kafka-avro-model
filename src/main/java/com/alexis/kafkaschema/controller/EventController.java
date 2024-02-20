package com.alexis.kafkaschema.controller;

import com.alexis.kafkaschema.dto.Employee;
import com.alexis.kafkaschema.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private KafkaProducer producer;


    @PostMapping
    public String sendEmployee(@RequestBody Employee employee){
        producer.send(employee);
        return "Message published";
    }

}
