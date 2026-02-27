package org.example.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.example.entities.UserInfo;


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter

public class UserInfoDto extends UserInfo
{
    @NonNull
    private String firstName ;

    private String lastName;

    private Long phoneNumber ;

    private String email;

}
