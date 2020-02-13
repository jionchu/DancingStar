package com.jyami.dancingstar.config;

import com.jyami.dancingstar.config.errorHandler.DancingErrorHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyami on 2020/02/11
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
public class NcloudRestTemplateConfig {

    private static final Duration ONE_SEC = Duration.ofMillis(1000);
    private static final Duration TWO_SEC = Duration.ofMillis(2000);

    @Bean
    public RestTemplate posRestTemplate() {
        log.debug("for pos restTemplate");
        RestTemplateBuilder danceRestTemplateBuilder = new RestTemplateBuilder().errorHandler(new DancingErrorHandler());

        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new NcloudHeaderInterceptor());

        RestTemplate restTemplate = danceRestTemplateBuilder
//                .setConnectTimeout(ONE_SEC)
//                .setReadTimeout(TWO_SEC)
                .build();

        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

}
