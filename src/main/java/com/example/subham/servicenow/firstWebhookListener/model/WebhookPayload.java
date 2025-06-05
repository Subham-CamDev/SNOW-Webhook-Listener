package com.example.subham.servicenow.firstWebhookListener.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebhookPayload {

	@JsonProperty("table")
	private String table;

	@JsonProperty("sys_id")
	private String sysId;

	@JsonProperty("fields")
	private Map<String, FieldValue> fields;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class FieldValue {
		@JsonProperty("value")
		private String value;

		@JsonProperty("displayValue")
		private String displayValue;
	}
}
