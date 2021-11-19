package br.com.bldapigateway.entities.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstablishmentUserDto {
    private String email;
    private String password;
    private String token;
    private Long userId;
}
