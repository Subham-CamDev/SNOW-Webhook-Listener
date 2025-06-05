package com.example.subham.servicenow.firstWebhookListener.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.subham.servicenow.firstWebhookListener.model.WebhookPayload;

@Service
@Slf4j
public class WebhookService {

    //private static final Logger log = LoggerFactory.getLogger(WebhookService.class);

//    public void handleIncidentWebhook(IncidentPayload payload) {
//        System.out.println("===== Received Incident Data =====");
//        System.out.println("Incident ID       : " + payload.getIncidentId());
//        System.out.println("Record Sys ID     : " + payload.getRecordSysId());
//        System.out.println("Caller ID         : " + payload.getCallerId());
//        System.out.println("Caller Name       : " + payload.getCallerName());
//        System.out.println("Created On        : " + payload.getDate());
//        System.out.println("Created By        : " + payload.getCreatedBy());
//        System.out.println("Category          : " + payload.getCategory());
//        System.out.println("State             : " + payload.getState());
//        System.out.println("Priority          : " + payload.getPriority());
//        System.out.println("Impact            : " + payload.getImpact());
//        System.out.println("Updated By        : " + payload.getUpdatedBy());
//        System.out.println("Updated On        : " + payload.getUpdatedOn());
//        System.out.println("Short Description : " + payload.getShortDescription());
//        System.out.println("Description       : " + payload.getDescription());
//        System.out.println("=================================");
//    }
//
//    public void handleRequestWebhook(RequestWebhookPayload payload)
//    {
//        System.out.println("=========  Received Details =========");
//
//        if(payload.getRequest() != null) {
//            System.out.println("==== Request Details ====");
//            System.out.println("Record Sys ID      : " + payload.getRequest().getSys_id());
//            System.out.println("Request Number     : " + payload.getRequest().getNumber());
//            System.out.println("Requested For      : " + payload.getRequest().getRequested_for());
//            System.out.println("Created By         : " + payload.getRequest().getCreated_by());
//            System.out.println("Opened At          : " + payload.getRequest().getOpened_at());
//            System.out.println("Opened By          : " + payload.getRequest().getOpened_by());
//            System.out.println("Updated on         : " + payload.getRequest().getUpdated_on());
//            System.out.println("Updated by         : " + payload.getRequest().getUpdated_by());
//            System.out.println("Approval Status    : " + payload.getRequest().getApproval());
//            System.out.println("State              : " + payload.getRequest().getState());
//            System.out.println("Stage              : " + payload.getRequest().getStage());
//            System.out.println("Assigned to        : " + payload.getRequest().getAssigned_to());
//            System.out.println("Short Description  : " + payload.getRequest().getShort_description());
//            System.out.println("Description        : " + payload.getRequest().getDescription());
//            System.out.println("Comments           : " + payload.getRequest().getComments());
//            System.out.println("----------------------------------");
//        }
//
//        if (payload.getRequestedItem() != null) {
//            System.out.println("==== Requested Item ====");
//            printItem(payload.getRequestedItem());
//        }
//
//        if (payload.getRequestedItems() != null && !payload.getRequestedItems().isEmpty()) {
//            System.out.println("==== Requested Items ====");
//            for (RequestedItemDTO item : payload.getRequestedItems()) {
//                printItem(item);
//            }
//        }
//    }
//
//    private void printItem(RequestedItemDTO item) {
//        System.out.println("Record Sys ID      : " + item.getSys_id());
//        System.out.println("Number             : " + item.getNumber());
//        System.out.println("Catelog Item       : " + item.getCat_item());
//        System.out.println("State              : " + item.getState());
//        System.out.println("Quantity           : " + item.getQuantity());
//        System.out.println("Price              : " + item.getSys_id());
//        System.out.println("Requested For      : " + item.getRequested_for());
//        System.out.println("Opened At          : " + item.getOpened_at());
//        System.out.println("Opened By          : " + item.getOpened_by());
//        System.out.println("Updated on         : " + item.getUpdated_on());
//        System.out.println("Updated by         : " + item.getUpdated_by());
//        System.out.println("Assigned To        : " + item.getAssigned_to());
//        System.out.println("Assignment Group   : " + item.getAssignment_group());
//        System.out.println("Short Description  : " + item.getShort_description());
//        System.out.println("Description        : " + item.getDescription());
//        System.out.println("Due Date           : " + item.getDue_date());
//        System.out.println("----------------------------------");
//    }

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
