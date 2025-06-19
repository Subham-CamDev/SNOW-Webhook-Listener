package com.example.subham.servicenow.firstWebhookListener.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.subham.servicenow.firstWebhookListener.model.WebhookPayload;
import com.example.subham.servicenow.firstWebhookListener.service.WebhookService;

@RestController
@RequestMapping("/snow")
public class WebhookController {

    private final WebhookService service;

    public WebhookController(WebhookService service)
    {
        this.service = service;
    }

    @PostMapping("/webhook")
    public ResponseEntity<?> getSnowIncidentWebhook(@RequestBody WebhookPayload payload)
    {
        service.handleWebhookPayload(payload);
        return ResponseEntity.ok("Webhook received and processed");
    }
}