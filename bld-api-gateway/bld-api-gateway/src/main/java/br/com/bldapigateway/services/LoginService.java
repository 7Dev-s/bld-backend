package br.com.bldapigateway.services;

import br.com.bldapigateway.entities.EstablishmentUser;
import br.com.bldapigateway.entities.models.EstablishmentNewUserDto;
import br.com.bldapigateway.entities.models.EstablishmentUserDto;
import br.com.bldapigateway.entities.models.EstablishmentUserLoginDto;
import br.com.bldapigateway.exceptions.CustomException;
import br.com.bldapigateway.repositories.EstablishmentUserRepository;
import br.com.bldapigateway.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

@Service
public class LoginService {

    @Autowired
    private EstablishmentUserRepository establishmentUserRepository;

    public ResponseEntity<EstablishmentUserDto> login(EstablishmentUserLoginDto establishmentUserLoginDto) {
        return ResponseEntity.accepted().body(
                EstablishmentUserDto.builder()
                        .email("teste@teste.com")
                        .password("Teste@2021")
                        .token("JKSJBHEKJBEKJEBN")
                        .build()
        );
    }

    public ResponseEntity<EstablishmentUserDto> newUser(EstablishmentNewUserDto establishmentUserLoginDto) throws ValidationException {

        if(this.establishmentUserRepository.existsByEmail(establishmentUserLoginDto.getEmail())){
            throw EntityValidator.customException("Usuário já existe");
        };

        EstablishmentUser establishmentUser = new EstablishmentUser();

        establishmentUser.setCnpj(establishmentUserLoginDto.getCnpj());
        establishmentUser.setRazaoSocial(establishmentUserLoginDto.getRazaoSocial());
        establishmentUser.setNumeroTelefone(establishmentUserLoginDto.getNumeroTelefone());
        establishmentUser.setEmail(establishmentUserLoginDto.getEmail());
        establishmentUser.setCep(establishmentUserLoginDto.getCep());
        establishmentUser.setLogradouro(establishmentUserLoginDto.getLogradouro());
        establishmentUser.setComplemento(establishmentUserLoginDto.getComplemento());
        establishmentUser.setNumero(establishmentUserLoginDto.getNumero());
        establishmentUser.setPontoReferencia(establishmentUserLoginDto.getPontoReferencia());
        establishmentUser.setNomeRepresentanteLegal(establishmentUserLoginDto.getNomeRepresentanteLegal());
        establishmentUser.setTelefoneRepresentanteLegal(establishmentUserLoginDto.getTelefoneRepresentanteLegal());
        establishmentUser.setPassword(establishmentUserLoginDto.getPassword());

        establishmentUser = this.establishmentUserRepository.saveAndFlush(establishmentUser);

        return ResponseEntity.ok().body(
                EstablishmentUserDto.builder()
                        .email("teste@teste.com")
                        .password("Teste@2021")
                        .token("JKSJBHEKJBEKJEBN")
                        .userId(establishmentUser.getId())
                        .build()
        );
    }
}
