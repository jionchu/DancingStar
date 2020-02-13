package com.jyami.dancingstar.config.errorHandler;

import com.jyami.dancingstar.config.exception.ClientException;
import com.jyami.dancingstar.config.exception.RedirectException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.rmi.ServerException;

/**
 * Created by jyami on 2020/02/13
 */

@Slf4j
public class DancingErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return super.hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = response.getStatusCode();
        if (statusCode.is3xxRedirection()) {
            String errorMessage = String.format("[3XXRedirection Exception] %s", response.getRawStatusCode());
            log.error(errorMessage);
            throw new RedirectException(errorMessage);
        }

        if (statusCode.is4xxClientError()) {
            String errorMessage = String.format("[4xxClient Exception] %s", response.getRawStatusCode());
            log.error(String.valueOf(response.getBody()));
            log.error(String.valueOf(response.getRawStatusCode()));
            log.error(String.valueOf(response.getStatusCode()));
            throw new ClientException(errorMessage);
        }

        String errorMessage = String.format("[5xxServer Exception] %s", response.getRawStatusCode());
        log.error(errorMessage);
        throw new ServerException(errorMessage);
    }

}