package com.example.deserializer;

import com.example.entities.UserInfoDto;
import org.apache.kafka.common.serialization.Deserializer;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {

    private final ObjectMapper objectMapper = new ObjectMapper(); // Reuse instance

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public UserInfoDto deserialize(String topic, byte[] data) {
        if (data == null) return null;
        try {
            return objectMapper.readValue(data, UserInfoDto.class); // Deserialize to DTO
        } catch (Exception ex) {
            System.err.println("Could not deserialize: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void close() {}
}