package com.example.consumer;

import com.example.entities.UserInfoDto;
import com.example.repo.UserRepo;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import tools.jackson.databind.ObjectMapper;

public class AuthServiceConsumer {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${userinfo-consumer-group}")
    public void listen(UserInfoDto eventData) { // Change String to UserInfoDto
        try {
            System.out.println("MESSAGE RECEIVED: " + eventData.getUserId());
            userService.createOrUpdateUser(eventData); // Pass the object
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("AuthServiceConsumer: Exception thrown while consuming");
        }
    }
}





