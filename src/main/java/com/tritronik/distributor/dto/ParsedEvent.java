package com.tritronik.distributor.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParsedEvent {
    private String dateTime;
    private String username;
    private String srcIp;
    private String imei;
    private String srcUser;
    private long logTime;
    private String rawData;
    private List <String> output;
}