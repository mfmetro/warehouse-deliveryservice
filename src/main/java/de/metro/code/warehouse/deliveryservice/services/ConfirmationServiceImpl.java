package de.metro.code.warehouse.deliveryservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import de.metro.code.warehouse.deliveryservice.ResourceNotFoundException;

@Service
public class ConfirmationServiceImpl implements ConfirmationService {

    private static final Logger log = LoggerFactory.getLogger(ConfirmationServiceImpl.class);

    private static final String ENDPOINT = "/order/";
    
    @Value("${ORDERSERVICE_HOST:localhost}")
    private String orderServiceHost;
    
    @Override
    public void confirmOrder(final String orderId) {
        final RestTemplate restTemplate = new RestTemplate();
        final String url = orderServiceHost + ENDPOINT + orderId;
        log.info("calling " + url);

        try {
            final ResponseEntity<String> entity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
            log.info("resulting status code: " + entity.getStatusCode());
        } catch (final HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new ResourceNotFoundException();
            } else {
                throw e;
            }
        }
    }

}
