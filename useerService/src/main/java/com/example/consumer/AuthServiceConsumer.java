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
    public void listen(String eventData) {
        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        System.out.println("MESSAGE RECEIVED: " + eventData);
        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");

        try{
            userService.createOrUpdateUser(eventData);
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("AuthServiceConsumer: Exception is thrown while consuming kafka event");
        }
   }
}





