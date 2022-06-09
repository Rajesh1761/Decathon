package com.kuehen.nagel.decathlon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AthleticResult {
    private String name;
    private int score;
    private int ranking;
}
