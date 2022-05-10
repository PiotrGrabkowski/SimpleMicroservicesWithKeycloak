package pl.grabkowski.gatewaymicroservices.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrations;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;


@Configuration
public class KeycloakConfig {

    @Bean
    public ReactiveClientRegistrationRepository reactiveClientRegistrationRepository()
    {
        ClientRegistration clientRegistration = ClientRegistrations
                .fromIssuerLocation("http://localhost:8180/auth/realms/SpringBootMicroservice")
                .clientId("gateway-microservices")
                .clientSecret("b78989a6-754d-4ebe-b7ec-21cabee8a04d")
                .registrationId("keycloak")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .tokenUri("http://localhost:8180/auth/realms/SpringBootMicroservice/protocol/openid-connect/token")
                .authorizationUri("http://localhost:8180/auth/realms/SpringBootMicroservice/protocol/openid-connect/auth")
                .userInfoUri("http://localhost:8180/auth/realms/SpringBootMicroservice/protocol/openid-connect/userinfo")
                .jwkSetUri("http://localhost:8180/auth/realms/SpringBootMicroservice/protocol/openid-connect/certs")
                .userNameAttributeName("preferred_username")
                .build();
        return new InMemoryReactiveClientRegistrationRepository(clientRegistration);


    }
}
