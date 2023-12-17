package com.emirhanbaran.accounts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

// If your main application is in differnt path you should use these annotations that springboot can define your beans,repo...
/*@ComponentScans(@ComponentScan("com.emirhanbaran.accounts.controller"))
//This annotation is using for scanning beans

@EnableJpaRepositories("com.emirhanbaran.accounts.repository")
///This annotation is using for scanning repositories

@EntityScan("com.emirhanbaran.model")*/
///This annotation is using for scanning model classes

@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Account Microservice Rest API Documentation",
                description = "EazyBank Accounts microservice Rest Api Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Emirhan BARAN",
                        email = "emir.baran255@gmail.com",
                        url = "https://www.linkedin.com/in/emirhanbaran0/"

                ),
                license = @License(
                        name = "Apache 2.0",
                        url="https://www.apache.org/licenses/LICENSE-2.0"
                ),
                summary = "This documentation is helping to  how to use and know Account Microservice in EazyBank Application"

        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
