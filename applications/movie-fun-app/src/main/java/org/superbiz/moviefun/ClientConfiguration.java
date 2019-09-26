package org.superbiz.moviefun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.superbiz.moviefun.movieapi.movies.MoviesClient;

@Configuration
public class ClientConfiguration {

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public MoviesClient moviesClient(@Value("${movies.url}") String movieUrl, RestOperations restOperations) {
        return new MoviesClient(movieUrl, restOperations);
    }
}
