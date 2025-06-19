package com.example.subham.servicenow.firstWebhookListener.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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

	@JsonProperty("attachments")
	private List<AttachmentValue> attachments;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class FieldValue {
		@JsonProperty("value")
		private String value;

		@JsonProperty("displayValue")
		private String displayValue;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class AttachmentValue
	{
		@JsonProperty("sys_id")
		private String fileSysId;

		@JsonProperty("file_name")
		private String fileName;

		@JsonProperty("content_type")
		private String fileContentType;

		@JsonProperty("size_bytes")
		private Long fileSize;

		@JsonProperty("download_link")
		private String fileDownloadLink;
	}
}
