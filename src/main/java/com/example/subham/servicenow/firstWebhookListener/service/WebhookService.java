package com.example.subham.servicenow.firstWebhookListener.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.subham.servicenow.firstWebhookListener.model.WebhookPayload;
import java.util.List;

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

        if (payload.getAttachments() != null && !payload.getAttachments().isEmpty()) {
            log.info("====Attached File Details====");
            for (WebhookPayload.AttachmentValue attachment : payload.getAttachments()) {
                log.info("Name : {}", attachment.getFileName());
                log.info("Size in bytes : {}", attachment.getFileSize());
                log.info("File Sys ID : {}", attachment.getFileSysId());
                log.info("File Download Link : {}", attachment.getFileDownloadLink());
            }
        }
    }
}
