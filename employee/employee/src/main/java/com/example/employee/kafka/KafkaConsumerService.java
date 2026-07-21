package com.example.employee.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;

@Service
public class KafkaConsumerService {

    @KafkaListener(
            topics = "employee-created",
            groupId = "employee-group")
    public void consume(Employee employee) {

        System.out.println("=================================");
        System.out.println("Employee received from Kafka");
        System.out.println(employee);
        System.out.println("=================================");
    }
}