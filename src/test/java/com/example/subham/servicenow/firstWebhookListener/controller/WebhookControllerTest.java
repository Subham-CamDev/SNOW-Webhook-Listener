package com.example.subham.servicenow.firstWebhookListener.controller;

import com.example.subham.servicenow.firstWebhookListener.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebhookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testWebhookEndpoint() {
        //Prepare the Payload
        WebhookPayload payload = new WebhookPayload();
        payload.setTable("sc_req_item");
        payload.setSysId("64432c61c3716a106dcb7c65e4013167");

        Map<String, WebhookPayload.FieldValue> fields = new HashMap<>();
        fields.put("number", new WebhookPayload.FieldValue("RITM0010030", "RITM0010030"));
        fields.put("state", new WebhookPayload.FieldValue("2", "Work in Progress"));
        fields.put("requested_for", new WebhookPayload.FieldValue("6816f79cc0a8016401c5a33be04be441", "System Administrator"));
        fields.put("short_description", new WebhookPayload.FieldValue("TUV-certified Monitor", "TUV-certified Monitor"));
        fields.put("price", new WebhookPayload.FieldValue("291.6088", "$291.6088"));

        payload.setFields(fields);

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Build request
        HttpEntity<WebhookPayload> request = new HttpEntity<>(payload, headers);

        // Call the endpoint
        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/snow/webhook",
                request,
                String.class
        );

        // Verify
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Webhook received and processed");
    }
}
