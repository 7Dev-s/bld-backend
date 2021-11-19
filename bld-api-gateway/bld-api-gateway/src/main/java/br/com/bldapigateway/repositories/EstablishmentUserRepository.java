package br.com.bldapigateway.repositories;

import br.com.bldapigateway.entities.EstablishmentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentUserRepository extends JpaRepository<EstablishmentUser, Long> {
    boolean existsByEmail(String email);
}
