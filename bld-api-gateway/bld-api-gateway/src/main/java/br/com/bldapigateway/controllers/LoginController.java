package br.com.bldapigateway.controllers;

import br.com.bldapigateway.entities.models.EstablishmentNewUserDto;
import br.com.bldapigateway.entities.models.EstablishmentUserDto;
import br.com.bldapigateway.entities.models.EstablishmentUserLoginDto;
import br.com.bldapigateway.services.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.awt.*;

@Log4j2
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    @Autowired
    private LoginService loginService;
    //POST
    @PostMapping("login")
    public ResponseEntity<EstablishmentUserDto> login(@RequestBody EstablishmentUserLoginDto establishmentUserLoginDto){

        return this.loginService.login(establishmentUserLoginDto);
    }
    @PostMapping("new-account")
    public ResponseEntity<EstablishmentUserDto> newUser(@RequestBody EstablishmentNewUserDto establishmentUserLoginDto) throws ValidationException {
        return this.loginService.newUser(establishmentUserLoginDto);
    }
    //GET
    //PUT
    //DELETE
}
