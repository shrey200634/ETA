package org.example.serislizer;

import io.jsonwebtoken.io.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.example.model.UserInfoDto;

import java.io.OutputStream;


public class UserInfoSerializer  implements Serializer<UserInfoDto>
{

}
