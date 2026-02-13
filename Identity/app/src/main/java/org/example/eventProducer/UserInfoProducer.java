package org.example.eventProducer;

import lombok.AllArgsConstructor;
import org.example.model.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserInfoProducer
{
     final KafkaTemplate<String , UserInfoDto> kafkaTemplate;


     @Autowired
     UserInfoProducer(KafkaTemplate <String , UserInfoDto>kafkaTemplate){
         this.kafkaTemplate=kafkaTemplate;

     }


}
