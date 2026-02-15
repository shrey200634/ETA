package com.example.deserializer;

import com.example.entities.UserInfoDto;
import org.apache.kafka.common.serialization.Deserializer;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public UserInfoDto deserialize(String arg0, byte[] arg1) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfoDto user = null ;
        try{
          user = objectMapper.readValue(arg1, UserInfoDto.class );

        }catch (Exception ex){
            System.out.println(" can not deserialize ");
        }
        return user;


    }

    @Override
    public void close(){

    }



}
