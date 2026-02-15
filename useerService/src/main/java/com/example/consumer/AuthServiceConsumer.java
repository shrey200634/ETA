package com.example.consumer;

import com.example.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class AuthServiceConsumer {

    private UserRepo userRepo;


    @Autowired
    AuthServiceConsumer(UserRepo userRepo){
        this.userRepo=userRepo;

    }

   // @KafkaListener(topics="${spring.kafka.topic-json.name}", groupId="${userinfo-consumer-group}")
//    public void listen(Object eventData){
//        try{
//
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
}
