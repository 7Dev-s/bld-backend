package br.com.bldapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;

@ComponentScan("br.com.bldapigateway.*")
@SpringBootApplication
@EntityScan("br.com.bldapigateway.*")
@EnableJpaRepositories("br.com.bldapigateway.repositories")
@Controller
@EnableCaching
public class BldApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BldApiGatewayApplication.class, args);
	}

}

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
class DataJpaConfig {
	@Bean
	public AuditorAware<String> auditor() {
		return () -> Optional.of("bld-api-gateway");
	}
}
