
package se.abalon;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Auto configuration for the Rest Client.
 */
@Configuration
@ConditionalOnMissingBean(RestClientInterface.class)
public class RestClientAutoConfiguration {

    @Bean
    RestClientInterface restClient(RestTemplate restTemplate) {
        return new RestClient(restTemplate);
    }

}