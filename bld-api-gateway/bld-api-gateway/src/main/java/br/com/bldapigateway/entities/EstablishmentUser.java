package br.com.bldapigateway.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "establhishment_id")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstablishmentUser implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", precision = 50, nullable = false, updatable = false)
    private Long id;

    @Column(name = "cnpj", length = 14, nullable = false, updatable = false)
    private String cnpj;

    @Column(name = "razao_social", length = 100, nullable = false)
    private String razaoSocial;

    @Column(name = "numero_telefone", length = 11)
    private String numeroTelefone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "cep", length = 8)
    private String cep;

    @Column(name = "logradouro", length = 100)
    private String logradouro;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "numero", precision = 15)
    private Long numero;

    @Column(name = "ponto_referencia")
    private String pontoReferencia;

    @Column(name = "nome_rep_legal")
    private String nomeRepresentanteLegal;

    @Column(name = "telefone_rep_legal")
    private String telefoneRepresentanteLegal;

    @Column(name = "password")
    private String password;

}
