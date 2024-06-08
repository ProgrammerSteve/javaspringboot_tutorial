package com.steven.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity) {
}
