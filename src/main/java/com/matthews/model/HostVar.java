package com.matthews.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HostVar implements HostOneOf {
    private String var;
    private String description;
    private String value;
}
