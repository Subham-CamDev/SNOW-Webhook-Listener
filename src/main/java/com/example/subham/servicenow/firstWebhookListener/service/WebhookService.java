package com.example.subham.servicenow.firstWebhookListener.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.subham.servicenow.firstWebhookListener.model.WebhookPayload;

@Service
@Slf4j
public class WebhookService {

    public void handleWebhookPayload(WebhookPayload payload)
    {

        log.info("Received Payload: ");
        log.info("Table: {}", payload.getTable());
        log.info("Sys ID: {}", payload.getSysId());

        payload.getFields().forEach((key, fieldValue) -> {
            log.info("Field: {}, Value: {}, DisplayValue: {}", key, fieldValue.getValue(), fieldValue.getDisplayValue());
        });
    }
}
