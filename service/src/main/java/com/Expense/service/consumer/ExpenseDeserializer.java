package com.Expense.service.consumer;


import com.Expense.service.dto.Expensedto;
import org.apache.kafka.common.serialization.Deserializer;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

public class ExpenseDeserializer  implements Deserializer <Expensedto>{
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public void close() {
    }

    @Override
    public Expensedto deserialize(String arg0 , byte[]arg1 ){
        ObjectMapper objectMapper= new ObjectMapper();
        Expensedto expensedto = null;

        try{
            expensedto=objectMapper.readValue(arg1, Expensedto.class);

        }catch (Exception ex ){
            ex.printStackTrace();
        }
        return expensedto;

    }
}
