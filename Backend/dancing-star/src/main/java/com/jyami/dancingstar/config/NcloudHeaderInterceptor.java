package com.jyami.dancingstar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Created by jyami on 2020/02/13
 */
public class NcloudHeaderInterceptor implements ClientHttpRequestInterceptor {

    @Value("${ncloud.client.id}")
    private String clientId;

    @Value("${ncloud.client.sercret}")
    private String clientSecret;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().set("X-NCP-APIGW-API-KEY-ID", clientId);
        request.getHeaders().set("X-NCP-APIGW-API-KEY", clientSecret);
        request.getHeaders().setContentType(MediaType.MULTIPART_FORM_DATA);
        return execution.execute(request, body);
    }
}