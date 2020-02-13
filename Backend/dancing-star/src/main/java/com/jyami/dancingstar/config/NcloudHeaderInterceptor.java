package com.jyami.dancingstar.config;

import lombok.RequiredArgsConstructor;
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

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().set("X-NCP-APIGW-API-KEY-ID", "msomceoj8x");
        request.getHeaders().set("X-NCP-APIGW-API-KEY", "1bRKJWvdbyBZP22XFpXTQ7KuDZu3WnHhCw3b5VYe");
        request.getHeaders().setContentType(MediaType.MULTIPART_FORM_DATA);
        return execution.execute(request, body);
    }
}