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

//    @PostMapping("/webhook/incident")
//    public ResponseEntity<?> getSnowIncidentDetails(@RequestBody IncidentPayload payload)
//    {
//        service.handleIncidentWebhook(payload);
//        return ResponseEntity.ok("INCIDENT Webhook received and processed");
//    }

//    @PostMapping("/webhook/items")
//    public ResponseEntity<?> getSnowRequestedItemDetails(@RequestBody RequestedItemWebhookPayload payload)
//    {
//        service.handleRequestedItemWebhook(payload);
//        return ResponseEntity.ok("REQUESTED ITEMS Webhook received and processed");
//    }

//    @PostMapping("/webhook/serviceRequest")
//    public ResponseEntity<?> getSnowRequestDetails(@RequestBody RequestWebhookPayload payload)
//    {
//        service.handleRequestWebhook(payload);
//        return ResponseEntity.ok("REQUEST Webhook received and processed");
//    }

    @PostMapping("/webhook")
    public ResponseEntity<?> getSnowIncidentWebhook(@RequestBody WebhookPayload payload)
    {
        service.handleWebhookPayload(payload);
        return ResponseEntity.ok("Webhook received and processed");
    }
}