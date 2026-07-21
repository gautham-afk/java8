package com.example.employee.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, Employee> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEmployee(Employee employee) {

        kafkaTemplate.send("employee-created", employee);

    }

}