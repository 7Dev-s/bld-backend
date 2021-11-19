package br.com.bldapigateway.entities.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstablishmentNewUserDto {
    private String cnpj;
    private String razaoSocial;
    private String numeroTelefone;
    private String email;
    private String cep;
    private String logradouro;
    private String complemento;
    private Long numero;
    private String pontoReferencia;
    private String nomeRepresentanteLegal;
    private String telefoneRepresentanteLegal;
    private String password;
}
