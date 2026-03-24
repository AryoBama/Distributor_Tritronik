package com.tritronik.distributor.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParsedEvent {
    private String dateTime;
    private String username;
    private String srcIp;
    private String imei;
    private String srcUser;
    private long logTime;
    private List <String> output;
}