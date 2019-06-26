package com.gemini.cloud.framework.core;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Test {
    @Value("${cloud.id}")
    private String cloudId;

    @Value("${cloud.name}")
    private String cloudName;

    public Test() {
        this.cloudId = cloudId;
        this.cloudName = cloudName;
    }
}
