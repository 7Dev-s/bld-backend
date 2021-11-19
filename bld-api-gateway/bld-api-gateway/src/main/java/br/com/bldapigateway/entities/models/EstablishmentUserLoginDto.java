package br.com.bldapigateway.entities.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstablishmentUserLoginDto {
    private String email;
    private String password;
}
